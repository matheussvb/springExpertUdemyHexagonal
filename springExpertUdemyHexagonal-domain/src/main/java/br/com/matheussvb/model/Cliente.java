package br.com.matheussvb.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cliente {

    private Integer id;
    private String nome;
    private String cpf;

}
