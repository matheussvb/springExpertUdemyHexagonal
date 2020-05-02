package br.com.matheussvb;

import br.com.matheussvb.entity.ClienteEntity;
import br.com.matheussvb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InsertTeste {

    @Bean
    public CommandLineRunner executar(@Autowired ClienteRepository repositoryClientes){
        return args -> {
            ClienteEntity cliente = new ClienteEntity();
            cliente.setCpf("12312312");
            cliente.setNome("Teste");
            repositoryClientes.save(cliente);

        };
    }

}
