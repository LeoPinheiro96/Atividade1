/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.controllers.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
 * @author Leonardo
 */
public class PesquisaController extends AbstractController {

    public void execute() {
        try {
                
            String nome = this.getRequest().getParameter("nome");
            String sobrenome = this.getRequest().getParameter("sobrenome");
                    
            
            UsuarioDAO conexaoUsuario = UsuarioDAOFactory.getUsuarioDAO();
            Collection<Usuario> usuariosEncontrados = (Collection<Usuario>) conexaoUsuario.buscaUsuarioPorNome(nome);

            this.setReturnPage("/retorno.jsp");
            
            Usuario usuarioEncontrado = null;

            for (Usuario user : usuariosEncontrados) {
                if (user.getSobrenome().equals(sobrenome)) {
                    usuarioEncontrado = user;
                    break;
                }
            }

            this.getRequest().setAttribute("usuarioEncontrado", usuarioEncontrado);

        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
