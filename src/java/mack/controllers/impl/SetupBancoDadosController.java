/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioUtil;

/**
 *
 * @author 31432778
 */
public class SetupBancoDadosController extends AbstractController {
    
    @Override
    public void execute() {
        try {
            UsuarioUtil.setupUsuarioTable();
            
            this.setReturnPage("/index.html");
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
