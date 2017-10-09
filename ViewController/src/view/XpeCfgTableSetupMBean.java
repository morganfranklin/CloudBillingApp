package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class XpeCfgTableSetupMBean implements Serializable {
    @SuppressWarnings("compatibility:4267063345257999077")
    private static final long serialVersionUID = -6995675695570335476L;

    public XpeCfgTableSetupMBean() {
        super();
    }
    
    private XpeCfgTableSetupBBean getXpeCfgTableSetupBBean() {
        XpeCfgTableSetupBBean xpeCfgTableSetupBBean =
            (XpeCfgTableSetupBBean) ADFUtils.evaluateEL("#{backingBeanScope.XpeCfgTableSetupBBean}");
        return xpeCfgTableSetupBBean;
    }
    
    //Terminal Set Up
    public void onTerminalCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalAddItem_popup().show(hints);
    }
    
    public void onTerminalCreationSaveOrCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalAddItem_popup().hide();
    }
    
    public void onTerminalEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalEditItem_popup().show(hints);
    }
    
    public void onTerminalEditSaveOrCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalEditItem_popup().hide();
    }
    
    //Terminal Search Set Up
    public void onTerminalSearch(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getXpeCfgTableSetupBBean().getTerminalSearch_popup().show(hints);
    }
    
    public void onTerminalSearchSaveOrCancel(ActionEvent actionEvent) {
        this.getXpeCfgTableSetupBBean().getTerminalSearch_popup().hide();
    }

}
