package com.springbatch.processadorvalidacao.step;

import com.springbatch.processadorvalidacao.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoStepConfig {

    private StepBuilderFactory stepBuilderFactory;

    public ProcessadorValidacaoStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public Step processadorClassifierStep(
            FlatFileItemReader processadorClassifierReader,
            ItemProcessor processadorClassifierProcessor,
            ItemWriter processadorClassifierWriter) {
        return stepBuilderFactory
                .get("processadorClassifierStep")
                .chunk(1)
                .reader(processadorClassifierReader)
                .processor(processadorClassifierProcessor)
                .writer(processadorClassifierWriter)
                .build();
    }

}
