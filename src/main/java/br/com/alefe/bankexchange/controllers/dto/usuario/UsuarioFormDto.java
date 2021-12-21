package br.com.alefe.bankexchange.controllers.dto.usuario;

import br.com.alefe.bankexchange.models.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormDto {

    private String senha;

    private Pessoa pessoa;
}
