package com.epam.service;

import com.epam.model.GoogleCloudEnginePricingCalculator;

public class CLoudCalculatorCreator {
    private static final String DATA_CLOUD_CALCULATOR_NUMBER_OF_INSTANCES = "data.calculator.number_of_instances";
    private static final String DATA_CLOUD_CALCULATOR_SOFTWARE = "data.calculator.software";
    private static final String DATA_CLOUD_CALCULATOR_PROVISIONING_MODULE = "data.calculator.provisioning_module";
    private static final String DATA_CLOUD_CALCULATOR_MACHINE_SERIES = "data.calculator.machine_series";
    private static final String DATA_CLOUD_CALCULATOR_MACHINE_TYPE = "data.calculator.machine_type";
    private static final String DATA_CLOUD_CALCULATOR_GPU_STATUS = "data.calculator.gpu";
    private static final String DATA_CLOUD_CALCULATOR_GPU_NUMBER = "data.calculator.gpu_number";
    private static final String DATA_CLOUD_CALCULATOR_GPU_TYPE = "data.calculator.gpu_type";
    private static final String DATA_CLOUD_CALCULATOR_SSD_CAPACITY = "data.calculator.ssd_capacity";
    private static final String DATA_CLOUD_CALCULATOR_DATA_CENTER_LOCATION = "data.calculator.location";
    private static final String DATA_CLOUD_CALCULATOR_USAGE_TERM = "data.calculator.usage_term";

    public static GoogleCloudEnginePricingCalculator withAllParametersFromProperties() {
        return new GoogleCloudEnginePricingCalculator.GoogleCloudEnginePricingCalculatorBuilder(
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_NUMBER_OF_INSTANCES))
                .setSoftware(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_SOFTWARE))
                .setProvisioningModel(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_PROVISIONING_MODULE))
                .setMachineSeries(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_MACHINE_SERIES))
                .setMachineType(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_MACHINE_TYPE))
                .setGPU_Needed(Boolean.parseBoolean(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_GPU_STATUS)))
                .setNumberOfGPU(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_GPU_NUMBER))
                .setTypeOfGPU(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_GPU_TYPE))
                .setLocalSSD_Capacity(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_SSD_CAPACITY))
                .setDataCenterLocation(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_DATA_CENTER_LOCATION))
                .setCommittedUsage(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_USAGE_TERM)).build();
    }
}
