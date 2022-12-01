package com.epam.test;

import com.epam.model.GoogleCloudEnginePricingCalculator;
import com.epam.page.GoogleCloudEstimatedPage;
import com.epam.page.GoogleCloudHomePage;
import com.epam.service.CLoudCalculatorCreator;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleCloudBothScenariosTest extends BaseTest {
    private GoogleCloudEstimatedPage estimatedPage;
    private String estimatedListData;

    @BeforeClass(description = "opens cloud calculator page, fills the form with data from properties file and estimates price")
    public void createCalculationScenario() {
        webDriver.get("https://cloud.google.com/");
        GoogleCloudEnginePricingCalculator pricingCalculator = CLoudCalculatorCreator.withAllParametersFromProperties();
        estimatedPage =  new GoogleCloudHomePage(webDriver)
                .searchForPricingCalculator()
                .enterCalculatorPage()
                .activeComputeEngineSection()
                .setNumberOfInstances(pricingCalculator.getNumberOfInstances())
                .setSoftware(pricingCalculator.getSoftware())
                .setProvisioningModel(pricingCalculator.getProvisioningModel())
                .setInstanceType(pricingCalculator.getMachineSeries(), pricingCalculator.getMachineType())
                .addGPUs(pricingCalculator.isGPU_Needed(), pricingCalculator.getTypeOfGPU(), pricingCalculator.getNumberOfGPU())
                .setSSDCapacity(pricingCalculator.getLocalSSD_Capacity())
                .setDataCenterLocation(pricingCalculator.getDataCenterLocation())
                .setUsageTerm(pricingCalculator.getCommittedUsage())
                .estimate();
        estimatedListData = estimatedPage.findAndGetComputeEngineEstimationText();
    }

    @Test(priority = 1, description = "tests if estimation consider right virtual machine class")
    public void checkVirtualMachineClass() {
        Assert.assertTrue(estimatedListData.contains("Regular"), "Incorrect VM type");
    }

    @Test(priority = 2, description = "tests if estimation consider right instance of machine")
    public void checkInstanceType() {
        Assert.assertTrue(estimatedListData.contains("n1-standard-8"), "Incorrect instance type");
    }

    @Test(priority = 3, description = "tests if estimation consider right data center location")
    public void checkRegion() {
        Assert.assertTrue(estimatedListData.contains("Frankfurt"), "Incorrect region set up");
    }

    @Test(priority = 4, description = "tests if estimation consider right SSD capacity")
    public void checkLocalSsd() {
        Assert.assertTrue(estimatedListData.contains("2x375"), "Incorrect SSD capacity");
    }

    @Test(priority = 5, description = "tests if estimation consider right commitment term")
    public void checkCommitmentTerm() {
        Assert.assertTrue(estimatedListData.contains("1 Year"), "Incorrect commitment term");
    }

    @Test(priority = 6, description = "sends estimation on email and test cost from email with cost from cloud calculator page")
    public void checkTotalEstimatedMonthlyCostOnEquality() {
        String monthFee = "USD 4,024.56";
        String estimationFromPage = estimatedPage.getCalculatedCost();
        String estimationFromEmail = estimatedPage
                .chooseEmailEstimateOption()
                .openEmailGenerator()
                .copyLinkAndPassItToEstimatedPage()
                .sendEstimationOnEmail()
                .getEstimationSumFromEmail();
        Assert.assertEquals(estimationFromPage.contains(monthFee), estimationFromEmail.contains(monthFee),
                "cost from email does not match cost from calculator page");

    }

}
