package com.springbatch.arquivolargurafixa.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoLarguraFixaJobConfig {

    private JobBuilderFactory jobBuilderFactory;

    public ArquivoLarguraFixaJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job arquivoLarguraFixJob(Step leituraArquivoLarguraFixaStep){
        return this.jobBuilderFactory
                .get("arquivoLarguraFixaJob")
                .start(leituraArquivoLarguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
