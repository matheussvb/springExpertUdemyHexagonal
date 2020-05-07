package br.com.matheussvb.port.driver;

import br.com.matheussvb.model.pedido.PedidoDTO;
import br.com.matheussvb.model.pedido.PedidoRequestDTO;
import br.com.matheussvb.model.pedido.PedidoResponseDTO;
import br.com.matheussvb.model.pedido.itempedido.InformacaoPedidoDTO;

public interface PedidoPort {

    PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO);
    InformacaoPedidoDTO obterPedidoCompleto(Integer id);

}
