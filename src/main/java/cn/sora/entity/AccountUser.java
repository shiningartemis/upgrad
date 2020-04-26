package cn.sora.entity;

import java.util.Date;

public class AccountUser {
    private Integer id;

    private String accountName;

    private String userName;

    private String userPwd;

    private Integer roleId;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    public AccountUser(Integer id, String accountName, String userName, String userPwd, Integer roleId, String remark, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.accountName = accountName;
        this.userName = userName;
        this.userPwd = userPwd;
        this.roleId = roleId;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public AccountUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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