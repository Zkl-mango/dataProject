package com.digitalgd.data.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dao.AreaDao;
import com.digitalgd.data.dto.AreaDto;
import com.digitalgd.data.entity.AreaEntity;
import com.digitalgd.data.service.AreaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.digitalgd.data.exceptions.EntityNotFoundException;

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    AreaDao areaDao;

    @Override
    public void addArea(AreaEntity areaEntity) {
        //查找父节点的祖先节点
        String ancestor = areaDao.selectAncestorsAreaByCode(areaEntity.getParent());
        String res;
        if( StringUtils.isBlank(ancestor) ) {
            res = areaEntity.getParent();
        }
        else {
            res = ancestor+","+areaEntity.getParent();
        }
        String[] s = res.split(",");
        areaEntity.setId(UUID.randomUUID().toString());
        areaEntity.setAncestors(res);
        areaEntity.setDepth(s.length);
        areaEntity.setVersion(1);
        areaEntity.setDeleted(0);
        areaEntity.setStatus(1);
        areaEntity.setCreatedAt(new Date());
        areaEntity.setCreatedBy(null);
        areaDao.insertArea(areaEntity);
    }

    @Override
    public void updateArea(AreaEntity areaEntity,String user) {
        AreaEntity area = areaDao.selectAreaById(areaEntity.getId());
        if(area==null) {
            throw new EntityNotFoundException(String.format("Area not found"));
        }
        areaEntity.setLastModifiedAt(new Date());
        areaEntity.setLastModifiedBy(user);
        areaEntity.setVersion(area.getVersion() + 1);
        areaDao.updateArea(areaEntity);
    }

    @Override
    public void deletedAreaById(String id,String user){
        AreaEntity area = areaDao.selectAreaById(id);

        if (area == null) {
            throw new EntityNotFoundException(String.format("Area(id={0}) not found", id));
        }
        area.setDeleted(1);
        area.setLastModifiedAt(new Date());
        area.setLastModifiedBy(user);
        area.setVersion(area.getVersion()+1);
        areaDao.updateArea(area);
    }

    @Override
    public AreaEntity getAreaById(String id) {
        AreaEntity area = areaDao.selectAreaById(id);
        return area;
    }

    @Override
    public AreaEntity getAreaByName(String name) {
        AreaEntity area = areaDao.selectAreaByName(name);
        return area;
    }

    @Override
    public AreaEntity getAreaByFullName(String fullname) {
        AreaEntity area = areaDao.selectAreaByFullName(fullname);
        return area;
    }

    @Override
    public AreaEntity getAreaByLookup(String lookup) {
        AreaEntity area = areaDao.selectAreaByLookup(lookup);
        return area;
    }

    @Override
    public AreaEntity getAreaByCode(String code) {
        AreaEntity area = areaDao.selectAreaByCode(code);
        return area;
    }

    @Override
    public String getAncestorsAreaByCode(String code) {
        return areaDao.selectAncestorsAreaByCode(code);
    }

    @Override
    public String getParentAreaByCode(String code) {
        return areaDao.selectParentAreaByCode(code);
    }

    @Override
    public List<AreaEntity> getAreaByParents(String parentName) {
        AreaEntity areaEntity = areaDao.selectAreaByName(parentName);
        if(areaEntity==null) {
            throw new EntityNotFoundException(String.format("Area not found"));
        }
        List<AreaEntity> list = areaDao.selectAreaByParents(areaEntity.getCode());
        return list;
    }

    @Override
    public List<AreaEntity> getAll() {
        List<AreaEntity> list =  areaDao.selectAll();
        return list;
    }

    @Override
    public IPage<AreaEntity> getArea(Page<AreaEntity> page, AreaDto areaDto) {
        if(StringUtils.isBlank(areaDto.getName()))
            areaDto.setName(null);
        return areaDao.selectArea(page,areaDto);
    }


}
