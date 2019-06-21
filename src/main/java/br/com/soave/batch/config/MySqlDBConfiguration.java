package br.com.soave.batch.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.logging.Logger;


@Configuration
@EnableTransactionManagement
public class MySqlDBConfiguration {

    @Value("${spring.datasource.mysql.username}")
    private String userName;

    @Value("${spring.datasource.mysql.password}")
    private String password;

    @Value("${spring.datasource.mysql.url}")
    private String dbUrl;

    @Value("${spring.datasource.mysql.driver.className}")
    private String className;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean
    @Primary
    public HikariConfig hikariConfig(){
        logger.info("loading MySQL Configurations");
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setDriverClassName(className);
        return hikariConfig;
    }

    @Bean(name = "mysqldatasource")
    @Primary
    public DataSource dataSource(HikariConfig hikariConfig){
        return new HikariDataSource(hikariConfig);
    }

    @Primary
    @Bean(name = "mysqlTransactional")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}