package mack.dao.usuario;

public final class UsuarioDAOFactory {

    private UsuarioDAOFactory() {
    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImpl();
    }
}
