package br.com.matheussvb.port.driven;

import br.com.matheussvb.model.Cliente;

import java.util.List;

public interface ClienteJpaPort {

    Cliente getClienteById(Integer id);
    Cliente save(Cliente cliente);
    void deletar(Integer id);
    void update(Cliente cliente);
    List<Cliente> findAll(Cliente cliente);

}
