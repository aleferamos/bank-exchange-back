package br.com.alefe.bankexchange.models;

import br.com.alefe.bankexchange.util.enums.usuario.TipoUsuarioEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "[usuario]")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "senha")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", foreignKey = @ForeignKey(name = "usuario_pessoa"))
    private Pessoa pessoa;

    @Column(name = "tipo")
    private TipoUsuarioEnum tipo;
}
