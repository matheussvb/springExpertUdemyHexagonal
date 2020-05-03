package br.com.matheussvb.port.driven;

import br.com.matheussvb.model.ClienteDTO;

import java.util.List;

public interface ClienteJpaPort {

    ClienteDTO getClienteById(Integer id);
    ClienteDTO save(ClienteDTO cliente);
    void deletar(Integer id);
    void update(ClienteDTO cliente);
    List<ClienteDTO> findAll(ClienteDTO cliente);

}
