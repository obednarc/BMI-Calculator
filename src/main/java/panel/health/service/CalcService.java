package panel.health.service;

import org.springframework.stereotype.Service;
import panel.health.model.Calc;

@Service
public class CalcService {

    public double bmiDivide(Calc.OperationModel model){
        if(model.getHeight() == 0 || model.getWeight() == 0){
            return 0;
        }
        return model.getWeight() / (model.getHeight() * model.getHeight());
    }

    public Calc.OperationModel clearSimple(Calc.OperationModel model){
        model.setWeight(0);
        model.setHeight(0);
        return model;
    }

}
