package com.medvoll.ApiProject.entities;

import com.medvoll.ApiProject.entities.DTO.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String uf;
    private String cidade;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
    }


    public Endereco updateEndereco(Endereco dados) {
        if(dados.logradouro != null) {
            this.logradouro = dados.logradouro;
        }
        if(dados.bairro != null) {
            this.bairro = dados.bairro;
        }
        if(dados.cep != null) {
            this.cep = dados.cep;
        }
        if(dados.numero != null) {
            this.numero = dados.numero;
        }
        if(dados.complemento != null) {
            this.complemento = dados.complemento;
        }
        if(dados.uf != null) {
            this.uf = dados.uf;
        }
        if(dados.cidade != null) {
            this.cidade = dados.cidade;
        }
    }
}
