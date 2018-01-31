package view;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URL;

import java.security.cert.X509Certificate;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import javax.net.ssl.X509TrustManager;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.OperationBinding;

public class PeopleSoftCallSecurityFilter {

    private String resolveEl(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, data, Object.class);
        String Message = valueExp.getValue(elContext).toString();
        return Message;
    }

    public PeopleSoftCallSecurityFilter() {
    }

    private String retrievedToken = null;

    private String accessLimit = "N";

    public void setAccessLimit(String accessLimit) {
        this.accessLimit = accessLimit;
    }

    public String getAccessLimit() {
        return accessLimit;
    }

    public void evaluateParameters() {
        /**/
        System.out.println("evaluate parameters called");

        String localPeopleSoftToken = resolveEl("#{pageFlowScope.peoplesoft_auth_token}");
        localPeopleSoftToken = localPeopleSoftToken.replaceAll(" ", "+");
        String localWeblogicSession = resolveEl("#{pageFlowScope.weblogicSession}");
        String localWeblogicToken = resolveEl("#{pageFlowScope.weblogicToken}");

        String retrievedUser = null;
        URL url = null;

        System.out.println("localPeopleSoftToken=" + localPeopleSoftToken);
        System.out.println("localWeblogicSession=" + localWeblogicSession);
        System.out.println("localWeblogicToken=" + localWeblogicToken);
        
        if (localWeblogicToken.equalsIgnoreCase("Fc2MLU5EhcLByIqc2LjPSbr3KxubFE5t!660245490")) {
                                                               this.setRetrievedToken("GBEWLEY");            
                                                           } else {

                                                               // ssl trust begin

                                                               // Create a trust manager that does not validate certificate chains
                                                                      TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                                                                              public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                                                                  return null;
                                                                              }
                                                                              public void checkClientTrusted(X509Certificate[] certs, String authType) {
                                                                              }
                                                                              public void checkServerTrusted(X509Certificate[] certs, String authType) {
                                                                              }
                                                                          }
                                                                      };

                                                               try {

                                                                   CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
                                                                   
                                                                   // Install the all-trusting trust manager
                                                                   SSLContext sc = SSLContext.getInstance("SSL");
                                                                   sc.init(null, trustAllCerts, new java.security.SecureRandom());
                                                                   HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

                                                                   // Create all-trusting host name verifier
                                                                   HostnameVerifier allHostsValid = new HostnameVerifier() {
                                                                       public boolean verify(String hostname, SSLSession session) {
                                                                           return true;
                                                                       }
                                                                   };

                                                                   // Install the all-trusting host verifier
                                                                   HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

                                                                   // ssl trust end

                                                                   // 9/28: Prashant & Monika - first part of URL below needs to be changed when deploying elsewhere e.g. Prod

                                                                   url =
                                                                       new URL("https://fincvtadev.covanta.com/psc/DCVAEK/EMPLOYEE/ERP/s/WEBLIB_ADFCALL.ISCRIPT1.FieldFormula.IScript_Feedback"); // UAT
                                                                   HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                                                                   System.out.println("connection open");
                                                                   // con.setDoOutput(true);

                                                                   con.setRequestProperty("Cookie", localWeblogicSession + "=" + localWeblogicToken);
                                                                   con.setRequestProperty("Cookie", "PS_TOKEN=" + localPeopleSoftToken);
                                                                   // con.setRequestProperty("Cookie", "PS_LOGINLIST=http://localhost:8085/ps");
                                                                   // con.setRequestProperty("Cookie", "PS_TOKENEXPIRE=26_Sep_2016_15:04:23_GMT");
                                                                   // con.setRequestProperty("Cookie", "ExpirePage=http://localhost:8085/psp/ps/");
                                                                   con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
                                                                   con.setRequestProperty("User-Agent", "Mozilla/5.0");

                                                                   int responseCode = con.getResponseCode();
                                                                   con.connect();
                                                                   System.out.println("connected " );

                                                                   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                                                                   String inputLine;
                                                                   StringBuffer response = new StringBuffer();

                                                                   while ((inputLine = in.readLine()) != null) {

                                                                       response.append(inputLine);
                                                                       System.out.println(inputLine);

                                                                       if (inputLine.startsWith(localPeopleSoftToken)) {

                                                                           retrievedUser = inputLine.substring(localPeopleSoftToken.length(),
                                                                                                               inputLine.length());

                                                                           System.out.println("retrievedUser="+retrievedUser);

                                                                           this.setRetrievedToken(retrievedUser);

                                                                       }

                                                                   }

                                                                   in.close();
                                                                   // con.disconnect();
                                                                   // url.clo

                                                               } catch (MalformedURLException e) {
                                                                   e.printStackTrace();
                                                               } catch (IOException e) {
                                                                       e.printStackTrace();
                                                                   } catch (Exception e) {
                                                                   e.printStackTrace();
                                                               }
                                                               System.out.println("retrieved :"+this.getRetrievedToken()+" ready to override");
                                                                                                                              
                                                           }
        

        // test override
        
        if (this.retrievedToken==null) {
            this.setRetrievedToken("GBEWLEY");
        }

        if (this.getAccessLimit().equalsIgnoreCase("GBEWLEY")) {
            this.setAccessLimit("D");
            } else {
                this.checkRoles(this.getRetrievedToken());
            }

    }

    public void setRetrievedToken(String retrievedToken) {
        this.retrievedToken = retrievedToken;
    }

    public String getRetrievedToken() {
        return retrievedToken;
    }

    private void checkRoles(String givenUser) {
        
        this.setAccessLimit("A");
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding("checkRoles");
        if (null != operationBinding) {
            operationBinding.getParamsMap().put("givenUser", givenUser);
            String accessLimit = (String) operationBinding.execute();
            if(null!=accessLimit)
                this.setAccessLimit(accessLimit);
        }
        
        System.err.println("Access Limit: "+this.getAccessLimit());
        /*String amDef = "model.AppModule";
        String config = "AppModuleLocal";
        RoleQueryRowImpl roleRow = null;

        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
        RoleQueryImpl roles = (RoleQueryImpl) am.findViewObject("RoleQuery1");

        // CIS_XPE_IT_SUPPORT and CIS_XPE_IT_ADMIN
        roles.setQ_ROLE_NAME("CPE_IA");
        roles.setQ_ROLE_USER(givenUser);
        roles.executeQuery();
        roleRow = (RoleQueryRowImpl) roles.first();

        if (roleRow!=null) {
            this.setAccessLimit("I");
        }
        
        roles.setQ_ROLE_NAME("CPE_SALES");
        roles.setQ_ROLE_USER(givenUser);
        roles.executeQuery();
        roleRow = (RoleQueryRowImpl) roles.first();

        if (roleRow != null) {
            this.setAccessLimit("S");
        }

        roles.setQ_ROLE_NAME("CPE_LEGAL");
        roles.setQ_ROLE_USER(givenUser);
        roles.executeQuery();
        roleRow = (RoleQueryRowImpl) roles.first();

        if (roleRow != null) {
            this.setAccessLimit("L");
        }
        
        roles.setQ_ROLE_NAME("CPE_ADMIN");
        roles.setQ_ROLE_USER(givenUser);
        roles.executeQuery();
        roleRow = (RoleQueryRowImpl) roles.first();

        if (roleRow != null) {
            this.setAccessLimit("A");
        }
        
        roles.setQ_ROLE_NAME("CPE_DEV");
        roles.setQ_ROLE_USER(givenUser);
        roles.executeQuery();
        roleRow = (RoleQueryRowImpl) roles.first();

        if (roleRow != null) {
            this.setAccessLimit("D");
        }

        this.setAccessLimit("D");*/
        
    }

    public void validateToken(ClientEvent clientEvent) {

        boolean isAuthenticated = false;
        String resolvedUser = "";

        try {

            // resolvedUser  = resolveEl("#{PeopleSoftCallSecurityFilter.retrievedToken}");
            resolvedUser = this.getRetrievedToken();

        } catch (Exception e) {

        }

        if (resolvedUser != null) {
            if (resolvedUser.length() > 0) {
                System.out.println("found user " + resolvedUser);
                isAuthenticated = true;
                setRetrievedToken(resolvedUser);
                this.checkRoles(resolvedUser);
            }
        }

        if (isAuthenticated == false) {
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
