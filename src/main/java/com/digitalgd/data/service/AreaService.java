package com.digitalgd.data.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dto.AreaDto;
import com.digitalgd.data.entity.AreaEntity;

import java.util.List;

public interface AreaService {

    public void addArea(AreaEntity areaEntity);

    public void updateArea(AreaEntity areaEntity,String user);

    public void deletedAreaById(String id,String user);

    public AreaEntity getAreaById(String id);

    public AreaEntity getAreaByName(String name);

    public AreaEntity getAreaByFullName(String fullname);

    public AreaEntity getAreaByLookup(String lookup);

    public AreaEntity getAreaByCode(String code);
    /**
     * 父节点的code查找祖先
     * @param code
     * @return
     */
    public String getAncestorsAreaByCode(String code);
    /**
     * 节点的code查找父亲
     * @param code
     * @return
     */
    public String getParentAreaByCode(String code);
    /**
     * 查询某一节点下的所有子节点信息
     * @param parentName
     * @return
     */
    public List<AreaEntity> getAreaByParents(String parentName);

    public List<AreaEntity> getAll();

    public List<AreaEntity> getAreas(AreaDto areaDto,List<AreaEntity> list);

}
