package com.springbatch.arquivolargurafixa.writer;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoLarguraFixaWriterConfig {

    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> escritaArquivoLarguraFixaWriter(
            @Value("#{jobParameters['arquivoClienteSaida']}") Resource resourceArquivoSaida) {
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("escritaArquivoLarguraFixaWriter")
                .resource(resourceArquivoSaida)
                .delimited()
                .delimiter(";")
                .names("nome", "sobrenome", "idade", "email")
                .build();
    }
}