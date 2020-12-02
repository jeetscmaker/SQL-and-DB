package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class Dbconfiguration {
    @Bean(name = "datasource1") // can be used by using @Qualifier("datasource1")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "datasource2") // @Qualifier("datasource2")
    @ConfigurationProperties(prefix="spring.secondDatasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="tm1")
    @Autowired
    @Primary
    DataSourceTransactionManager tm1(@Qualifier("datasource1") DataSource datasource) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
        return txm;
    }
    //@Transactional this will use the first datasource because it is @primary
    // to use a specific t.m. use @Transactional("tm2") or @Transactional("tm1")
    @Bean(name="tm2")
    @Autowired
    DataSourceTransactionManager tm2(@Qualifier ("datasource2") DataSource datasource) {
        DataSourceTransactionManager txm  = new DataSourceTransactionManager(datasource);
        return txm;
    }
}
