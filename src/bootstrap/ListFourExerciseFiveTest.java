package bootstrap;

import util.calculator.Calculator;
import util.calculator.ReadLine;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 */
public class ListFourExerciseFiveTest {
    public static void main(String[] args){
        ReadLine systemInput = new ReadLine(System.in);
        Calculator myCalculator = new Calculator(systemInput);
        myCalculator.run();
    }
}
