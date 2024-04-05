package SantanderSAS.Controller;

import SantanderSAS.Model.SDGDCModel;
import SantanderSAS.View.SDGDCView;

public class SDGDCController {
    private SDGDCModel model;
    private SDGDCView view;
    public SDGDCController(SDGDCModel model, SDGDCView view){
        this.model = model;
        this.view = view;
    }
    public void start(){
        this.view.init(this.model.getTitle());
    }

}
