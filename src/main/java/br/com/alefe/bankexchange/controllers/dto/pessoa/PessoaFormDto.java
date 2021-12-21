package br.com.alefe.bankexchange.controllers.dto.pessoa;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PessoaFormDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
}
