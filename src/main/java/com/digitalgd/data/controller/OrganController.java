package com.digitalgd.data.controller;

import com.digitalgd.data.dto.OrgansParamDto;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j
public class OrganController {

    @Resource
    OrganService organService;

    @PostMapping("organs")
    public ResponseEntity<Void> addOrgan(OrganEntity organEntity) {
        if( organEntity.isEmpty(organEntity) ) {
            throw new IllegalArgumentException("illegal parameter");
        }
        organService.addOrgan(organEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("organs")
    public ResponseEntity<Void> updateOrgan(OrganEntity organEntity) {
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

    @GetMapping ("organs")
    public ResponseEntity<List<OrganEntity>> getOrgans(OrgansParamDto organsParamDto) {
        if( StringUtils.isBlank(organsParamDto.getParent()) && StringUtils.isBlank(organsParamDto.getName())
            && StringUtils.isBlank(organsParamDto.getFullname()) && StringUtils.isBlank(organsParamDto.getCode())
            && StringUtils.isBlank(organsParamDto.getAreasName()) )  {
            throw new IllegalArgumentException("illegal parameter");
        }
        List<OrganEntity> organs = organService.getOrgan(organsParamDto);
        if(CollectionUtils.isEmpty(organs)) {
            throw new ListNotFoundException("list not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(organs);
    }
}