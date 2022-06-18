package com.springbatch.processadorvalidacao.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoWriterConfig {

    @Bean
    public ItemWriter leituraArquivoMultiplosFormatosWriter() {
        return items -> items.forEach(System.out::println);
    }
}
