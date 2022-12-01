package com.epam.model;

import java.util.Objects;

public class GoogleCloudEnginePricingCalculator {
    private final String numberOfInstances;
    private final String software;
    private final String provisioningModel;
    private final String machineSeries;
    private final String machineType;
    private final boolean isGPU_Needed;
    private final String numberOfGPU;
    private final String typeOfGPU;
    private final String localSSD_Capacity;
    private final String dataCenterLocation;
    private final String committedUsage;

    public GoogleCloudEnginePricingCalculator(GoogleCloudEnginePricingCalculatorBuilder builder) {
        this.numberOfInstances = builder.numberOfInstances;
        this.software = builder.software;
        this.provisioningModel = builder.provisioningModel;
        this.machineSeries = builder.machineSeries;
        this.machineType = builder.machineType;
        this.isGPU_Needed = builder.isGPU_Needed;
        this.numberOfGPU = builder.numberOfGPU;
        this.typeOfGPU = builder.typeOfGPU;
        this.localSSD_Capacity = builder.localSSD_Capacity;
        this.dataCenterLocation = builder.dataCenterLocation;
        this.committedUsage = builder.committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }


    public String getSoftware() {
        return software;
    }


    public String getProvisioningModel() {
        return provisioningModel;
    }


    public String getMachineSeries() {
        return machineSeries;
    }


    public String getMachineType() {
        return machineType;
    }


    public boolean isGPU_Needed() {
        return isGPU_Needed;
    }


    public String getNumberOfGPU() {
        return numberOfGPU;
    }


    public String getTypeOfGPU() {
        return typeOfGPU;
    }


    public String getLocalSSD_Capacity() {
        return localSSD_Capacity;
    }


    public String getDataCenterLocation() {
        return dataCenterLocation;
    }


    public String getCommittedUsage() {
        return committedUsage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoogleCloudEnginePricingCalculator that = (GoogleCloudEnginePricingCalculator) o;
        return isGPU_Needed == that.isGPU_Needed && numberOfInstances.equals(that.numberOfInstances) &&
                software.equals(that.software) && provisioningModel.equals(that.provisioningModel) &&
                machineSeries.equals(that.machineSeries) && machineType.equals(that.machineType) &&
                numberOfGPU.equals(that.numberOfGPU) && typeOfGPU.equals(that.typeOfGPU) &&
                localSSD_Capacity.equals(that.localSSD_Capacity) &&
                dataCenterLocation.equals(that.dataCenterLocation) && committedUsage.equals(that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, software, provisioningModel, machineSeries,
                machineType, isGPU_Needed, numberOfGPU, typeOfGPU,
                localSSD_Capacity, dataCenterLocation, committedUsage);
    }

    @Override
    public String toString() {
        return "GoogleCloudEnginePricingCalculator{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", software='" + software + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", isGPU_Needed=" + isGPU_Needed +
                ", numberOfGPU='" + numberOfGPU + '\'' +
                ", typeOfGPU='" + typeOfGPU + '\'' +
                ", localSSD_Capacity='" + localSSD_Capacity + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    public static class GoogleCloudEnginePricingCalculatorBuilder {
        private String numberOfInstances;
        private String software;
        private String provisioningModel;
        private String machineSeries;
        private String machineType;
        private boolean isGPU_Needed;
        private String numberOfGPU;
        private String typeOfGPU;
        private String localSSD_Capacity;
        private String dataCenterLocation;
        private String committedUsage;

        public GoogleCloudEnginePricingCalculatorBuilder(String numberOfInstances) {
            this.numberOfInstances = numberOfInstances;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setSoftware(String software) {
            this.software = software;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setProvisioningModel(String provisioningModel) {
            this.provisioningModel = provisioningModel;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setMachineSeries(String machineSeries) {
            this.machineSeries = machineSeries;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setMachineType(String machineType) {
            this.machineType = machineType;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setGPU_Needed(boolean GPU_Needed) {
            isGPU_Needed = GPU_Needed;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setNumberOfGPU(String numberOfGPU) {
            this.numberOfGPU = numberOfGPU;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setTypeOfGPU(String typeOfGPU) {
            this.typeOfGPU = typeOfGPU;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setLocalSSD_Capacity(String localSSD_Capacity) {
            this.localSSD_Capacity = localSSD_Capacity;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setDataCenterLocation(String dataCenterLocation) {
            this.dataCenterLocation = dataCenterLocation;
            return this;
        }

        public GoogleCloudEnginePricingCalculatorBuilder setCommittedUsage(String committedUsage) {
            this.committedUsage = committedUsage;
            return this;
        }

        public GoogleCloudEnginePricingCalculator build() {
            return new GoogleCloudEnginePricingCalculator(this);
        }
    }
}
