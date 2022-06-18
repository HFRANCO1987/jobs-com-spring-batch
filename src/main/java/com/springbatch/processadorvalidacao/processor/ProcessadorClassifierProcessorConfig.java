package com.springbatch.processadorvalidacao.processor;

import com.springbatch.processadorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessadorClassifierProcessorConfig {

    @Bean
    public ItemProcessor processadorClassifierProcessor(){
        return new ClassifierCompositeItemProcessorBuilder<>()
                .classifier(classifier())
                .build();
    }

    private Classifier classifier() {
        return new Classifier<Object, ItemProcessor>() {
            @Override
            public ItemProcessor classify(Object objeto) {
                if (objeto instanceof Cliente)
                    return new ClienteProcessor();
                else
                    return new TransacaoProcessor();
            }
        };
    }


}
