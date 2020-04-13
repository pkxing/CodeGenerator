package com.pkx.code.build;

import java.util.Map;

/****
 * @Author: PKXING
 * @Description:Dao构建
 * @Date  PKXING 19:13
 *****/
public class DaoBuilder {


    /***
     * 构建Dao
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        // 生成Dao层文件
        BuilderFactory.builder(modelMap,
                "/template/dao",
                "Mapper.java",
                TemplateBuilder.PACKAGE_MAPPER,
                "Mapper.java");
    }

}
