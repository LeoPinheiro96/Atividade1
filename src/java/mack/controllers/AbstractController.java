/*
Essa Classe possui os 2 atritutos, sendo um de HttpServletRequest e outro do
tipo String. Também possui as implemt
*/
package mack.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 31437052
 */
public abstract class AbstractController implements Controller {

    private HttpServletRequest request;
    protected String returnPage;

    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }

    public void setReturnPage(String page) {
        returnPage = page;
    }

    public String getReturnPage() {
        return returnPage;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    

}
