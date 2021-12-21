package br.com.alefe.bankexchange.controllers.dto.pessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {

    private Long id;
    private String nome;
    private String email;

    public PessoaDto(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
