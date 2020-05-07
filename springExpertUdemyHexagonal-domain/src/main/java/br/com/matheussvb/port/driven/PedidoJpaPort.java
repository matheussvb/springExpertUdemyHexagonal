package br.com.matheussvb.port.driven;

import br.com.matheussvb.model.pedido.PedidoRequestDTO;
import br.com.matheussvb.model.pedido.PedidoResponseDTO;
import br.com.matheussvb.model.pedido.itempedido.InformacaoPedidoDTO;
import br.com.matheussvb.model.pedido.itempedido.ItemPedidoDTO;

public interface PedidoJpaPort {

    PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO);
    InformacaoPedidoDTO obterPedidoCompleto(Integer id);

}
