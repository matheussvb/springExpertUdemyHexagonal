package br.com.matheussvb.service;

import br.com.matheussvb.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.matheussvb.port.driven.ClienteJpaPort;
import br.com.matheussvb.port.driver.ClientePort;

import java.util.List;

@Service("ClienteAdapter")
public class ClienteAdapter implements ClientePort {

    @Autowired
    private ClienteJpaPort serviceClienteRepository;

    @Override
    public Cliente findClienteById(final Integer id) {
        return serviceClienteRepository.getClienteById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {

        return serviceClienteRepository.save(cliente);
    }

    @Override
    public void deletar(Integer id) {
        serviceClienteRepository.deletar(id);
    }

    @Override
    public void update(Integer id, Cliente cliente) {
        Cliente clienteExists = serviceClienteRepository.getClienteById(id);
        cliente.setId(clienteExists.getId());
        serviceClienteRepository.update(cliente);
    }

    @Override
    public List<Cliente> findAll(Cliente cliente) {
        return serviceClienteRepository.findAll(cliente);
    }
}
