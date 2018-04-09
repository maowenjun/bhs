package com.bhs.app.model;

import org.springframework.data.annotation.Id;

/**
 * 智能维护终端表
 */
public class intelligent_maintenance_terminal {
    @Id
    private Integer id;
    /**
     * 终止电压设置
     */
    private String terminationVoltageSetting;
    /**
     * 电池组编号
     */
    private String batteryPackNo;
    /**
     * 采集时间
     */
    private String acquisitionTime;
    /**
     * 充电电流
     */
    private int chargingCurrent;
    /**
     * 充电容量
     */
    private int capacityCurrent;
    /**
     * 温度
     */
    private double temperature;
     /**
     * 工作状态
     */
     private String workingCondition;
    /**
     * 固件版本号
     */
    private String firmwareVersion;
    /**
     * 充电时间
     */
    private String chargingTime;
    /**
     * 放电容量
     */
    private int dischargeCapacity;
    /**
     * 放电时间
     */
    private String dischargeTime;
    /**
     * 放电电流
     */
    private int dischargeCurrent;
    /**
     * 母线电压
     */
    private int busbarVoltage;
    /**
     * 电池电压
     */
    private int batteryVoltage;
    /**
     * 母线电压保护设置
     */
    private String busVoltageProtectionSetting;
    /**
     * 放电时间设置
     */
    private String dischargeTimeSetting;
    /**
     * 放电容量设置
     */
    private String dischargeCapacitySetting;
    /**
     * 放电电流设置
     */
    private String dischargeCurrentSetting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerminationVoltageSetting() {
        return terminationVoltageSetting;
    }

    public void setTerminationVoltageSetting(String terminationVoltageSetting) {
        this.terminationVoltageSetting = terminationVoltageSetting;
    }

    public String getBatteryPackNo() {
        return batteryPackNo;
    }

    public void setBatteryPackNo(String batteryPackNo) {
        this.batteryPackNo = batteryPackNo;
    }

    public String getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(String acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public int getChargingCurrent() {
        return chargingCurrent;
    }

    public void setChargingCurrent(int chargingCurrent) {
        this.chargingCurrent = chargingCurrent;
    }

    public int getCapacityCurrent() {
        return capacityCurrent;
    }

    public void setCapacityCurrent(int capacityCurrent) {
        this.capacityCurrent = capacityCurrent;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWorkingCondition() {
        return workingCondition;
    }

    public void setWorkingCondition(String workingCondition) {
        this.workingCondition = workingCondition;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(String chargingTime) {
        this.chargingTime = chargingTime;
    }

    public int getDischargeCapacity() {
        return dischargeCapacity;
    }

    public void setDischargeCapacity(int dischargeCapacity) {
        this.dischargeCapacity = dischargeCapacity;
    }

    public String getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(String dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public int getDischargeCurrent() {
        return dischargeCurrent;
    }

    public void setDischargeCurrent(int dischargeCurrent) {
        this.dischargeCurrent = dischargeCurrent;
    }

    public int getBusbarVoltage() {
        return busbarVoltage;
    }

    public void setBusbarVoltage(int busbarVoltage) {
        this.busbarVoltage = busbarVoltage;
    }

    public int getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(int batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getBusVoltageProtectionSetting() {
        return busVoltageProtectionSetting;
    }

    public void setBusVoltageProtectionSetting(String busVoltageProtectionSetting) {
        this.busVoltageProtectionSetting = busVoltageProtectionSetting;
    }

    public String getDischargeTimeSetting() {
        return dischargeTimeSetting;
    }

    public void setDischargeTimeSetting(String dischargeTimeSetting) {
        this.dischargeTimeSetting = dischargeTimeSetting;
    }

    public String getDischargeCapacitySetting() {
        return dischargeCapacitySetting;
    }

    public void setDischargeCapacitySetting(String dischargeCapacitySetting) {
        this.dischargeCapacitySetting = dischargeCapacitySetting;
    }

    public String getDischargeCurrentSetting() {
        return dischargeCurrentSetting;
    }

    public void setDischargeCurrentSetting(String dischargeCurrentSetting) {
        this.dischargeCurrentSetting = dischargeCurrentSetting;
    }
}
