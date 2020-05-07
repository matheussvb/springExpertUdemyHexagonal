package br.com.matheussvb.controller;

import br.com.matheussvb.model.pedido.PedidoRequest;
import br.com.matheussvb.model.pedido.PedidoRequestDTO;
import br.com.matheussvb.model.pedido.PedidoResponseDTO;
import br.com.matheussvb.model.pedido.itempedido.InformacoesPedidoResponse;
import br.com.matheussvb.port.driver.PedidoPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PedidoPort pedidoPort;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer salvar(@RequestBody @Valid PedidoRequest pedidoRequest) {
        PedidoRequestDTO pedRequest = modelMapper.map(pedidoRequest, PedidoRequestDTO.class);
        PedidoResponseDTO pedidoSalvo = pedidoPort.save(pedRequest);
        return pedidoSalvo.getId();
    }

    @GetMapping("{id}")
    public InformacoesPedidoResponse obterPedidoCompleto(@PathVariable("id") Integer id){
        pedidoPort.obterPedidoCompleto(id);
        return null;
    }

}
