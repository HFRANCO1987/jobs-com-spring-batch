package com.springbatch.processadorvalidacao.processor;

import com.springbatch.processadorvalidacao.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    /**
     * Toda regra de negócio pode ser utilizada aqui
     * @param cliente
     * @return
     * @throws Exception
     */
    @Override
    public Cliente process(Cliente cliente) throws Exception {
        System.out.println(String.format("\nAplicando regras de negócio no cliente %s", cliente.getEmail()));
        return cliente;
    }
}
