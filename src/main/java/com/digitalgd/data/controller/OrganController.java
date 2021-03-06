package com.digitalgd.data.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.digitalgd.data.dto.OrgansParamDto;
import com.digitalgd.data.dto.PageInfo;
import com.digitalgd.data.entity.AreaEntity;
import com.digitalgd.data.entity.OrganEntity;
import com.digitalgd.data.exceptions.EntityNotFoundException;
import com.digitalgd.data.exceptions.ListNotFoundException;
import com.digitalgd.data.service.OrganService;
import com.digitalgd.data.util.constantUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Log4j
public class OrganController {

    @Resource
    OrganService organService;

    @PostMapping("organs")
    public ResponseEntity<Void> addOrgan(@RequestBody OrganEntity organEntity) {
        if( organEntity.isEmpty(organEntity) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        organService.addOrgan(organEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("organs")
    public ResponseEntity<Void> updateOrgan(@RequestBody OrganEntity organEntity) {
        if( organEntity.isEmpty(organEntity) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        organService.updateOrgan(organEntity,null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("organs/{id}")
    public ResponseEntity<Void> deletedOrgan(@PathVariable String id) {
        if(StringUtils.isBlank(id))  {
            throw new IllegalArgumentException("id is null, empty, or blank");
        }
        organService.deletedOrganById(id,null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("organs/{id}")
    public ResponseEntity<OrganEntity> getAreasById(@PathVariable String id) {
        if ( StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("id is null, empty, or blank");
        }
        OrganEntity organEntity = organService.getOrganById(id);
        if(organEntity == null) {
            throw new EntityNotFoundException(String.format("organ not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(organEntity);
    }

//    @GetMapping ("organs")
//    public ResponseEntity<IPage<OrganEntity>> getOrgansByIPage(OrgansParamDto organsParamDto, PageInfo pageInfo) {
//        Page<OrganEntity> page = new Page<>();
//        page.setSize(pageInfo.getPageSize());
//        page.setCurrent(pageInfo.getCurrent());
//        IPage<OrganEntity> organs = organService.getOrgan(page,organsParamDto);
//        return ResponseEntity.status(HttpStatus.OK).body(organs);
//    }

    @GetMapping ("organs")
    public ResponseEntity<List<OrganEntity>> getOrgansByIPage(OrgansParamDto organsParamDto) {
        List<OrganEntity> list = new ArrayList<>();
        list = organService.getOrgans(organsParamDto,list);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
