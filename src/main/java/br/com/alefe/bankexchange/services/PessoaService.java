package br.com.alefe.bankexchange.services;

import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaDto;
import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaFormDto;
import br.com.alefe.bankexchange.exceptions.RegraDeNegocioException;
import br.com.alefe.bankexchange.models.Pessoa;
import br.com.alefe.bankexchange.repositories.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, ModelMapper modelMapper) {
        this.pessoaRepository = pessoaRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PessoaDto> getAll(Pageable pageable){
        return pessoaRepository.listarPessoas(pageable);
    }

    public Pessoa save(PessoaFormDto pessoaFormDto){
        Pessoa pessoa = modelMapper.map(pessoaFormDto, Pessoa.class);
        Boolean emailExist = pessoaRepository.emailExist(pessoa.getEmail(), pessoa.getId() != null ? pessoa.getId() : null);
        if(emailExist){
            throw new RegraDeNegocioException("pessoa.emailCadastrado");
        }
        Pessoa pessoaSalvar = pessoaRepository.save(pessoa);
        return pessoaSalvar;
    }
}
