package com.bhs.app.model;

import org.springframework.data.annotation.Id;

/**
 *冷凝除湿终端表
 */
public class condensate_dehumidification_terminal {
    @Id
    private Integer id;


    /**
     * 环境温度
     */
    private double ambientTemperature;
    /**
     * 采集时间
     */
    private String ambientTime;
    /**
     * 散热片温度
     */
    private double     heatSinkTemperature;
    /**
     * 冷凝片温度
     */
    private double condensateTemperature;
    /**
     * 工作状态
     */
    private String workStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(double ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public String getAmbientTime() {
        return ambientTime;
    }

    public void setAmbientTime(String ambientTime) {
        this.ambientTime = ambientTime;
    }

    public double getHeatSinkTemperature() {
        return heatSinkTemperature;
    }

    public void setHeatSinkTemperature(double heatSinkTemperature) {
        this.heatSinkTemperature = heatSinkTemperature;
    }

    public double getCondensateTemperature() {
        return condensateTemperature;
    }

    public void setCondensateTemperature(double condensateTemperature) {
        this.condensateTemperature = condensateTemperature;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}
