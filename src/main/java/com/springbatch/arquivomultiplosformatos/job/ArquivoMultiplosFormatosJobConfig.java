package com.springbatch.arquivomultiplosformatos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoMultiplosFormatosJobConfig {

    private JobBuilderFactory jobBuilderFactory;

    public ArquivoMultiplosFormatosJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job arquivoMultiplosFormatosJob(Step leituraArquivoMultiplosFormatosStep){
        return this.jobBuilderFactory
                .get("arquivoMultiplosFormatosJob")
                .start(leituraArquivoMultiplosFormatosStep)
                //.incrementer(new RunIdIncrementer())
                .build();
    }
}
