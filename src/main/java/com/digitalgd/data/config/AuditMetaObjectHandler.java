package com.digitalgd.data.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class AuditMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean createDate = metaObject.hasSetter("createdAt");
        boolean updateDate = metaObject.hasSetter("lastModifiedAt");
        if( createDate || updateDate) {
            Date date = new Date();
            if(createDate) {
                this.setFieldValByName("createdAt",date,metaObject);
            }
            if(updateDate) {
                this.setFieldValByName("lastModifiedAt",date,metaObject);
            }
        }
        String user = "";
        if(metaObject.hasSetter("createdBy")) {
            this.setFieldValByName("createdBy",user,metaObject);
        }
        if(metaObject.hasSetter("lastModifiedBy")) {
            this.setFieldValByName("lastModifiedBy",user,metaObject);
        }
        if(metaObject.hasSetter("deleted")) {
            this.setFieldValByName("deleted",0,metaObject);
        }
        if(metaObject.hasSetter("version")) {
            this.setFieldValByName("version",1,metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("lastModifiedAt")) {
            this.setFieldValByName("lastModifiedAt", new Date(), metaObject);
        }
        if (metaObject.hasSetter("lastModifiedBy")) {
            String username = "";//获取用户，如果使用SpringSecurity的话可以从SecurityContext中获取
            this.setFieldValByName("lastModifiedBy", username, metaObject);
        }
    }
}
