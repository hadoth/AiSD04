package util.calculator;

import interfaces.RpnValue;
import util.queue.FifoQueue;

/**
 * Created by Karol Pokomeda on 2017-03-30.
 * Class creates console view for calculator operations and sustains communication with the user; it allows to
 * calculate the result of infix equations with use of RNP parser and RNP calculator
 */
public class Calculator {
    private static final String BREAK = "break";
    private static final String DECORATION = "-------------***|||***-------------";

    private ReadLine inputSource;
    private boolean isActive;

    /**
     * @param {ReadLine} inputSource object which reads user inputs from console
     */
    public Calculator(ReadLine inputSource){
        this.inputSource = inputSource;
        this.isActive = false;
    }

    /**
     * Method displays welcome message with instructions and starts the calculator loop which read user in put,
     * calculates and displays the result
     */
    public void run(){
        this.isActive = true;
        System.out.println(Calculator.DECORATION);
        System.out.println("--------- RPN  CALCULATOR ---------");
        System.out.println(Calculator.DECORATION);
        System.out.println("\tThis program accepts equation");
        System.out.println("in the infix form, parses it to the");
        System.out.println("postfix form of reverse polish");
        System.out.println("notation and calculates the result");
        System.out.println(Calculator.DECORATION);
        System.out.println("allowed operands:");
        System.out.println("\t+\t\taddition");
        System.out.println("\t-\t\tsubtraction");
        System.out.println("\t*\t\tmultiplication");
        System.out.println("\t/\t\tdivision");
        System.out.println("\t^\t\tpower");
        System.out.println("\t( & )\torder of operations");
        System.out.println("\t" + Calculator.BREAK + "\tfinish program");
        System.out.println("\nUnary minus is not supported;\nplease use 0-X instead");
        System.out.println(Calculator.DECORATION);
        System.out.println("\n\tInput example: 1+2*(8^4/3)\n");
        System.out.println(Calculator.DECORATION);
        while (this.isActive){
            String userInput = this.inputSource.read();

            if (userInput.trim().equals(Calculator.BREAK)){
                this.stop();
                break;
            }
            try {
                FifoQueue<RpnValue> rpnEquation = ReversePolishNotation.parser(userInput);

                Double result = ReversePolishNotation.calculator(rpnEquation);
                System.out.print(userInput + " = ");
                System.out.printf("%.5f%n", result);
            } catch (IllegalArgumentException e){
                System.out.print("\n" + e.getMessage() + "\n");
            }
        }
    }

    /**
     * Method stops functioning of the calculator and displays goodbye message
     */
    private void stop(){
        this.isActive = false;
        System.out.println(Calculator.DECORATION);
        System.out.println("Thank you for using this calculator");
        System.out.println(Calculator.DECORATION);
    }
}
