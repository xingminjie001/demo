package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 16:10
 */
public class MyBatisPlusGenerator {

    @Test
    public void generateCode() {
        List<String> tableNames = Lists.newArrayList();
        // TODO 这里添加自己需要创建的数据库表名
        tableNames.add("user1");
        generate(tableNames);
    }

    // TODO 修改为自己
    private static final String AUTHOR = "lyz4455";
    // 工作区
    private static final String WORK_DIR = "/src/main/java/";
    // 当前项目路径
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    // 基类位置
    private static final String BASE_ENTITY = "com.example.demo.config.BaseEntity";
    // Mapper 基类位置
    private static final String BASE_MAPPER = "com.example.demo.config.CustomBaseMapper";

    private void generate(List<String> tableNamesInclude){
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig()
                // 设置输出路径
                .setOutputDir(PROJECT_PATH.concat(WORK_DIR))
                .setAuthor(AUTHOR)
                .setOpen(false)
                .setIdType(IdType.AUTO)
                // 默认不覆盖，如果文件存在，将不会再生成，配置true就是覆盖
                .setFileOverride(true)
                // 生成Mapper.xml的时候生成resultMap
                .setBaseResultMap(true)
                // 在xml中生成基础列
                .setBaseColumnList(true)
                // 实体属性 Swagger2 注解
                .setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=GMT%2B8&connectTimeout=10000&socketTimeout=30000&useSSL=false");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig()
                .setParent("com.example.demo")
                .setEntity("domain")
                .setMapper("mapper");

        autoGenerator.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
                .setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass(BASE_ENTITY)
                .setSuperMapperClass(BASE_MAPPER)
                .setEntityLombokModel(true)
                .setInclude(tableNamesInclude.toArray(new String[0]))
                .setSuperEntityColumns("id", "update_time", "create_time")
                .setEntityTableFieldAnnotationEnable(true);
        autoGenerator.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        configCustomizedCodeTemplate(autoGenerator);
        configInjection(autoGenerator);
        autoGenerator.execute();
    }

    /**
     * 自定义模板
     * @param autoGenerator 自动生成类
     */
    private void configCustomizedCodeTemplate(AutoGenerator autoGenerator){
        //配置 自定义模板
        TemplateConfig templateConfig = new TemplateConfig()
                // 设置不生成controller
                .setController(null)
                .setService(null)
                .setServiceImpl(null)
                .setXml(null);
                //.setEntity("templates/MyEntityTemplate.java")//指定Entity生成使用自定义模板
                // .setXml(null);//不生成xml
        autoGenerator.setTemplate(templateConfig);
    }

    /**
     * 配置自定义参数/属性
     *
     * @param autoGenerator 自动生成类
     */
    private void configInjection(AutoGenerator autoGenerator){
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                /*Map<String, Object> map = new HashMap<>();
                map.put("baseEntity", BASE_ENTITY);
                map.put("baseMapper", BASE_MAPPER);
                this.setMap(map);

                自定义属性注入: 模板配置：abc=${cfg.abc}
                暂时不需要
                 */
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 指定模板对应生成文件到哪个地方
                return PROJECT_PATH + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);
    }
}
