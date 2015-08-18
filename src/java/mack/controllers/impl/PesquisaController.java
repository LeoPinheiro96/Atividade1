/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.controllers.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.entities.Usuario;
import mack.entities.UsuarioImpl;

/**
 *
 * @author Leonardo
 */
public class PesquisaController extends AbstractController {

    public void execute() {
        try {

            List<Usuario> usuarios = new ArrayList();
            usuarios.add(new UsuarioImpl("Mack", "Junior"));
            usuarios.add(new UsuarioImpl("Mack", "Neto"));

            String nome = this.getRequest().getParameter("nome");
            this.setReturnPage("/retorno.jsp");
            
            Usuario usuarioEncontrado = null;

            for (Usuario user : usuarios) {
                if ((user.getNome() + " " + user.getSobrenome()).equals(nome)) {
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
