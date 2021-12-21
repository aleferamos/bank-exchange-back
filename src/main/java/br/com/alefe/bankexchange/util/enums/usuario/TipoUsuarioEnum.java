package br.com.alefe.bankexchange.util.enums.usuario;

public enum TipoUsuarioEnum {

    DEV("desenvolvedora"),
    USER("usuario");

    private String descricao;

    TipoUsuarioEnum(String descricao) {
        this.descricao = descricao;
    }
}
