package com.springbatch.arquivolargurafixa.writer;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
//        return items -> {
//            for (Cliente cliente : items) {
//                if (cliente.getNome().equals("Maria")){
//                    throw new Exception();
//                }else{
//                    System.out.println(cliente);
//                }
//            }
//        };
        return items -> items.forEach(System.out::println);
    }
}
