package br.com.alefe.bankexchange.controllers.dto.cadastrarUsuario;

import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaFormDto;
import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioFormDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarUsuarioFormDto {

    private UsuarioFormDto usuarioFormDto;
    private PessoaFormDto pessoaFormDto;
}
