package br.com.matheussvb.model.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteResponse {

    @JsonProperty("codigo_cliente")
    private Integer id;

    @JsonProperty("nome_cliente")
    private String nome;

    @JsonProperty("cpf_cliente")
    private String cpf;


}