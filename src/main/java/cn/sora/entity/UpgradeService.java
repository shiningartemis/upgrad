package cn.sora.entity;

import java.util.Date;

public class UpgradeService {
    private Integer id;

    private Integer serviceNumber;

    private String serviceName;

    private Date published;

    private String upgradeSign;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    public UpgradeService(Integer id, Integer serviceNumber, String serviceName, Date published, String upgradeSign, String remark, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.serviceNumber = serviceNumber;
        this.serviceName = serviceName;
        this.published = published;
        this.upgradeSign = upgradeSign;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UpgradeService() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Integer serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getUpgradeSign() {
        return upgradeSign;
    }

    public void setUpgradeSign(String upgradeSign) {
        this.upgradeSign = upgradeSign == null ? null : upgradeSign.trim();
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