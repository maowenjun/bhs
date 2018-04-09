package com.bhs.app.model;

import org.springframework.data.annotation.Id;

/**
 * 站点表
 */
public class site {
    @Id
    private Integer id;
    /**
     * 组端电压
     */
    private int groupEndVoltage;
    /**
     * 母线电压
     */
    private int  busbarVoltage;
    /**
     * 系统电流
     */
    private int  systemCurrent;
    /**
     * 环境温度
     */
    private double ambientTemperature;
    /**
     * SOC
     */
    private String soc;
    /**
     * 设备在线状态
     */
    private String deviceOnlineStatus;
    /**
     * 时间
     */
    private String time;
    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 站点编号
     */
    private String siteNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGroupEndVoltage() {
        return groupEndVoltage;
    }

    public void setGroupEndVoltage(int groupEndVoltage) {
        this.groupEndVoltage = groupEndVoltage;
    }

    public int getBusbarVoltage() {
        return busbarVoltage;
    }

    public void setBusbarVoltage(int busbarVoltage) {
        this.busbarVoltage = busbarVoltage;
    }

    public int getSystemCurrent() {
        return systemCurrent;
    }

    public void setSystemCurrent(int systemCurrent) {
        this.systemCurrent = systemCurrent;
    }

    public double getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(double ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getDeviceOnlineStatus() {
        return deviceOnlineStatus;
    }

    public void setDeviceOnlineStatus(String deviceOnlineStatus) {
        this.deviceOnlineStatus = deviceOnlineStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNo() {
        return siteNo;
    }

    public void setSiteNo(String siteNo) {
        this.siteNo = siteNo;
    }
}
