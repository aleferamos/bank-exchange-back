package br.com.alefe.bankexchange.repositories;

import br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaDto;
import br.com.alefe.bankexchange.models.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT NEW br.com.alefe.bankexchange.controllers.dto.pessoa.PessoaDto(p.id, p.nome, p.email) " +
    "FROM Pessoa p "
    )
    Page<PessoaDto> listarPessoas(Pageable pageable);


    @Query("SELECT DISTINCT CASE " +
            "WHEN COUNT(p) > 0 THEN true " +
            "ELSE false " +
            "END " +
            "FROM Pessoa p " +
            "WHERE (p.email = :email) " +
            "AND (p.id <> :id OR :id IS NULL)")
    Boolean emailExist(@Param(value = "email") String email, @Param(value="id") Long id);
}
