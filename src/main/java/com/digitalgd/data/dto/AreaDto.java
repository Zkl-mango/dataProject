package com.digitalgd.data.dto;

import java.io.Serializable;

public class AreaDto implements Serializable {

    private String name;
    private String fullname;
    private String code;
    private String lookup;
    private String parent;

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

    public String getLookup() {
        return lookup;
    }

    public void setLookup(String lookup) {
        this.lookup = lookup;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }


    @Override
    public String toString() {
        return "AreaDto{" +
                "name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", code='" + code + '\'' +
                ", lookup='" + lookup + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }
}
