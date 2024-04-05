package SantanderSAS;

import SantanderSAS.Controller.SDGDCController;
import SantanderSAS.Model.SDGDCModel;
import SantanderSAS.View.SDGDCView;

public class SDGDC {
    public static void main (String[] args){
        SDGDCController controller = new SDGDCController(new SDGDCModel(), new SDGDCView());
        controller.start();
    }

}