package view;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;

import view.utils.ADFUtils;

public class ProductServiceSetUpTableMBean {
    public ProductServiceSetUpTableMBean() {
    }
    
    private ProductServiceSetUpTableBBean getProductServiceSetUpTableBBean() {
        ProductServiceSetUpTableBBean productServiceSetUpTableBBean =
            (ProductServiceSetUpTableBBean) ADFUtils.evaluateEL("#{backingBeanScope.ProductServiceSetUpTableBBean}");
        return productServiceSetUpTableBBean;
    }

    public void onProductUomCreation(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getProductServiceSetUpTableBBean().getProductServiceUomAddItem_popup().show(hints);
    }

    public void productServiceUomSaveorCancel(ActionEvent actionEvent) {
        this.getProductServiceSetUpTableBBean().getProductServiceUomAddItem_popup().hide();
    }

    public void onProductUomEdit(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getProductServiceSetUpTableBBean().getProductServiceUomEditItem_popup().show(hints);
    }

    public void productServiceUomEditSaveOrCancel(ActionEvent actionEvent) {
        this.getProductServiceSetUpTableBBean().getProductServiceUomEditItem_popup().hide();
    }
}
