package util.calculator;

import interfaces.RpnValue;
import util.calculator.values.*;
import util.queue.FifoQueue;
import util.queue.LifoQueue;

import java.util.StringTokenizer;

/**
 * Created by Karol Pokomeda on 2017-03-30.
 * Class consists of two static methods: calculator and parser; these methods are used to parse infix equation to the
 * postfix form and calculate the result
 */
public class ReversePolishNotation {

    /**
     * Method accepts queue of RpnValue Objects and calculate the result of the equation which is represented by
     * those objects
     * @param {FifoQueue<RnpValue>} rpnExpression
     * @return {double} result of equation
     */
    public static double calculator(FifoQueue<RpnValue> rpnExpression){
        LifoQueue<RpnValue> rpnStack = new LifoQueue<>();
        while (!rpnExpression.isEmpty()){
            RpnValue current = rpnExpression.pop();
            if (current instanceof NumberValue) rpnStack.push(current);
            else{
                current.setValue(rpnStack.pop().getValue(), rpnStack.pop().getValue());
                rpnStack.push(current);
            }
        }
        double result = rpnStack.pop().getValue();
        if (rpnStack.isEmpty()) return result;
        else throw new IllegalArgumentException("Provided expression is invalid and cannot be resolved to a value");
    }

    /**
     * Method parses infix equation to the queue of RnpValue objects representing said equation in the
     * postfix notation
     * @param {String} equation in the infix form represented with use of basic mathematical operators and parenthesis
     * @return {FifoQueue<RpnValue>} input represented as stack of RpnValue objects
     */
    public static FifoQueue<RpnValue> parser(String equation){
        return parse(tokenize(equation));
    }

    private static boolean isValue(String token){
        try{
                Double.parseDouble(token);
                return true;
            } catch (NumberFormatException e){
                return false;
            }
    }

    private static FifoQueue<String> tokenize(String equation){
        equation = equation.trim();
        equation = equation.replace(" ", "");
        StringTokenizer st = new StringTokenizer(equation, "+-/*^()", true);

        FifoQueue<String> result = new FifoQueue<>();
        while (st.hasMoreTokens()){
            result.push(st.nextToken());
        }
        return result;
    }

    private static FifoQueue<RpnValue> parse(FifoQueue<String> tokens){
        FifoQueue<RpnValue> result = new FifoQueue<>();
        LifoQueue<String> tempStack = new LifoQueue<>();

        while(!tokens.isEmpty()){
            String currentToken = tokens.pop();
            if (isValue(currentToken)) result.push(new NumberValue(Double.valueOf(currentToken)));
            else {
                if (tempStack.isEmpty() ||currentToken.equals("(")) tempStack.push(currentToken);
                else{
                    if (currentToken.equals(")")){
                        String stackTop = tempStack.pop();
                        while(!stackTop.equals("(")){
                            result.push(valueizer(stackTop));
                            stackTop = tempStack.pop();
                        }
                    } else {
                        boolean isAssigned = false;
                        while (!isAssigned){
                            String stackTop = tempStack.pop();
                            if (getPriority(stackTop) >= getPriority(currentToken)){
                                result.push(valueizer(stackTop));
                                if (tempStack.isEmpty()){
                                    tempStack.push(currentToken);
                                    isAssigned = true;
                                }
                            } else {
                                tempStack.push(stackTop);
                                tempStack.push(currentToken);
                                isAssigned = true;
                            }
                        }
                    }
                }
            }
        }
        while(!tempStack.isEmpty()){
            String stackTop = tempStack.pop();
            if (!stackTop.equals("(") && !stackTop.equals(")")) {
                result.push(valueizer(stackTop));
            }
        }
        return  result;
    }

    private static RpnValue valueizer(String token){
        switch (token){
            case "+": return new AddValues();
            case "-": return new SubtractValues();
            case "/": return new DivideValues();
            case "*": return new MultiplyValues();
            case "^": return new PowerValues();
            default: throw new  IllegalArgumentException(token + ": argument not recognized by rpn method");
        }
    }

    private static int getPriority(String arg){
        switch (arg){
            case "(":
                return 0;
            case "+":
            case "-":
            case ")":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                throw new IllegalArgumentException(arg + ": argument not recognized by rpn method");
        }
    }
}
