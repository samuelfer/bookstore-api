package com.marhasoft.bookstore.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Igreja implements Serializable {

    private final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O nome é obrigatório")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "O telefone é obrigatório")
    @Length(min = 10, max = 11, message = "O campo telefone deve ter entre 10 e 11 caracteres")
    private String telefone;

    @NotEmpty(message = "O email é obrigatório")
    @Email
    private String email;

    @NotEmpty(message = "A localidade é obrigatória")
    private String localidade;


    public Igreja() {
        super();
    }

    public Igreja(Integer id, String nome, String telefone, String email, String localidade) {
        super();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.localidade = localidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Igreja igreja = (Igreja) o;
        return Objects.equals(id, igreja.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
