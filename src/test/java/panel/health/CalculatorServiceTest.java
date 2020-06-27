package panel.health;

import org.junit.Before;

import org.junit.Test;
import panel.health.model.Calc;
import panel.health.service.CalcService;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {

    private CalcService calcService;

    @Before
    public void setup(){
        calcService = new CalcService();
    }

    @Test
    public void bmiDivideTest(){
        // given
        Calc.OperationModel operationModel = new Calc.OperationModel(90, 1.86);

        // when
        double bmi = calcService.bmiDivide(operationModel);

        // then
        assertThat(roundTwoDecimalPlaces(bmi)).isEqualTo(26.01);
    }

    @Test
    public void bmiDivideTest_empty_height(){
        // given
        Calc.OperationModel operationModel = new Calc.OperationModel(80, 0);

        // when
        double bmi = calcService.bmiDivide(operationModel);

        // then
        assertThat(bmi).isEqualTo(0);
    }

    @Test
    public void bmiDivideTest_empty_weight(){
        // given
        Calc.OperationModel operationModel = new Calc.OperationModel(0, 1.86);

        // when
        double bmi = calcService.bmiDivide(operationModel);

        // then
        assertThat(bmi).isEqualTo(0);
    }

    @Test
    public void clearSimpleTest(){
        // given
        Calc.OperationModel operationModel = new Calc.OperationModel(1.86, 90);

        // when
        calcService.clearSimple(operationModel);

        // then
        assertThat(operationModel.getHeight()).isEqualTo(0);
        assertThat(operationModel.getWeight()).isEqualTo(0);
    }

    private double roundTwoDecimalPlaces(double input){
        return Math.round(input * 100.0) / 100.0;
    }
}
