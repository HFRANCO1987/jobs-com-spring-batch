package com.springbatch.arquivodelimitado.step;

import com.springbatch.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoDelimitadoStepConfig {

    private StepBuilderFactory stepBuilderFactory;

    public LeituraArquivoDelimitadoStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step leituraArquivoDelimitadoStep(ItemReader<Cliente> leituraArquivoDelimitadoReader, ItemWriter<Cliente> leituraArquivoDelimitadoWriter){
        return this.stepBuilderFactory
                .get("leituraArquivoDelimitadoStep")
                .<Cliente, Cliente>chunk(1) //tamanho do chunck controle o número de transações
                .reader(leituraArquivoDelimitadoReader)
                .writer(leituraArquivoDelimitadoWriter)
                .build();
    }
}
