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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.OperationBinding;

import view.utils.ADFUtils;

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
    
    private String userRole;
    

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

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
//        String localPeopleSoftToken = "pAAAAAQDAgEBAAAAvAIAAAAAAAAsAAAABABTaGRyAk4Abwg4AC4AMQAwABTuqHgUYghg4FFJ859gZ6CWDLPFO2QAAAAFAFNkYXRhWHicLYhdCkBAAIQ/Sx7dxMau31e1vEiKkidHcEGHM8lM8800N5DEJorUj+FTNjEQOJjFkzSwMJGtbIzsXHpXKkdBSUeurkWH/7fVdqKXLb3YKiUNvJM1C7s=";
        localPeopleSoftToken = localPeopleSoftToken.replaceAll(" ", "+");
        String localWeblogicSession = resolveEl("#{pageFlowScope.weblogicSession}");
        String localWeblogicToken = resolveEl("#{pageFlowScope.weblogicToken}");
//        String localWeblogicSession = "vmpodcvae014-5012-PORTAL-PSJSESSIONID";
//        String localWeblogicToken = "prerqvhDYez6s8zOw8HMm69J2yifOYXI!682004848";

        String retrievedUser = null;
        URL url = null;

        System.out.println("localPeopleSoftToken=" + localPeopleSoftToken);
        System.out.println("localWeblogicSession=" + localWeblogicSession);
        System.out.println("localWeblogicToken=" + localWeblogicToken);
        
        if (localWeblogicToken.equalsIgnoreCase("Fc2MLU5EhcLByIqc2LjPSbr3KxubFE5t!660245490") && 1==2) {
                                                               this.setRetrievedToken("GBEWLEY");            
                                                           } else {
                                                               String psURL = null;
                                                               DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                                                               OperationBinding operationBinding = bindings.getOperationBinding("getLookupDesc");
                                                               if (null != operationBinding)
                                                                   psURL = (String) operationBinding.execute();

                                                               // ssl trust begin
                                                               //messagePopup("debug 0");

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

                                                                   //messagePopup("debug 1");
                                                                   
                                                                   url =
                                                                       new URL(null, psURL + "/EMPLOYEE/ERP/s/WEBLIB_ADFCALL.ISCRIPT1.FieldFormula.IScript_Feedback", new sun.net.www.protocol.https.Handler()); // UAT
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
                                                                   //messagePopup("debug 3" + localPeopleSoftToken);

                                                                   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                                                                   String inputLine;
                                                                   StringBuffer response = new StringBuffer();

                                                                   while ((inputLine = in.readLine()) != null) {

                                                                       response.append(inputLine);
                                                                       System.out.println(inputLine);
                                                                       //messagePopup(inputLine);

                                                                       if (inputLine.contains(localPeopleSoftToken.substring(1, 20))) {

                                                                           retrievedUser = inputLine.substring(0,
                                                                                inputLine.indexOf(localPeopleSoftToken.substring(1, 20))-1);

                                                                           System.out.println("retrievedUser="+retrievedUser);
                                                                           //messagePopup("retrievedUser=" + retrievedUser);


                                                                           this.setRetrievedToken(retrievedUser);
                                                                           //Setting user id to session scope variable for further use in application
                                                                           ADFUtils.setvalueToExpression("#{sessionScope.userId}", retrievedUser);

                                                                       }

                                                                   }

                                                                   in.close();
                                                                   //messagePopup("debug 4");
//                                                                   con.disconnect();
                                                                

                                                               } catch (MalformedURLException e) {
                                                                   e.printStackTrace();
                                                               } catch (IOException e) {
                                                                       e.printStackTrace();
                                                                   } catch (Exception e) {
                                                                   e.printStackTrace();
                                                               }
                                                               //messagePopup("debug 4");
                                                               System.out.println("retrieved :"+this.getRetrievedToken()+" ready to override");
                                                                                                                              
                                                           }
        

        // test override
        
//        if (this.getRetrievedToken()==null) {
//            this.setRetrievedToken("GBEWLEY");
//        }

        if (this.getAccessLimit().equalsIgnoreCase("GBEWLEY")) {
            this.setAccessLimit("D");
            } else {
                if(null!=this.getRetrievedToken())
                    this.checkRoles(this.getRetrievedToken());
                // this.checkRoles("GBEWLEY");
            }

    }

    private void messagePopup(String messageToUser) {

        FacesMessage fm = new FacesMessage(messageToUser);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        
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
            String userRole = (String) operationBinding.execute();
            if(null!=userRole)
                this.setUserRole(userRole);
        }
        
        //System.err.println("Access Limit: "+this.getAccessLimit());
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
//
//        boolean isAuthenticated = false;
//        String resolvedUser = "";
//
//        try {
//
//            // resolvedUser  = resolveEl("#{PeopleSoftCallSecurityFilter.retrievedToken}");
//            resolvedUser = this.getRetrievedToken();
//
//        } catch (Exception e) {
//
//        }
//
//        if (resolvedUser != null) {
//            if (resolvedUser.length() > 0) {
//                System.out.println("found user " + resolvedUser);
//                isAuthenticated = true;
//                setRetrievedToken(resolvedUser);
//                this.checkRoles(resolvedUser);
//            }
//        }
//
//        if (isAuthenticated == false) {
//            System.out.println("no user found");
//
//            FacesContext fctx = FacesContext.getCurrentInstance();
//            ExternalContext ectx = fctx.getExternalContext();
//
//            String viewId = "unauthorized.jsf";
//            ControllerContext controllerCtx = null;
//            controllerCtx = ControllerContext.getInstance();
//            String activityURL = controllerCtx.getGlobalViewActivityURL(viewId);
//            try {
//                ectx.redirect(activityURL);
//            } catch (IOException e) {
//                //Can't redirect
//                e.printStackTrace();
//            }
//
//        }


    }

}
