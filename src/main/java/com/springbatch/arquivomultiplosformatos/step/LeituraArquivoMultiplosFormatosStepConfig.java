package com.springbatch.arquivomultiplosformatos.step;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {

    private StepBuilderFactory stepBuilderFactory;

    public LeituraArquivoMultiplosFormatosStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step leituraArquivoDelimitadoStep(ItemReader<Cliente> leituraArquivoMultiplosFormatosReader, ItemWriter leituraArquivoMultiplosFormatosWriter){
        return this.stepBuilderFactory
                .get("leituraArquivoDelimitadoStep")
                .<Cliente, Cliente>chunk(1) //tamanho do chunck controle o número de transações
                .reader(leituraArquivoMultiplosFormatosReader)
                .writer(leituraArquivoMultiplosFormatosWriter)
                .build();
    }
}
