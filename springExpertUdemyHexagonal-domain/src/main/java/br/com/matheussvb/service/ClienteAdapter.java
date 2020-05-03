package br.com.matheussvb.service;

import br.com.matheussvb.model.ClienteDTO;
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
    public ClienteDTO findClienteById(final Integer id) {
        return serviceClienteRepository.getClienteById(id);
    }

    @Override
    public ClienteDTO save(ClienteDTO cliente) {

        return serviceClienteRepository.save(cliente);
    }

    @Override
    public void deletar(Integer id) {
        serviceClienteRepository.deletar(id);
    }

    @Override
    public void update(Integer id, ClienteDTO cliente) {
        ClienteDTO clienteExists = serviceClienteRepository.getClienteById(id);
        cliente.setId(clienteExists.getId());
        serviceClienteRepository.update(cliente);
    }

    @Override
    public List<ClienteDTO> findAll(ClienteDTO cliente) {
        return serviceClienteRepository.findAll(cliente);
    }
}
