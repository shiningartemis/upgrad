package cn.sora.entity;

import java.util.Date;

public class UpgradeArea {
    private Integer id;

    private String serviceName;

    private String areaCode;

    private Boolean isToLatest;

    private Integer upgradeVersion;

    private Integer codeState;

    private Integer codeCounty;

    private Integer codePoliceStation;

    private Date gmtCreate;

    private Date gmtModified;

    public UpgradeArea(Integer id, String serviceName, String areaCode, Boolean isToLatest, Integer upgradeVersion, Integer codeState, Integer codeCounty, Integer codePoliceStation, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaCode = areaCode;
        this.isToLatest = isToLatest;
        this.upgradeVersion = upgradeVersion;
        this.codeState = codeState;
        this.codeCounty = codeCounty;
        this.codePoliceStation = codePoliceStation;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UpgradeArea() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Boolean getIsToLatest() {
        return isToLatest;
    }

    public void setIsToLatest(Boolean isToLatest) {
        this.isToLatest = isToLatest;
    }

    public Integer getUpgradeVersion() {
        return upgradeVersion;
    }

    public void setUpgradeVersion(Integer upgradeVersion) {
        this.upgradeVersion = upgradeVersion;
    }

    public Integer getCodeState() {
        return codeState;
    }

    public void setCodeState(Integer codeState) {
        this.codeState = codeState;
    }

    public Integer getCodeCounty() {
        return codeCounty;
    }

    public void setCodeCounty(Integer codeCounty) {
        this.codeCounty = codeCounty;
    }

    public Integer getCodePoliceStation() {
        return codePoliceStation;
    }

    public void setCodePoliceStation(Integer codePoliceStation) {
        this.codePoliceStation = codePoliceStation;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}