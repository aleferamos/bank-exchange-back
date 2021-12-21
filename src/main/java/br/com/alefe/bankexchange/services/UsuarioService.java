package br.com.alefe.bankexchange.services;

import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioDto;
import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioFormDto;
import br.com.alefe.bankexchange.models.Usuario;
import br.com.alefe.bankexchange.repositories.UsuarioRepository;
import br.com.alefe.bankexchange.util.enums.usuario.TipoUsuarioEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public Page<UsuarioDto> getAll(Pageable pageable){
        return usuarioRepository.getAll(pageable);
    }

    public Usuario save(UsuarioFormDto usuarioFormDto){
        Usuario usuario = modelMapper.map(usuarioFormDto, Usuario.class);
        usuario.setTipo(TipoUsuarioEnum.USER);
        return usuarioRepository.save(usuario);
    }
}
