package br.com.matheussvb.port.driver;

import br.com.matheussvb.model.Cliente;

public interface ClientePort {

    Cliente findClienteById(Integer id);

}
