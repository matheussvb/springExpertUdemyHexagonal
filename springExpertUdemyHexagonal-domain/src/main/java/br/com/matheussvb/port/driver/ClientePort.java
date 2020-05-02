package br.com.matheussvb.port.driver;

import br.com.matheussvb.model.Cliente;

import java.util.List;

public interface ClientePort {

    Cliente findClienteById(Integer id);
    Cliente save(Cliente cliente);
    void deletar(Integer id);
    void update(Integer id, Cliente cliente);
    List<Cliente> findAll(Cliente cliente);

}
