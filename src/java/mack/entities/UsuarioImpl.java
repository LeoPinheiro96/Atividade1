/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.entities;

/**
 *
 * @author Leonardo
 */
public class UsuarioImpl implements Usuario {

    private int id;
    private String nome;
    private String sobrenome;

    public UsuarioImpl(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public UsuarioImpl(int id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getSobrenome() {
        return sobrenome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        StringBuffer sbResult = new StringBuffer();
        sbResult.append("id = ");
        sbResult.append(id);
        sbResult.append(", nome = ");
        sbResult.append(nome);
        sbResult.append(", sobrenome = ");
        sbResult.append(sobrenome);
        return sbResult.toString();
    }

}
