package br.com.matheussvb.adapter;

import br.com.matheussvb.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.matheussvb.port.driven.ClienteJpaPort;
import br.com.matheussvb.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service("ClienteJpaAdapter")
public class ClienteJpaAdapter implements ClienteJpaPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteById(Integer id) {
        clienteRepository.findById(id);
        return null;
    }
}
