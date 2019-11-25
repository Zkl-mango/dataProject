package com.digitalgd.data.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dto.OrgansParamDto;
import com.digitalgd.data.entity.OrganEntity;

import java.util.List;
import java.util.Map;

public interface OrganService {


    public void addOrgan(OrganEntity organEntity);

    public void updateOrgan(OrganEntity organEntity, String user);

    public void deletedOrganById(String id,String user);

    public OrganEntity getOrganById(String id);

    public OrganEntity getOrganByName(String name);

    public OrganEntity getOrganByFullName(String fullname);

    public OrganEntity getOrganByCode(String code);

    public List<OrganEntity> getOrganListByParents(String parentName);

    public List<OrganEntity> getOrganListByArea(String areaName);

    public List<OrganEntity> getOrgans(OrgansParamDto organsParamDto,List<OrganEntity> list);
}
