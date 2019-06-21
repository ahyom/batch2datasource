package br.com.soave.batch.batch;

import br.com.soave.batch.domain.mapper.ProductRowMapper;
import br.com.soave.batch.domain.model.Products;
import br.com.soave.batch.domain.query.MySQLQuery;
import br.com.soave.batch.domain.query.PostgreSQLQuery;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * This class configure all batch process, the jobRepository and read/process/write steps
 *
 * @author Arthur Soave
 * @since 06/2019
 *
 */

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    @Qualifier("mysqldatasource")
    private DataSource mySqlDataSource;

    @Autowired
    @Qualifier("postgreDataSource")
    private DataSource postgreDataSource;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Products> itemReader,
                   ItemProcessor<Products, Products> itemProcessor,
                   ItemWriter<Products> itemWriter){
        Step step = stepBuilderFactory.get("Load Products from MySQL Database")
                .<Products, Products> chunk(500)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        return jobBuilderFactory.get("Products loaded")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    ItemReader<Products> itemReader(){
        JdbcCursorItemReader<Products> dataBaseReader = new JdbcCursorItemReader<>();
        dataBaseReader.setDataSource(this.mySqlDataSource);
        dataBaseReader.setSql(MySQLQuery.readProductsFromMySQL());
        dataBaseReader.setRowMapper(new ProductRowMapper());
        return dataBaseReader;
    }

    @Bean
    ProductProcessor itemProcessor(){
        return new ProductProcessor();
    }

    @Bean
    ItemWriter<Products> writer(){
        JdbcBatchItemWriter<Products> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Products>());
        writer.setSql(PostgreSQLQuery.writeProductsPostgreSQL());
        writer.setDataSource(postgreDataSource);
        return writer;
    }
}