package cn.edu.imut.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by di_dong on 2017/5/27.
 */
@Configuration
public class DataSoruceConfiguration {
    @Primary
    @Qualifier("primaryDataSource")
    @Bean("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary" )
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
}
