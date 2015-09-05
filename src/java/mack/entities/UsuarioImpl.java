/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author Leonardo
 */

@Entity
@Table(name="USUARIO")
public class UsuarioImpl implements Usuario, Serializable {

   @Id

    @Column(name="usuario_id")

    @SequenceGenerator(name="usuarioGenerator", sequenceName="usuario_id_seq",allocationSize=1)

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuarioGenerator")

    private int id;
    
    @Column(name="NOME")
    private String nome;
    
    @Column(name="SOBRENOME")
    private String sobrenome;
    
    public UsuarioImpl()
    {
        
    }

    public UsuarioImpl(String nome, String sobrenome) {
        this();
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public UsuarioImpl(int id, String nome, String sobrenome) {
        this();
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
