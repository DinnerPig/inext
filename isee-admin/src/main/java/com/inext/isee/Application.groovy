package com.inext.isee

import org.apache.ibatis.session.SqlSessionFactory
import org.apache.tomcat.jdbc.pool.DataSource
import org.mybatis.spring.SqlSessionFactoryBean

/**
 * Application
 *
 * @author zhiliao
 * @since 2017-03-30
 */
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.MybatisProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager

import javax.servlet.MultipartConfigElement

@SpringBootApplication
@MapperScan('com.inext.isee.dao')
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
        //System.out.println(UUID.randomUUID().toString().replace("-", ""))
        //BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        //System.out.println(encoder.encode("admin".trim()))
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("1MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("256KB");
        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = 'spring.datasource')
    DataSource dataSource() {
        new DataSource()
    }

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        def sqlSessionFactoryBean = new SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource())
        def resolve = resolver()
        def mybatisProperties = this.mybatisProperties()
        sqlSessionFactoryBean.setConfigLocation(resolve.getResource(mybatisProperties.getConfigLocation()))
        sqlSessionFactoryBean.setMapperLocations(resolve.getResources(mybatisProperties.mapperLocations[0]))
        sqlSessionFactoryBean.getObject()
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = 'mybatis')
    MybatisProperties mybatisProperties() {
        new MybatisProperties()
    }

    @Bean
    PathMatchingResourcePatternResolver resolver(){
        new PathMatchingResourcePatternResolver()
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        new DataSourceTransactionManager(dataSource())
    }
}
