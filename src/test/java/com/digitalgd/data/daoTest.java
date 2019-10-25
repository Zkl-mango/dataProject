package com.digitalgd.data;


import com.digitalgd.data.dao.AreaDao;
import com.digitalgd.data.dto.AreaDto;
import com.digitalgd.data.entity.AreaEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.awt.geom.Area;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class daoTest {

    @Resource
    private AreaDao areaDao;

    @Test
    public void insertTest() {
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setId("1");
        areaEntity.setName("22");
        areaEntity.setFullname("2222");
        areaEntity.setAncestors("1");
        areaEntity.setDepth(1);
        areaEntity.setShortname("33");
        areaEntity.setCode("000000");
        areaEntity.setStatus(0);
//        areaEntity.setDeleted(0);
        System.out.println(areaEntity);
//        areaDao.insertArea(areaEntity);
        areaDao.updateArea(areaEntity);
    }

    @Test
    public void testing() {
//        List<AreaEntity> list = areaDao.selectAll();
//        for(int i=0;i<list.size();i++) {
//            String code = list.get(i).getCode();
//            //查找当前节点的父节点
//            String parent = areaDao.selectParentAreaByCode(code);
//            if(parent==null||parent.equals(""))
//                continue;
//            //查找父节点的祖先节点
//            String ancestor = areaDao.selectAncestorsAreaByCode(parent);
//            String res;
//            if(ancestor==null||ancestor.equals(""))
//                res = parent;
//            else
//                res = ancestor+","+parent;
//            String[] s = res.split(",");
//            AreaEntity areaEntity = list.get(i);
//            areaEntity.setAncestors(res);
//            areaEntity.setDepth(s.length);
//            System.out.println(areaEntity);
//            areaDao.updateArea(areaEntity);
//        }
        AreaDto areaDto = new AreaDto();
        areaDto.setName("广东省");
        System.out.println(areaDao.selectArea(areaDto).toString());
    }
}
