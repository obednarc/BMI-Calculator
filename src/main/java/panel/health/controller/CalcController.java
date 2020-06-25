package panel.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import panel.health.model.Calc;
import panel.health.service.CalcService;

@Controller
public class CalcController {

    Calc.OperationModel operationModel = new Calc.OperationModel();

    @Autowired
    private CalcService calcService;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationModel",operationModel);
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="bmi_divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("operationModel") Calc.OperationModel operationModel, Model model ){
        model.addAttribute("bmi_result", calcService.bmi_divide(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="clearSimple", method = RequestMethod.POST)
    public String clearSimple(@ModelAttribute("operationModel") Calc.OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calcService.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }
}
