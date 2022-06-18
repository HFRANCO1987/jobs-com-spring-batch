package com.springbatch.arquivomultiplosformatos.reader;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoMultiplosFormatosReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> leituraArquivoMultiplosFormatosReader(
            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes,
            LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("leituraArquivoMultiplosFormatosReader")
                .resource(arquivoClientes)
                .lineMapper(lineMapper)
                .build();
    }


}
