package br.com.alefe.bankexchange.repositories;

import br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioDto;
import br.com.alefe.bankexchange.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT NEW br.com.alefe.bankexchange.controllers.dto.usuario.UsuarioDto(u.senha,u.pessoa) FROM Usuario  u")
    Page<UsuarioDto> getAll (Pageable pageable);
}
