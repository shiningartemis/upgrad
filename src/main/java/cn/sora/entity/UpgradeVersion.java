package cn.sora.entity;

import java.util.Date;

public class UpgradeVersion {
    private Integer id;

    private String serviceName;

    private Integer versionNumber;

    private String versionName;

    private String versionStage;

    private Integer versionNumberInterior;

    private String upgradePackageName;

    private String ftpAddress;

    private String ftpUser;

    private String ftpPwd;

    private String ftpPath;

    private String httpAddress;

    private String upgradeAfter;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    public UpgradeVersion(Integer id, String serviceName, Integer versionNumber, String versionName, String versionStage, Integer versionNumberInterior, String upgradePackageName, String ftpAddress, String ftpUser, String ftpPwd, String ftpPath, String httpAddress, String upgradeAfter, String remark, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.serviceName = serviceName;
        this.versionNumber = versionNumber;
        this.versionName = versionName;
        this.versionStage = versionStage;
        this.versionNumberInterior = versionNumberInterior;
        this.upgradePackageName = upgradePackageName;
        this.ftpAddress = ftpAddress;
        this.ftpUser = ftpUser;
        this.ftpPwd = ftpPwd;
        this.ftpPath = ftpPath;
        this.httpAddress = httpAddress;
        this.upgradeAfter = upgradeAfter;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UpgradeVersion() {
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

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    public String getVersionStage() {
        return versionStage;
    }

    public void setVersionStage(String versionStage) {
        this.versionStage = versionStage == null ? null : versionStage.trim();
    }

    public Integer getVersionNumberInterior() {
        return versionNumberInterior;
    }

    public void setVersionNumberInterior(Integer versionNumberInterior) {
        this.versionNumberInterior = versionNumberInterior;
    }

    public String getUpgradePackageName() {
        return upgradePackageName;
    }

    public void setUpgradePackageName(String upgradePackageName) {
        this.upgradePackageName = upgradePackageName == null ? null : upgradePackageName.trim();
    }

    public String getFtpAddress() {
        return ftpAddress;
    }

    public void setFtpAddress(String ftpAddress) {
        this.ftpAddress = ftpAddress == null ? null : ftpAddress.trim();
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser == null ? null : ftpUser.trim();
    }

    public String getFtpPwd() {
        return ftpPwd;
    }

    public void setFtpPwd(String ftpPwd) {
        this.ftpPwd = ftpPwd == null ? null : ftpPwd.trim();
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath == null ? null : ftpPath.trim();
    }

    public String getHttpAddress() {
        return httpAddress;
    }

    public void setHttpAddress(String httpAddress) {
        this.httpAddress = httpAddress == null ? null : httpAddress.trim();
    }

    public String getUpgradeAfter() {
        return upgradeAfter;
    }

    public void setUpgradeAfter(String upgradeAfter) {
        this.upgradeAfter = upgradeAfter == null ? null : upgradeAfter.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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