package com.springbatch.jdbcpagingreaderjob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JdbcCursorReaderJobConfig {

    private JobBuilderFactory jobBuilderFactory;

    public JdbcCursorReaderJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job jdbcPagingJob(Step jdbcPagingReaderJob){
        return this.jobBuilderFactory
                .get("jdbcPagingJob")
                .start(jdbcPagingReaderJob)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
