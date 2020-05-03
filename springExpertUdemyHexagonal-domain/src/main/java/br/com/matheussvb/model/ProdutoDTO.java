package br.com.matheussvb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProdutoDTO {

    private Integer id;
    private String descricao;
    private BigDecimal preco;

}