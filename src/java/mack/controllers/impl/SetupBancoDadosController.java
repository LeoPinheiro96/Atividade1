package mack.controllers.impl;

import javax.servlet.http.*;
import java.io.*;import java.util.*;
import mack.controllers.AbstractController;
import mack.dao.exception.DAORuntimeException;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.dao.usuario.UsuarioUtil;
import org.apache.commons.logging.*;

public class SetupBancoDadosController extends AbstractController {

    static final private Log log = LogFactory.getLog(SetupBancoDadosController.class);

    @Override
    public void execute() {
        setupDemo();
    }

    private void setupDemo() {
        Exception caught = null;
        UsuarioDAO dao = null;
        try {
            log.info("Setup de tabelas");
            UsuarioUtil.setupUsuarioTable();
            log.info("Setup de tabelas executado");
            dao = UsuarioDAOFactory.getUsuarioDAO("UsuarioDAOImpl");
            log.info("Creating usuarios");
            dao.criaUsuario("Mack", "Filho");
            dao.criaUsuario("Mack", "Net");
            dao.criaUsuario("Mack", "Junior");
            dao.criaUsuario("Mack", "Pai");

            log.info("Usuarios criados");

        } catch (Exception ex) {
            caught = ex;
            log.error(ex);
        } finally {
            dao.close();
            if (caught != null) {
                throw new DAORuntimeException(caught);
            }
        }
    }
}
