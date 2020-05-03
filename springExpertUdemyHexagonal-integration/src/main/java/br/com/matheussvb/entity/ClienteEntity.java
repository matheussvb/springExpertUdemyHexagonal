package br.com.matheussvb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table( name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

//    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
//    private Set<PedidoEntity> pedidos;

    public ClienteEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}