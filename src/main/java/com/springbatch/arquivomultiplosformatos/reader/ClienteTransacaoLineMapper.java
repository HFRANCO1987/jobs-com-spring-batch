package com.springbatch.arquivomultiplosformatos.reader;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;
import com.springbatch.arquivomultiplosformatos.dominio.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapper {

    @Bean
    public PatternMatchingCompositeLineMapper lineMapper(){
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fieldSetMappers());
        return lineMapper;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMapperMap = new HashMap<>();
        fieldSetMapperMap.put("0*", fieldSetMapperMap(Cliente.class));
        fieldSetMapperMap.put("1*", fieldSetMapperMap(Transacao.class));
        return fieldSetMapperMap;
    }

    private FieldSetMapper fieldSetMapperMap(Class classe) {
        BeanWrapperFieldSetMapper beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(classe);
        return beanWrapperFieldSetMapper;
    }

    private Map<String, LineTokenizer> tokenizers() {
        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put("0*", clienteLineTokenizer());
        tokenizers.put("1*", transacaoLineTokenizer());
        return tokenizers;
    }

    private LineTokenizer transacaoLineTokenizer() {
        DelimitedLineTokenizer transacaoLineTokenizer = new DelimitedLineTokenizer();
        transacaoLineTokenizer.setNames("id", "descricao", "valor");
        transacaoLineTokenizer.setIncludedFields(1,2,3);
        return transacaoLineTokenizer;
    }

    private LineTokenizer clienteLineTokenizer() {
        DelimitedLineTokenizer clientLineTokenizer = new DelimitedLineTokenizer();
        clientLineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        clientLineTokenizer.setIncludedFields(1,2,3,4);
        return clientLineTokenizer;
    }
}
