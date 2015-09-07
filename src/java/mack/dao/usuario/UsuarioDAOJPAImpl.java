/*
 Uma das principais mudanças que foram feitas para o uso do JPA foram nas 
classes que herdam da classe AbstractController, colocar UsuarioDAOJPAImpl como
parametro do metodo getUsuarioDAO. Não foi necessario mexer nas paginas JSP e 
html, pois a entrada e saida é a mesma.
 */
package mack.dao.usuario;

import java.util.ArrayList;
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
        emf = Persistence.createEntityManagerFactory("PersistenciaConfig");
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
        Query query =  em.createQuery("SELECT e FROM UsuarioImpl as e WHERE e.nome = :paramNome");
        query.setParameter("paramNome", nome);
        
        
        return query.getResultList();
        
    }
    
    @Override
    public Collection buscaTodosUsuarios() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM UsuarioImpl e"); // mudar o nome do banco

        Collection usuarios = query.getResultList();
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
        EntityManager em = emf.createEntityManager();
        UsuarioImpl x = em.find(UsuarioImpl.class, id);

        if (x != null) {
            x.setNome(nome);
            x.setSobrenome(sobrenome);
            em.getTransaction().begin();
            em.merge(x);
            em.getTransaction().commit();
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }
    }

    @Override
    public void close() {
        if (emf.isOpen())
            emf.close();
    }

    @Override
    public boolean isClosed() {
        return !emf.isOpen();
    }
}
