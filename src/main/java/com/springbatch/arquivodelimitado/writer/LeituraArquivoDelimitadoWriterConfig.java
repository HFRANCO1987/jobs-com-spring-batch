package com.springbatch.arquivodelimitado.writer;

import com.springbatch.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoDelimitadoWriterConfig {

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
