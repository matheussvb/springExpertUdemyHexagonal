package br.com.matheussvb.service;

import br.com.matheussvb.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.matheussvb.port.driven.ClienteJpaPort;
import br.com.matheussvb.port.driver.ClientePort;

@Service("ClienteAdapter")
public class ClienteAdapter implements ClientePort {

    @Autowired
    private ClienteJpaPort serviceClienteRepository;

    @Override
    public Cliente findClienteById(final Integer id) {
        serviceClienteRepository.getClienteById(id);


        return null;
    }
}
