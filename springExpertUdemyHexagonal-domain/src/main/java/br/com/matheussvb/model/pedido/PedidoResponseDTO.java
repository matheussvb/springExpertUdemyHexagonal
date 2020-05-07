package br.com.matheussvb.model.pedido;

import br.com.matheussvb.model.ClienteDTO;
import br.com.matheussvb.model.StatusPedido;
import br.com.matheussvb.model.pedido.itempedido.ItemPedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoResponseDTO {

    private Integer id;
    private ClienteDTO cliente;
    private LocalDate dataPedido;
    private BigDecimal total;
    private StatusPedido status;
    private List<ItemPedidoDTO> itens;
}
