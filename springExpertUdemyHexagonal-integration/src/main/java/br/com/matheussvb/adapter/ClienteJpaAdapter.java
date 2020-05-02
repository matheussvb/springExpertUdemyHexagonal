package br.com.matheussvb.adapter;

import br.com.matheussvb.entity.ClienteEntity;
import br.com.matheussvb.exception.ClienteNotFoundException;
import br.com.matheussvb.model.Cliente;
import br.com.matheussvb.port.driven.ClienteJpaPort;
import br.com.matheussvb.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("ClienteJpaAdapter")
public class ClienteJpaAdapter implements ClienteJpaPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Cliente getClienteById(final Integer id) {
        ClienteEntity c = clienteRepository.findById(id)
                .orElseThrow(
                        () -> new ClienteNotFoundException("Cliente não encontrado")
                );
        return Cliente.builder()
                .nome(c.getNome())
                .cpf(c.getCpf())
                .id(c.getId())
                .build();
    }

    @Override
    public Cliente save(final Cliente cliente) {
        final ClienteEntity c = clienteRepository.save(modelMapper.map(cliente, ClienteEntity.class));
        return Cliente.builder()
                .id(c.getId())
                .cpf(c.getCpf())
                .nome(c.getNome())
                .build();
    }

    @Override
    public void deletar(Integer id) {
        clienteRepository.findById(id).
                map(clienteEntity -> {
                    this.clienteRepository.delete(clienteEntity);
                    return clienteEntity;
                }).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));
    }

    @Override
    public void update(Cliente cliente) {
        final ClienteEntity c = modelMapper.map(cliente, ClienteEntity.class);
        clienteRepository.save(c);
    }

    @Override
    public List<Cliente> findAll(Cliente cliente) {
        ClienteEntity c = modelMapper.map(cliente, ClienteEntity.class);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(c, matcher);
        Type listType = new TypeToken<List<Cliente>>() {}.getType();
        return modelMapper.map(clienteRepository.findAll(example), listType);
    }
}
