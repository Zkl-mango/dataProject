package com.digitalgd.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class OrgansParamDto implements Serializable {

    private String name;
    private String fullname;
    private String code;
    private String parent;
    private String areasName;
    private String areaCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getAreasName() {
        return areasName;
    }

    public void setAreasName(String areasName) {
        this.areasName = areasName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "OrgansParamDto{" +
                "name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                ", areasName='" + areasName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
