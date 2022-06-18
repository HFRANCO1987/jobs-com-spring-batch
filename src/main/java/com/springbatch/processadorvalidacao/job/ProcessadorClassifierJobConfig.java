package com.springbatch.processadorvalidacao.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ProcessadorClassifierJobConfig {

    private JobBuilderFactory jobBuilderFactory;

    public ProcessadorClassifierJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job processadorClassifierJob(Step processadorClassifierStep) {
        return jobBuilderFactory
                .get("processadorClassifierJob")
                .start(processadorClassifierStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
