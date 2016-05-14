package epm.senacrs.com.br.exemploactionbar.model;

import java.io.Serializable;

/**
 * Created by Gaspar <gaspar.teixeira@gmail.com> on 14/05/16.
 */
public class Contato implements Serializable{

    private Integer id;
    private String nome, telefone, email;

    public Contato() {
    }

    public Contato(Integer id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
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
}
