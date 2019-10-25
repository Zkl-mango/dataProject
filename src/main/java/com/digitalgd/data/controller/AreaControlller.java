package com.digitalgd.data.controller;

import com.digitalgd.data.dto.AreaDto;
import com.digitalgd.data.entity.AreaEntity;
import com.digitalgd.data.exceptions.ListNotFoundException;
import com.digitalgd.data.service.AreaService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.digitalgd.data.exceptions.EntityNotFoundException;

@RestController
public class AreaControlller {

    @Resource
    AreaService areaService;

    @PostMapping("areas")
    public ResponseEntity<Void> addArea(AreaEntity areaEntity) {
        if( areaEntity.isEmpty(areaEntity) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        areaService.addArea(areaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("areas")
    public ResponseEntity<Void> updateArea(AreaEntity areaEntity) {
        if( areaEntity.isEmpty(areaEntity) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        areaService.updateArea(areaEntity,null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // DELETE /areas/{id}
    @DeleteMapping("areas/{id}")
    public ResponseEntity<Void> deletedArea(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("id is null, empty, or blank");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        areaService.deletedAreaById(id, null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("areas/{id}")
    public ResponseEntity<AreaEntity> getAreasById(@PathVariable String id) {
        if ( StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("id is null, empty, or blank");
        }
        AreaEntity areaEntity = areaService.getAreaById(id);
        if(areaEntity == null) {
            throw new EntityNotFoundException(String.format("Area not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(areaEntity);
    }

    @GetMapping("areas")
    public ResponseEntity<List<AreaEntity>> getAreas(AreaDto areaDto) {
//        Map<String,Object> res = new HashMap<String, Object>();
//        if( areaDto.getCode() == null && areaDto.getFullname() ==null&&areaDto.getId()==null
//        &&areaDto.getLookup()==null&&areaDto.getName()==null) {
//            res.put(constantUtil.status,constantUtil.failStatus);
//            return ResponseEntity.status(HttpStatus.OK).body(res);
//        }
//        AreaEntity area = areaService.getArea(areaDto);
//        if(area==null) {
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }
//        res.put(constantUtil.status,constantUtil.succesStatus);
//        res.put("area",area);
//        return ResponseEntity.status(HttpStatus.OK).body(res);

        if( StringUtils.isBlank(areaDto.getCode()) && StringUtils.isBlank(areaDto.getFullname())
                && StringUtils.isBlank(areaDto.getName()) && StringUtils.isBlank(areaDto.getLookup())
                && StringUtils.isBlank(areaDto.getParent()) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        List<AreaEntity> areas = areaService.getArea(areaDto);
        if(CollectionUtils.isEmpty(areas)) {
            throw new ListNotFoundException(String.format("list not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(areas);
    }

}
