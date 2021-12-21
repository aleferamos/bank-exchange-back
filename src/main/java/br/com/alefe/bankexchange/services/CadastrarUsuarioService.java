package br.com.alefe.bankexchange.services;

import br.com.alefe.bankexchange.controllers.dto.cadastrarUsuario.CadastrarUsuarioDto;
import br.com.alefe.bankexchange.controllers.dto.cadastrarUsuario.CadastrarUsuarioFormDto;
import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaDto;
import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaFormDto;
import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioDto;
import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioFormDto;
import br.com.alefe.bankexchange.models.Pessoa;
import br.com.alefe.bankexchange.models.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CadastrarUsuarioService {

    private PessoaService pessoaService;
    private UsuarioService usuarioService;
    private ModelMapper modelMapper;

    @Autowired
    public CadastrarUsuarioService(PessoaService pessoaService, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public CadastrarUsuarioFormDto save(CadastrarUsuarioFormDto cadastrarUsuarioFormDto){

        CadastrarUsuarioFormDto cadastrarUsuario = new CadastrarUsuarioFormDto();

        Pessoa pessoa = pessoaService.save(cadastrarUsuarioFormDto.getPessoaFormDto());
        UsuarioFormDto usuario = cadastrarUsuarioFormDto.getUsuarioFormDto();
        usuario.setPessoa(pessoa);


        System.out.println();
        PessoaFormDto pessoaConvert = modelMapper.map(pessoa, PessoaFormDto.class);
        UsuarioFormDto usuarioConvert = modelMapper.map(usuarioService.save(usuario), UsuarioFormDto.class);

        cadastrarUsuario.setPessoaFormDto(pessoaConvert);
        cadastrarUsuario.setUsuarioFormDto(usuarioConvert);

        return cadastrarUsuario;
    }

}
