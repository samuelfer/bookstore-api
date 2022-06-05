package com.marhasoft.bookstore.dtos;

import com.marhasoft.bookstore.domain.Categoria;
import com.marhasoft.bookstore.domain.Igreja;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class IgrejaDTO {

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

    public IgrejaDTO() {
        super();
    }

    public IgrejaDTO(Igreja igreja) {
        super();
        this.id = igreja.getId();
        this.nome = igreja.getNome();
        this.telefone = igreja.getTelefone();
        this.email = igreja.getEmail();
        this.localidade = igreja.getLocalidade();
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
}
