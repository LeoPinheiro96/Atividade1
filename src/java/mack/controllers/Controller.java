/*
Essa interface garante as assinaturas 3 metodos, execute, getReturnPage e init. 
O metodo init coloca o request no atributo request da classe, o metodo execute
faz as operações do negocio, e getReturnPage coloca na variavel a pagina que vai
retornar pro browser
 */
package mack.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 31437052
 */

//Interface de controller
public interface Controller {

    public void execute();

    public String getReturnPage();

    public void init(HttpServletRequest request);
}
