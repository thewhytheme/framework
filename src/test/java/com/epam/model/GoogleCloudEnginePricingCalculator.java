package com.epam.model;

import java.util.Objects;

public class GoogleCloudEnginePricingCalculator {
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

    public GoogleCloudEnginePricingCalculator(String numberOfInstances, String software, String provisioningModel,
                                              String machineSeries, String machineType, boolean isGPU_Needed,
                                              String numberOfGPU, String typeOfGPU, String localSSD_Capacity,
                                              String dataCenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.software = software;
        this.provisioningModel = provisioningModel;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.isGPU_Needed = isGPU_Needed;
        this.numberOfGPU = numberOfGPU;
        this.typeOfGPU = typeOfGPU;
        this.localSSD_Capacity = localSSD_Capacity;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public boolean isGPU_Needed() {
        return isGPU_Needed;
    }

    public void setGPU_Needed(boolean GPU_Needed) {
        isGPU_Needed = GPU_Needed;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }

    public String getLocalSSD_Capacity() {
        return localSSD_Capacity;
    }

    public void setLocalSSD_Capacity(String localSSD_Capacity) {
        this.localSSD_Capacity = localSSD_Capacity;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
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
}
