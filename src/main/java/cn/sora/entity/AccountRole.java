package cn.sora.entity;

import java.util.Date;

public class AccountRole {
    private Integer roleId;

    private String roleName;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    public AccountRole(Integer roleId, String roleName, String remark, Date gmtCreate, Date gmtModified) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public AccountRole() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
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