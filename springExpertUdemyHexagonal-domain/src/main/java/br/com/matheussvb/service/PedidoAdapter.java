package br.com.matheussvb.service;

import br.com.matheussvb.model.pedido.PedidoRequestDTO;
import br.com.matheussvb.model.pedido.PedidoResponseDTO;
import br.com.matheussvb.model.pedido.itempedido.InformacaoPedidoDTO;
import br.com.matheussvb.port.driven.PedidoJpaPort;
import br.com.matheussvb.port.driver.PedidoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PedidoAdapter")
public class PedidoAdapter implements PedidoPort {

    @Autowired
    private PedidoJpaPort pedidoJpaPort;

    @Override
    public PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO) {
        PedidoResponseDTO pedidoSalvo = pedidoJpaPort.save(pedidoRequestDTO);
        return pedidoSalvo;
    }

    @Override
    public InformacaoPedidoDTO obterPedidoCompleto(Integer id) {
        pedidoJpaPort.obterPedidoCompleto(id);
        return null;
    }


}
