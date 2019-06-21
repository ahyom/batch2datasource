package br.com.soave.batch.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EnableTransactionManagement
public class PostgreDBConfiguration {

    @Value("${spring.datasource.postgresql.username}")
    private String userName;

    @Value("${spring.datasource.postgresql.password}")
    private String password;

    @Value("${spring.datasource.postgresql.url}")
    private String dbUrl;

    @Value("${spring.datasource.postgresql.driver.className}")
    private String className;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean(name = "postgreProperties")
    public HikariConfig hikariConfig(){
        logger.info("loading Postgre Configurations");
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setDriverClassName(className);
        return hikariConfig;
    }

    @Bean(name = "postgreDataSource")
    public DataSource dataSource(@Qualifier("postgreProperties") HikariConfig hikariConfig){
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "postgreTransactional")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}