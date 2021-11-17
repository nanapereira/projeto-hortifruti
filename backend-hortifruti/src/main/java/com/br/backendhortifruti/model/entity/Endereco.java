package com.br.backendhortifruti.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer id;

    @Column(name="cep")
    private String cep;

    @Column(name="cidade")
    private String cidade;

    @Column (name="bairro")
	private String bairro;

    @Column(name="estado")
    private String estado;

    @Column(name="rua")
    private String rua;

    @Column(name="complemento")
    private String complemento;

    @Column(name="numero")
    private Integer numero;

}
