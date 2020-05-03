package br.com.matheussvb.port.driver;

import br.com.matheussvb.model.ClienteDTO;

import java.util.List;

public interface ClientePort {

    ClienteDTO findClienteById(Integer id);
    ClienteDTO save(ClienteDTO cliente);
    void deletar(Integer id);
    void update(Integer id, ClienteDTO cliente);
    List<ClienteDTO> findAll(ClienteDTO cliente);

}
