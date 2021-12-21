package br.com.alefe.bankexchange.controllers;

import br.com.alefe.bankexchange.controllers.dto.cadastrarUsuario.CadastrarUsuarioDto;
import br.com.alefe.bankexchange.controllers.dto.cadastrarUsuario.CadastrarUsuarioFormDto;
import br.com.alefe.bankexchange.services.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("cadastrar-usuario")
public class CadastrarUsuarioController {

    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    public CadastrarUsuarioController(CadastrarUsuarioService cadastrarUsuarioService) {
        this.cadastrarUsuarioService = cadastrarUsuarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody CadastrarUsuarioFormDto cadastrarUsuarioFormDto){
        CadastrarUsuarioFormDto usuario = cadastrarUsuarioService.save(cadastrarUsuarioFormDto);

        URI uri = UriComponentsBuilder.fromPath("/usuario").buildAndExpand(usuario).toUri();
        return ResponseEntity.created(uri).body("Criado com sucesso");
    }
}
