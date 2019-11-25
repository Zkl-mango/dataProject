package com.digitalgd.data.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dto.AreaDto;
import com.digitalgd.data.dto.PageInfo;
import com.digitalgd.data.entity.AreaEntity;
import com.digitalgd.data.service.AreaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.digitalgd.data.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class AreaControlller {

    @Resource
    AreaService areaService;

    @PostMapping("areas")
    public ResponseEntity<Void> addArea(@RequestBody AreaEntity areaEntity) {
        if( areaEntity.isEmpty(areaEntity) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        areaService.addArea(areaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("areas")
    public ResponseEntity<Void> updateArea(@RequestBody AreaEntity areaEntity) {
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

//    @GetMapping("areas")
//    public ResponseEntity<IPage<AreaEntity>> getAreas(AreaDto areaDto, PageInfo pageInfo) {
//        Page<AreaEntity> page = new Page<>();
//        if( pageInfo.getCurrent()==0 ) {
//            pageInfo.setCurrent(1);
//            pageInfo.setPageSize(20);
//        }
//        page.setSize(pageInfo.getPageSize());
//        page.setCurrent(pageInfo.getCurrent());
//        IPage<AreaEntity> areas = areaService.getArea(page,areaDto);
//        return ResponseEntity.status(HttpStatus.OK).body(areas);
//    }

    @GetMapping("areas")
    public ResponseEntity<List<AreaEntity>> getAreas(AreaDto areaDto) {
        List<AreaEntity> list = new ArrayList<>();
        list = areaService.getAreas(areaDto,list);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
