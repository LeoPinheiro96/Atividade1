package mack.dao.usuario;

public final class UsuarioDAOFactory {

    private UsuarioDAOFactory() {
    }

    public static UsuarioDAO getUsuarioDAO(String className) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {

        String name = "mack.dao.usuario." + className;
        Class actionClass = Class.forName(name);

        return (UsuarioDAO) actionClass.newInstance();

    }
}
