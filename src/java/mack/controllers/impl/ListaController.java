
package mack.controllers.impl;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.entities.Usuario;
import mack.entities.UsuarioImpl;

/**
 *
 * @author 31437052
 */

//Metodo que cria uma lista da classe de entidade para armazenar os valores e adciona em um atrituto no Request
public class ListaController extends AbstractController {

    public void execute() {
        try {
            UsuarioDAO conexaoUsuario = UsuarioDAOFactory.getUsuarioDAO();
            Collection usuarios = conexaoUsuario.buscaTodosUsuarios();
            
                           
            this.setReturnPage("/index.jsp");
            this.getRequest().setAttribute("usuarios", usuarios);
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
