/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.dao.usuario;

import java.util.Collection;
import javax.persistence.EntityManager;
import mack.entities.Usuario;
import mack.entities.UsuarioImpl;

/**
 *
 * @author 31432778
 */
public class UsuarioDAOJPAImpl implements UsuarioDAO{

    private EntityManager em;
    
    public UsuarioDAOJPAImpl()
    {
        em = null;
       
    }
    
    @Override
    public Usuario buscaUsuarioPorId(int id) throws UsuarioNaoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection buscaUsuarioPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection buscaTodosUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUsuario(int id) throws UsuarioNaoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario criaUsuario(String nome, String sobrenome) {
        Usuario newUsuario = new UsuarioImpl(nome, sobrenome);
        
    }

    @Override
    public void updateUsuario(int id, String nome, String sobrenome) throws UsuarioNaoEncontradoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
