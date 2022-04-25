package com.hz.smartorchard;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.hz.smartorchard.utlis.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class SmartOrchardApplicationTests {

    @Test
    void test1(){

        String encrypt = MD5.encrypt("000000");
        System.out.println(encrypt);
    }

    @Test
    void contextLoads() {

        List<String> list = new ArrayList<>();
        list.add("soms_delivery_record");
        list.add("soms_device");
        list.add("soms_device_image");
        list.add("soms_device_interface");
        list.add("soms_device_operation");
        list.add("soms_device_orchard_msg");
        list.add("soms_device_plan_corn");
        list.add("soms_device_type");
        list.add("soms_device_type_description");
        list.add("soms_device_video");
        list.add("soms_device_warn_record");
        list.add("soms_device_warn_threshold");
        list.add("soms_passage_based_reading");
        list.add("soms_permission");
        list.add("soms_role");
        list.add("soms_role_permission_relation");
        list.add("soms_text_type");
        list.add("soms_user");
        list.add("soms_user_role_relation");
        list.add("soms_warehouse_item_type");
        list.add("soms_warehouse_items");

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/guoyuan?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8","root", "123456")
                .globalConfig(builder -> {
                    builder.author("第五组") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java") // 指定输出目录
                            .commentDate("yyyy-MM-dd");

                })
                .packageConfig(builder -> {
                    builder.parent("com.hz") // 设置父包名
                            .moduleName("smartorchard") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("serviceImpl")
                            .controller("controller")
                            .mapper("dao")
                            .xml("dao")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(list) // 设置需要生成的表名
                            // 设置过滤表前缀
                            .addTablePrefix("soms_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("isDelete")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sDao")
                            .formatXmlFileName("%sDao");

                })
                .execute();
    }

}
