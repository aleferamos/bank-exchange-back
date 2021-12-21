package br.com.alefe.bankexchange.controllers.dto.cadastrarUsuario;

import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaDto;
import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarUsuarioDto {

    private UsuarioDto usuarioDto;
    private PessoaDto pessoaDto;
}
