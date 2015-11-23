/*As modificações necessarias foram:
precisava mudar o nome no index.html, senão não iria achar a classe, e tambem dentro do index que virou lista,
tem uma linha no tratamento de excessão que pega o nome da classe lsita controller para dar o logger da mesma*/
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
            UsuarioDAO conexaoUsuario = UsuarioDAOFactory.getUsuarioDAO("UsuarioDAOJPAImpl");
            Collection usuarios = conexaoUsuario.buscaTodosUsuarios();
                                 
            this.setReturnPage("/index.jsp");
            this.getRequest().setAttribute("usuarios", usuarios);
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/**
 No caso do DAO, para chegar os dados na pagina JSP acontece a seguinte troca de mensagens:
 * A pagina index.HTML chama o frontcontroller com um valor na variavel control, que no
 * caso é lista. o FrontControler pega o parametro de control e pega esse paramentro e 
 * manda para o controller factory que usando o metodo getControllerByFullClassName
 * indendifica a classe que vai ser usada, que no caso é ListaController. Já no lista
 * controller, o metodo execute se encarrega de fazer a parte de lista todos os usuarios
 * da base de dados e retorna a pagina index.jsp com um atributo junto, que nesse atributo possui
 * o array dos usuarios. A pagina jsp faz a leitura e exibição dos dados.
 */