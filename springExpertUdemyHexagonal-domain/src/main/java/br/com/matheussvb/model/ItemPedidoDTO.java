package br.com.matheussvb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Integer id;
    private PedidoDTO pedido;
    private ProdutoDTO produto;
    private Integer quantidade;

}