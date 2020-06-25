package panel.health.service;

import org.springframework.stereotype.Service;
import panel.health.model.Calc;


@Service
public class CalcService {


    public double bmi_divide (Calc.OperationModel model){
        if(model.getWeight() == 0) return 0;
        if(model.getHeight() == 0) return 0;
        return (double) model.getWeight() / (model.getHeight()*model.getHeight());
    }


    public Calc.OperationModel clearSimple(Calc.OperationModel model){
        model.setWeight(0);
        model.setHeight(0);
        return model;
    }

}
