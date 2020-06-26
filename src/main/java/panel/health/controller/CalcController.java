package panel.health.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import panel.health.model.Calc;
import panel.health.service.CalcService;

import static panel.health.controller.LoginController.loggedUser;

@Controller
@RequiredArgsConstructor
public class CalcController {

    Calc.OperationModel operationModel = new Calc.OperationModel();

    private final CalcService calcService;

    @GetMapping("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationModel", operationModel);
        model.addAttribute("user", loggedUser);
        return "calculator";
    }

    @PostMapping(value="/calculator", params="bmiDivide")
    public String divide(@ModelAttribute("operationModel") Calc.OperationModel operationModel, Model model ){
        model.addAttribute("bmi_result", calcService.bmiDivide(operationModel));
        model.addAttribute("user", loggedUser);
        return "calculator";
    }

    @PostMapping(value="/calculator", params="clearSimple")
    public String clearSimple(@ModelAttribute("operationModel") Calc.OperationModel operationModel, Model model ){
        model.addAttribute("user", loggedUser);
        model.addAttribute("operationModel", calcService.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }
}
