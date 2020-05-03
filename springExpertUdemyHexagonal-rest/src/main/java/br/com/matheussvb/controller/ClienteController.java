package br.com.matheussvb.controller;

import br.com.matheussvb.model.ClienteDTO;
import br.com.matheussvb.model.RestResponse;
import br.com.matheussvb.model.cliente.ClienteRequest;
import br.com.matheussvb.model.cliente.ClienteResponse;
import br.com.matheussvb.port.driver.ClientePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClientePort clientePort;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse<ClienteResponse> save(@RequestBody @Valid ClienteRequest cliente) {
        return new RestResponse<>(modelMapper.map(
                clientePort.save(
                        modelMapper.map(cliente, ClienteDTO.class)
                ), ClienteResponse.class)
        );
    }

    @GetMapping("{id}")
    public RestResponse<ClienteResponse> getClienteById(@PathVariable Integer id) {
        ClienteResponse response = modelMapper.map(clientePort.findClienteById(id), ClienteResponse.class);
        return new RestResponse<>(response);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        clientePort.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody @Valid ClienteRequest cliente) {
        ClienteDTO c = ClienteDTO.builder()
                .cpf(cliente.getCpf())
                .nome(cliente.getNome())
                .build();
        clientePort.update(id, c);
    }



    @GetMapping
    public RestResponse<List<ClienteResponse>> find(ClienteRequest cliente) {
        List<ClienteDTO> all = clientePort.findAll(modelMapper.map(cliente, ClienteDTO.class));

        List<ClienteResponse> response = all.stream().map(
                cli -> ClienteResponse.builder()
                        .nome(cli.getNome())
                        .cpf(cli.getCpf())
                        .id(cli.getId())
                        .build()
        ).collect(Collectors.toList());
        return new RestResponse<>(response);
    }
}
