package mack.dao.usuario;

final class UsuarioConstantes {

    static public final String URL = "jdbc:derby://localhost:1527/BDAtividade1";
    static public final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static public final String USER = "mackenzie";
    static public final String PASSWORD = "mackenzie";
    static public final String USUARIO_DATASOURCE_NAME = "java:comp/env/jdbc/FilmesNonXADataSource";
    static public final String USUARIO_TABLE_NAME = "usuario";
    static public final String USUARIO_ID_SEQUENCE_NAME = "usuario_id_seq";

    private UsuarioConstantes() {
    }
}
