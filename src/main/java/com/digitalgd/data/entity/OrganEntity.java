package com.digitalgd.data.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Alias(value = "organEntity")
@TableName("organ")
public class OrganEntity implements Serializable {

    @TableId
    private String id;
    private String name;
    private String fullname;
    private String code;
    private AreaEntity areaCode;
    private String parent;
    private String ancestors;
    private int depth;
    private int category;
    private int status;
    private int ordered;
    private String remarks;
    private int deleted;
    private String createdBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdAt;
    private String lastModifiedBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date lastModifiedAt;
    private int version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public AreaEntity getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(AreaEntity areaCode) {
        this.areaCode = areaCode;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(createdAt);
        return str;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String  getLastModifiedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(lastModifiedAt);
        return str;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OrganEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", code='" + code + '\'' +
                ", areaCode=" + areaCode +
                ", parent='" + parent + '\'' +
                ", ancestors='" + ancestors + '\'' +
                ", depth=" + depth +
                ", category=" + category +
                ", status=" + status +
                ", ordered=" + ordered +
                ", remarks='" + remarks + '\'' +
                ", deleted=" + deleted +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedAt=" + lastModifiedAt +
                ", version=" + version +
                '}';
    }

    public boolean isEmpty(OrganEntity organEntity) {
        if( StringUtils.isBlank(organEntity.getId()) && StringUtils.isBlank(organEntity.getName()) &&
                StringUtils.isBlank(organEntity.getFullname()) && organEntity.getAreaCode() == null &&
                StringUtils.isBlank(organEntity.getCode()) && StringUtils.isBlank(organEntity.getParent()) &&
                organEntity.getCategory() == 0)
            return true;

        return false;
    }
}
