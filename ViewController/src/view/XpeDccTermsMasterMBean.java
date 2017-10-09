package view;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.jbo.domain.ClobDomain;

import view.utils.ADFUtils;

public class XpeDccTermsMasterMBean implements Serializable {
    @SuppressWarnings("compatibility:-4377821294138899990")
    private static final long serialVersionUID = -6275836286057023993L;

    public XpeDccTermsMasterMBean() {
        super();
    }
    
    private XpeDccTermsMasterBBean getXpeDccTermsMasterBBean() {
        XpeDccTermsMasterBBean xpeDccTermsMasterBBean =
            (XpeDccTermsMasterBBean) ADFUtils.evaluateEL("#{backingBeanScope.XpeDccTermsMasterBBean}");
        return xpeDccTermsMasterBBean;
    }

    public void onTermsMasterCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeDccTermsMasterBBean().getTermsMaster_popup().show(hints);
    }
    
    public void onTermsMasterSaveOrCancel(ActionEvent actionEvent) {
        this.getXpeDccTermsMasterBBean().getTermsMaster_popup().hide();
    }

    public void onRFFSelValueChange(ValueChangeEvent valueChangeEvent) {
        try {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            ClobDomain html = (ClobDomain) ADFUtils.evaluateEL("#{bindings.XpeDccTermTemplate.inputValue}");
            String dicSelection =
                ADFUtils.getValueFrmExpression("#{bindings.Dic_Desc.selectedValue.attributeValues[1]}");
            System.err.println(dicSelection);
            StringBuilder template = new StringBuilder(100);
            if (null != html && (int) html.getLength() > 0) {
                template.append(html.getSubString(1, (int) html.getLength()));
                template.append("{").append(dicSelection).append("}");
            }else
                template.append("{").append(dicSelection).append("}");
            ADFUtils.setvalueToExpression("#{bindings.XpeDccTermTemplate.inputValue}",
                                          new ClobDomain(template.toString()));
                
            System.err.println("HTML: " + template.toString());
        } catch (Exception ex) {
            // TODO: Add catch code
            ex.printStackTrace();
        }
    }
}
