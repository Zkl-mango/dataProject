package com.digitalgd.data.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dto.OrgansParamDto;
import com.digitalgd.data.entity.OrganEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrganDao {

    public void insertOrgan(OrganEntity organEntity);

    public void updateOrgan(OrganEntity organEntity);

    public OrganEntity selectOrganById(String id);

    public OrganEntity selectOrganByName(String name);

    public OrganEntity selectOrganByFullName(String fullname);

    public OrganEntity selectOrganByCode(String code);

    public List<OrganEntity> selectOrganListByParent(String parent);

    public List<OrganEntity> selectOrganListByArea(String areaCode);

    public IPage<OrganEntity> selectOrgan(Page<OrganEntity> page, OrgansParamDto organsParamDto);

}
