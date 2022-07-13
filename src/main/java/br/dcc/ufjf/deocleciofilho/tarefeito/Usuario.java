package br.dcc.ufjf.deocleciofilho.tarefeito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @NotBlank(message = "É preciso um nome!")
    private String nome;
    @NotBlank(message = "É preciso um senha!")
    private String password;

    public Usuario(Long id, @NotBlank(message = "É preciso um nome!") String nome,
        @NotBlank(message = "É preciso um senha!") String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    

}
