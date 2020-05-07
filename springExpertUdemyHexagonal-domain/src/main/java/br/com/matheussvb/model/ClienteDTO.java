package br.com.matheussvb.model;


import br.com.matheussvb.model.pedido.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Set<PedidoDTO> pedidos;

}
