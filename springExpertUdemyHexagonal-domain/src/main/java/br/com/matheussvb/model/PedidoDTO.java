package br.com.matheussvb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer id;
    private ClienteDTO cliente;
    private LocalDate dataPedido;
    private BigDecimal total;
//    private StatusPedido status;
//    private List<ItemPedido> itens;

}