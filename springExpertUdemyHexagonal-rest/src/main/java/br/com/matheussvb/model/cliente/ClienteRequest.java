package br.com.matheussvb.model.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotEmpty(message = "Campo nome é obrigatório")
    @JsonProperty("nome_cliente")
    private String nome;

    @NotEmpty(message = "Campo cpf é obrigatório")
    @CPF(message = "Informe um CPF válido")
    private String cpf;

}
