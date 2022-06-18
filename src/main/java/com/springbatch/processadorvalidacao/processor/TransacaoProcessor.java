package com.springbatch.processadorvalidacao.processor;

import com.springbatch.processadorvalidacao.dominio.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

    @Override
    public Transacao process(Transacao transacao) throws Exception {
        System.out.println(String.format("\nAplicando regras de negócio na transação %s", transacao.getDescricao()));
        return transacao;
    }
}
