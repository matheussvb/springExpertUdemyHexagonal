package br.com.matheussvb.port.driven;

import br.com.matheussvb.model.Cliente;

public interface ClienteJpaPort {

    Cliente getClienteById(Integer id);

}
