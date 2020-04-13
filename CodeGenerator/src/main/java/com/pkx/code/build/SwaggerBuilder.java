package com.pkx.code.build;

import java.util.Map;

/*****
 * @Author:  PKXING
 * @Date:  PKXING 11:34
 * @Description: com.itheima.code.build
 *  生成Swagger
 ****/
public class SwaggerBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        // swagger的文件名字
        modelMap.put("Table","swagger");

        // 生成ServiceImpl层文件
        BuilderFactory.builder(modelMap,
                "/template/swagger",
                "swagger.json",
                TemplateBuilder.SWAGGER_UI_PATH,
                ".json");
    }
}
