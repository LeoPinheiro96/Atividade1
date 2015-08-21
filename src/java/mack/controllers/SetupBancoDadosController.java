package mack.controllers;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import mack.dao.exception.DAORuntimeException;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.dao.usuario.UsuarioUtil;
import org.apache.commons.logging.*;

public class SetupBancoDadosController extends HttpServlet {

    static final private Log log = LogFactory.getLog(SetupBancoDadosController.class);

    public void setupDemo() {
        Exception caught = null;
        UsuarioDAO dao = null;
        try {
            log.info("Setup de tabelas");
            UsuarioUtil.setupUsuarioTable();
            log.info("Setup de tabelas executado");
            dao = UsuarioDAOFactory.getUsuarioDAO();
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

    public void doGet(final HttpServletRequest req,
            final HttpServletResponse resp)
            throws java.io.IOException {
        String strMsg = "";
        try {
            setupDemo();
            strMsg = "Success!";
        } catch (Exception ex) {
            java.io.StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            strMsg = sw.getBuffer().toString();
        }
        String strHTML = buildResponsePage(strMsg);
        resp.setContentType("text/html");
        resp.setContentLength(strHTML.length());
        resp.setHeader("Cache-Control", "no-cache");
        PrintWriter writer = resp.getWriter();
        writer.println(strHTML);
        writer.flush();
    }

    private String buildResponsePage(String strMsg) {
        StringBuffer sbHTML = new StringBuffer();
        sbHTML.append("<html>");
        sbHTML.append("<body>");
        sbHTML.append(new java.util.Date());
        sbHTML.append("<br>");
        sbHTML.append("<pre>");
        sbHTML.append(strMsg);
        sbHTML.append("</pre>");
        sbHTML.append("</body>");
        sbHTML.append("</html>");
        return sbHTML.toString();
    }
}
