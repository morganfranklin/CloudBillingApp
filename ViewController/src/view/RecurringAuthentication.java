package view;

import java.io.IOException;
import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.view.rich.render.ClientEvent;

public class RecurringAuthentication implements Serializable {
    @SuppressWarnings("compatibility:-5216975661736025243")
    private static final long serialVersionUID = 1L;

    private String resolveEl(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, data, Object.class);
        String Message = valueExp.getValue(elContext).toString();
        return Message;
    }

    public RecurringAuthentication() {
    }

    public void validateToken(ClientEvent clientEvent) {

        boolean isAuthenticated = false;
        String resolvedUser = "";

        try {

            resolvedUser = resolveEl("#{PeopleSoftCallSecurityFilter.retrievedToken}");

        } catch (Exception e) {

        }

        if (resolvedUser.length() > 0) {
            System.out.println("found user " + resolvedUser);
        } else {

            System.out.println("no user found");

            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = fctx.getExternalContext();

            String viewId = "unauthorized.jsf";
            ControllerContext controllerCtx = null;
            controllerCtx = ControllerContext.getInstance();
            String activityURL = controllerCtx.getGlobalViewActivityURL(viewId);
            try {
                ectx.redirect(activityURL);
            } catch (IOException e) {
                //Can't redirect
                e.printStackTrace();
            }


        }

    }
}
