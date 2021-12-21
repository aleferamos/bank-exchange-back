package br.com.alefe.bankexchange.controllers;

import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaDto;
import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaFormDto;
import br.com.alefe.bankexchange.models.Pessoa;
import br.com.alefe.bankexchange.services.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/todas")
    public ResponseEntity<Page<PessoaDto>> listar(Pageable pageable){
        return ResponseEntity.ok(pessoaService.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Long> salvar(@Valid @RequestBody PessoaFormDto pessoaFormDto){
        Pessoa pessoaSalvar = pessoaService.save(pessoaFormDto);
        URI uri = UriComponentsBuilder.fromPath("/pessoa").buildAndExpand(pessoaSalvar.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoaSalvar.getId());
    }
}
