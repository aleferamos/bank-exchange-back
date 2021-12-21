package br.com.alefe.bankexchange.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ErroDto {

    private String erro;
    private String propriedade;

    public ErroDto(String erro, String propriedade) {
        super();
        this.erro = erro;
        this.propriedade = propriedade;
    }

    public ErroDto(String erro) {
        this.erro = erro;
    }


}
