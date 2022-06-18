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
public class ProcessadorValidacaoJobConfig {

    private JobBuilderFactory jobBuilderFactory;

    public ProcessadorValidacaoJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job processadorValidacaoJob(Step processadorValidacaoStep) {
        return jobBuilderFactory
                .get("processadorValidacaoJob")
                .start(processadorValidacaoStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}