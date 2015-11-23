package mack.dao.usuario;

final class UsuarioConstantes {

    static public final String URL = "jdbc:derby://localhost:1527/LP3ATV1";
    static public final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static public final String USER = "lp3";
    static public final String PASSWORD = "lp3";
    static public final String USUARIO_DATASOURCE_NAME = "java:comp/env/jdbc/FilmesNonXADataSource";
    static public final String USUARIO_TABLE_NAME = "usuario";
    static public final String USUARIO_ID_SEQUENCE_NAME = "usuario_id_seq";

    private UsuarioConstantes() {
    }
}
