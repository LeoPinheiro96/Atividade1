/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.dao.usuario;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mack.entities.Usuario;
import mack.entities.UsuarioImpl;

/**
 *
 * @author 31432778
 */
public class UsuarioDAOJPAImpl implements UsuarioDAO {

    private EntityManagerFactory emf;

    public UsuarioDAOJPAImpl() {
        emf = Persistence.createEntityManagerFactory("Atividade01PU");

    }

    @Override
    public Usuario buscaUsuarioPorId(int id) throws UsuarioNaoEncontradoException {
        EntityManager em = emf.createEntityManager();
        Usuario x = em.getReference(Usuario.class, id);
        return x;
    }

    @Override
    public Collection buscaUsuarioPorNome(String nome) {
        EntityManager em = emf.createEntityManager();
        Collection<Usuario> x = em.getReference(Collection.class, nome);
        return x;
    }

    @Override
    public Collection buscaTodosUsuarios() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Aluno e"); // mudar o nome do banco
        Collection<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    @Override
    public void removeUsuario(int id) throws UsuarioNaoEncontradoException {
        EntityManager em = emf.createEntityManager();
        Usuario a = em.find(Usuario.class, id);
        em.remove(a);
    }

    @Override
    public Usuario criaUsuario(String nome, String sobrenome) {
        EntityManager em = emf.createEntityManager();
        Usuario newUsuario = new UsuarioImpl(nome, sobrenome);
        em.persist(newUsuario);
        return newUsuario;
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
