package br.com.matheussvb.controller;

import br.com.matheussvb.model.RestResponse;
import br.com.matheussvb.model.cliente.ClienteResponse;
import br.com.matheussvb.port.driver.ClientePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClientePort cliente;

    @GetMapping("{id}")
    public RestResponse<ClienteResponse> getClienteById(@PathVariable Integer id){
        cliente.findClienteById(id);


        return null;
    }


}
