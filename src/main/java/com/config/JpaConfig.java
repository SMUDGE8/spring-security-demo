package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author lei
 * @since 2018/2/1
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.dao"})
@EnableTransactionManagement
public class JpaConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.model");

        Properties jpaProperties = new Properties();

        //配置所使用的数据库方言，这允许Hibernate创建针对所使用的数据库进行优化的SQL。
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        //指定在创建或关闭Hibernate会话工厂时调用到数据库的操作。
        jpaProperties.put("hibernate.hbm2ddl.auto","none");

        //配置Hibernate创建新的数据库对象和模式元素时使用的命名策略。
        jpaProperties.put("hibernate.ejb.naming_strategy","org.hibernate.cfg.ImprovedNamingStrategy" );

        //如果该属性的值为true, Hibernate将所有SQL语句写入控制台。
        jpaProperties.put("hibernate.show_sql",true);

        //如果该属性的值为true, Hibernate将格式化写入控制台的SQL。
        //jpaProperties.put("hibernate.format_sql", true);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
