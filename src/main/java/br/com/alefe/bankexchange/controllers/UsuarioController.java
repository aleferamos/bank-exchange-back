package br.com.alefe.bankexchange.controllers;

import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioDto;
import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioFormDto;
import br.com.alefe.bankexchange.models.Usuario;
import br.com.alefe.bankexchange.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<UsuarioDto>> listar(Pageable pageable){
        return ResponseEntity.ok(usuarioService.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Long> salvar(@RequestBody UsuarioFormDto usuarioFormDto){
        Usuario usuario = usuarioService.save(usuarioFormDto);
        URI uri = UriComponentsBuilder.fromPath("/usuario").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario.getId());
    }
}
