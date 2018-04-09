package com.bhs.app.model;

import org.springframework.data.annotation.Id;

/**
 * 电池组表
 */
public class battery_pack {

    @Id
    private Integer id;
    /**
     * 站点编号
     */
    private String siteNo;
    /**
     * 组端电压
     */
    private int groupEndVoltage;
    /**
     * 单体电压
     */
    private int monomerVoltage;
    /**
     * 电池节数
     */
    private int cellNumber;
    /**
     * 电池容量
     */
    private int batteryCapacity;
    /**
     * 时间
     */
    private String time;
    /**
     * 电池组名称
     */
    private String batteryPackName;
    /**
     * 电池组编号
     */
    private String batteryPackNo;
    /**
     * 状态
     */
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteNo() {
        return siteNo;
    }

    public void setSiteNo(String siteNo) {
        this.siteNo = siteNo;
    }

    public int getGroupEndVoltage() {
        return groupEndVoltage;
    }

    public void setGroupEndVoltage(int groupEndVoltage) {
        this.groupEndVoltage = groupEndVoltage;
    }

    public int getMonomerVoltage() {
        return monomerVoltage;
    }

    public void setMonomerVoltage(int monomerVoltage) {
        this.monomerVoltage = monomerVoltage;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBatteryPackName() {
        return batteryPackName;
    }

    public void setBatteryPackName(String batteryPackName) {
        this.batteryPackName = batteryPackName;
    }

    public String getBatteryPackNo() {
        return batteryPackNo;
    }

    public void setBatteryPackNo(String batteryPackNo) {
        this.batteryPackNo = batteryPackNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
