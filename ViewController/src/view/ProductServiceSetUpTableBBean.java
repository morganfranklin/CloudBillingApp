package view;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;

public class ProductServiceSetUpTableBBean {
    private RichPopup productServiceUomAddItem_popup;
    private RichPopup productServiceUomEditItem_popup;
    private RichTable productServiceSetUpTblBind;
    private RichInputListOfValues categoryIdBind;

    public ProductServiceSetUpTableBBean() {
    }

    public void setProductServiceUomAddItem_popup(RichPopup productServiceUomAddItem_popup) {
        this.productServiceUomAddItem_popup = productServiceUomAddItem_popup;
    }

    public RichPopup getProductServiceUomAddItem_popup() {
        return productServiceUomAddItem_popup;
    }

    public void setProductServiceUomEditItem_popup(RichPopup productServiceUomEditItem_popup) {
        this.productServiceUomEditItem_popup = productServiceUomEditItem_popup;
    }

    public RichPopup getProductServiceUomEditItem_popup() {
        return productServiceUomEditItem_popup;
    }

    public void setProductServiceSetUpTblBind(RichTable productServiceSetUpTblBind) {
        this.productServiceSetUpTblBind = productServiceSetUpTblBind;
    }

    public RichTable getProductServiceSetUpTblBind() {
        return productServiceSetUpTblBind;
    }

    public void setCategoryIdBind(RichInputListOfValues categoryIdBind) {
        this.categoryIdBind = categoryIdBind;
    }

    public RichInputListOfValues getCategoryIdBind() {
        return categoryIdBind;
    }
}
