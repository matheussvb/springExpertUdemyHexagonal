package br.com.matheussvb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_pedido")
public class ItemPedidoEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @Column
    private Integer quantidade;

}
