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

    public static GoogleCloudEnginePricingCalculator withParametersFromProperties() {
        return new GoogleCloudEnginePricingCalculator(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_NUMBER_OF_INSTANCES),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_SOFTWARE),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_PROVISIONING_MODULE),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_MACHINE_SERIES),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_MACHINE_TYPE),
                Boolean.parseBoolean(TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_GPU_STATUS)),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_GPU_NUMBER),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_GPU_TYPE),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_SSD_CAPACITY),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_DATA_CENTER_LOCATION),
                TestDataConfigReader.getEnvironmentData(DATA_CLOUD_CALCULATOR_USAGE_TERM));
    }
}
