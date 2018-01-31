package com.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lei
 * @since 2018/1/31
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/security?serverTimezone=UTC&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setIdleConnectionTestPeriod(60);  //每60秒检查所有连接池中的空闲连接。Default: 0
        dataSource.setIdleMaxAge(240);
        dataSource.setMaxConnectionsPerPartition(30); //每个分区含有connection最大个数
        dataSource.setMinConnectionsPerPartition(10);
        dataSource.setPartitionCount(3); //设置分区个数
        dataSource.setAcquireIncrement(5); //设置分区中的connection增长数量
        dataSource.setStatementsCacheSize(50); //设置statement缓存个数。这个参数默认为0
        dataSource.setReleaseHelperThreads(3); //设置connection助手线程个数
        return dataSource;
    }

}
