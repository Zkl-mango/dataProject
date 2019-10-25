package com.digitalgd.data.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.digitalgd.data.dto.AreaDto;
import com.digitalgd.data.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.awt.geom.Area;
import java.util.List;

@Mapper
public interface AreaDao extends BaseMapper<AreaEntity> {

    public void insertArea(AreaEntity areaEntity);

    public void updateArea(AreaEntity areaEntity);

    public AreaEntity selectAreaById(String id);

    /**
     * 通过名称查找
     * @param name
     * @return
     */
    public AreaEntity selectAreaByName(String name);
    /**
     * 通过全名查找
     * @param fullname
     * @return
     */
    public AreaEntity selectAreaByFullName(String fullname);
    /**
     *通过快速查询查找到对应区域
     * @param lookup
     * @return
     */
    public AreaEntity selectAreaByLookup(String lookup);

    /**
     * code查找对应区域
     * @param code
     * @return
     */
    public AreaEntity selectAreaByCode(String code);
    /**
     * 父节点的code查找祖先
     * @param code
     * @return
     */
    public String selectAncestorsAreaByCode(String code);
    /**
     * 节点的code查找父亲
     * @param code
     * @return
     */
    public String selectParentAreaByCode(String code);
    /**
     * 查询某一节点下的所有子节点信息
     * @param parent
     * @return
     */
    public List<AreaEntity> selectAreaByParents(String parent);

    public List<AreaEntity> selectAll();

    public List<AreaEntity> selectArea(AreaDto areaDto);
}
