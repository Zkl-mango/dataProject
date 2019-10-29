package com.digitalgd.data.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Alias(value = "AreaEntity")
@TableName("area")
public class AreaEntity {

    @TableId
    private String id;
    private String name;
    private String fullname;
    private String shortname;
    private String code;
    private String lookup;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
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

    public Date getCreatedAt() {
        return createdAt;
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

    public Date getLastModifiedAt() {
        return lastModifiedAt;
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
        return "AreaEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", shortname='" + shortname + '\'' +
                ", code='" + code + '\'' +
                ", lookup='" + lookup + '\'' +
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

    public boolean isEmpty(AreaEntity areaEntity) {
        if( StringUtils.isBlank(areaEntity.getId()) && StringUtils.isBlank(areaEntity.getName()) &&
                StringUtils.isBlank(areaEntity.getFullname()) && StringUtils.isBlank(areaEntity.getShortname()) &&
                StringUtils.isBlank(areaEntity.getCode()) && StringUtils.isBlank(areaEntity.getLookup()) &&
                StringUtils.isBlank(areaEntity.getParent()) && areaEntity.getCategory() == 0 )
            return true;
        return false;
    }
}
