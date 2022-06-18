package com.springbatch.jdbccursorreaderjob.step;

import com.springbatch.jdbccursorreaderjob.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
    public Step leituraArquivoMultiplosFormatosStep(
            MultiResourceItemReader<Cliente> leituraArquivoMultiplosFormatosReader, ItemWriter leituraArquivoMultiplosFormatosWriter){
        return this.stepBuilderFactory
                .get("leituraArquivoMultiplosFormatosStep")
                .chunk(1) //tamanho do chunck controle o número de transações
                //.reader(leituraArquivoMultiplosFormatosReader)
                //.reader(new ArquivoClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
                .reader(leituraArquivoMultiplosFormatosReader)
                .writer(leituraArquivoMultiplosFormatosWriter)
                .build();
    }
}
