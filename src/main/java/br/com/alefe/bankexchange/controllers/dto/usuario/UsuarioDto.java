package br.com.alefe.bankexchange.controllers.dto.usuario;

import br.com.alefe.bankexchange.models.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private Long id;

    private String senha;

    private Pessoa pessoa;

    public UsuarioDto(String senha, Pessoa pessoa) {
        this.senha = senha;
        this.pessoa = pessoa;
    }
}
