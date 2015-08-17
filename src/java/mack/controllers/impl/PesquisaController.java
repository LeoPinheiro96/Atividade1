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
import mack.entities.UsuarioImpl;

/**
 *
 * @author Leonardo
 */
public class PesquisaController extends AbstractController {

    public void execute() {
        try {

        List usuarios = new ArrayList();
            usuarios.add(new UsuarioImpl("Mack", "Junior"));
            usuarios.add(new UsuarioImpl("Mack", "Neto"));
        String nome = this.getRequest().getParameter("nome");
          Iterator itr = usuarios.iterator();
      while(itr.hasNext()) {
          if(usuarios.toString().equals(nome)){
              int retorno = 1;
              this.setReturnPage("/retorno.jsp");
            this.getRequest().setAttribute("retorno", retorno);
          }
      }
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
