package com.springbatch.processadorvalidacao.processor;

import com.springbatch.processadorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessadorValidacaoProcessorConfig {

    private Set<String> emais = new HashSet<>();

    @Bean
    public ItemProcessor<Cliente, Cliente> processadorValidacaoProcessor(){
        /***
         * Validação de propriedades obrigatorias
         */
//        BeanValidatingItemProcessor<Cliente> processor = new BeanValidatingItemProcessor<>();
//        processor.setFilter(true);

        ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
        processor.setValidator(validator());

        return processor;
    }

    /**
     * Customizando validação
     * @return
     */
    private Validator<Cliente> validator() {
        return new Validator<Cliente>() {
            @Override
            public void validate(Cliente cliente) throws ValidationException {
                if (emais.contains(cliente.getEmail()))
                    throw new ValidationException(String.format("O cliente %s já foi processado!", cliente.getEmail()));

                emais.add(cliente.getEmail());
            }
        };
    }
}
