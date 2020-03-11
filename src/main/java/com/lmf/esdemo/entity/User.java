package com.lmf.esdemo.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName="myes",type="myuser",refreshInterval="-1")
public class User implements Serializable {
    private Long usrId;
    private String usrName;
    private String usrPassword;
    private Long usrRoleId;
    private Long usrFlag;

    public User(Long usrId, String usrName, String usrPassword, Long usrRoleId, Long usrFlag) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }

    public Long getUsrId() {
        return usrId;
    }

    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Long getUsrRoleId() {
        return usrRoleId;
    }

    public void setUsrRoleId(Long usrRoleId) {
        this.usrRoleId = usrRoleId;
    }

    public Long getUsrFlag() {
        return usrFlag;
    }

    public void setUsrFlag(Long usrFlag) {
        this.usrFlag = usrFlag;
    }
}
