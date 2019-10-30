package com.digitalgd.data.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dao.AreaDao;
import com.digitalgd.data.dao.OrganDao;
import com.digitalgd.data.dto.OrgansParamDto;
import com.digitalgd.data.entity.AreaEntity;
import com.digitalgd.data.entity.OrganEntity;
import com.digitalgd.data.exceptions.EntityNotFoundException;
import com.digitalgd.data.service.OrganService;
import com.digitalgd.data.util.constantUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganServiceImpl implements OrganService {

    @Resource
    OrganDao organDao;
    @Resource
    AreaDao areaDao;

    @Override
    public void addOrgan(OrganEntity organEntity) {
        //查找父节点的祖先节点
        String ancestor = areaDao.selectAncestorsAreaByCode(organEntity.getParent());
        String res;
        if( StringUtils.isBlank(ancestor) ) {
            res = organEntity.getParent();
        }
        else {
            res = ancestor+","+organEntity.getParent();
        }
        String[] s = res.split(",");
        organEntity.setAncestors(res);
        organEntity.setDepth(s.length);
        organEntity.setVersion(1);
        organEntity.setDeleted(0);
        organEntity.setStatus(1);
        organEntity.setCreatedAt(new Date());
        organEntity.setCreatedBy(null);
        organDao.insertOrgan(organEntity);
    }

    @Override
    public void updateOrgan(OrganEntity organEntity, String user) {
        OrganEntity organ = organDao.selectOrganById(organEntity.getId());
        if (organ == null) {
            throw new EntityNotFoundException(String.format("Organ(id={0}) not found", organEntity.getId()));
        }
        organEntity.setLastModifiedAt(new Date());
        organEntity.setLastModifiedBy(user);
        organEntity.setVersion(organEntity.getVersion()+1);
        organDao.updateOrgan(organEntity);
    }

    @Override
    public void deletedOrganById(String id, String user) {
        OrganEntity organEntity = organDao.selectOrganById(id);

        if (organEntity == null) {
            throw new EntityNotFoundException(String.format("Organ(id={0}) not found", id));
        }
        organEntity.setDeleted(1);
        organEntity.setLastModifiedAt(new Date());
        organEntity.setLastModifiedBy(user);
        organEntity.setVersion(organEntity.getVersion()+1);
        organDao.updateOrgan(organEntity);
    }

    @Override
    public OrganEntity getOrganById(String id) {
        OrganEntity organEntity = organDao.selectOrganById(id);
        return organEntity;
    }

    @Override
    public OrganEntity getOrganByName(String name) {

        OrganEntity organEntity = organDao.selectOrganByName(name);
        return organEntity;
    }

    @Override
    public OrganEntity getOrganByFullName(String fullname) {
        OrganEntity organEntity = organDao.selectOrganByFullName(fullname);
        return organEntity;
    }

    @Override
    public OrganEntity getOrganByCode(String code) {

        OrganEntity organEntity = organDao.selectOrganByCode(code);
        return organEntity;
    }

    @Override
    public List<OrganEntity> getOrganListByParents(String parentName) {
        OrganEntity organEntity = organDao.selectOrganByName(parentName);
        if(organEntity==null) {
            return null;
        }
        List<OrganEntity> list = organDao.selectOrganListByParent(organEntity.getCode());
        return list;
    }

    @Override
    public List<OrganEntity> getOrganListByArea(String areaName) {

        AreaEntity area = areaDao.selectAreaByName(areaName);
        if(area==null) {
            return null;
        }
        List<OrganEntity> list = organDao.selectOrganListByArea(area.getCode());
        return list;
    }

    @Override
    public IPage<OrganEntity> getOrgan(Page<OrganEntity> page, OrgansParamDto organsParamDto) {
        if( !StringUtils.isBlank(organsParamDto.getAreasName()) ) {
            AreaEntity area = areaDao.selectAreaByName(organsParamDto.getAreasName());
            if(area==null) {
                return null;
            }
            organsParamDto.setAreaCode(area.getCode());
        }
        if( !StringUtils.isBlank(organsParamDto.getParent()) ) {
            String parentName = organsParamDto.getParent();
            OrganEntity organEntity = organDao.selectOrganByName(parentName);
            if(organEntity==null) {
                return null;
            }
            organsParamDto.setParent(organEntity.getCode());
        }
        return organDao.selectOrgan(page,organsParamDto);
    }
}
