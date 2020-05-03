package br.com.matheussvb.model.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoResponse {

    @JsonProperty("codigo_pruduto")
    private Integer id;

    @JsonProperty("descricao_produto")
    private String descricao;

    @JsonProperty("preco_produto")
    private BigDecimal preco;
}
