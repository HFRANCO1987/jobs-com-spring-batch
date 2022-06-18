package com.springbatch.jdbccursorreaderjob.step;

import com.springbatch.jdbccursorreaderjob.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcCursorStepConfig {

    private StepBuilderFactory stepBuilderFactory;

    public JdbcCursorStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Bean
    public Step jdbcCursorReaderStep(ItemReader<Cliente> jdbcCursorReader, ItemWriter<Cliente> jdbcCursorWriter) {
        return stepBuilderFactory
                .get("jdbcCursorReaderStep")
                .<Cliente, Cliente>chunk(1)
                .reader(jdbcCursorReader)
                .writer(jdbcCursorWriter)
                .build();
    }
}
