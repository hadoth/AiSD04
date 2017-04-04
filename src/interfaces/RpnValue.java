package interfaces;

/**
 * Created by Karol Pokomeda on 2017-03-31.
 * Interface is a template for creation of objects which hold partial values for postfix equation in the reverse polish
 * notation algorithm
 */
public interface RpnValue {
    /**
     * Method result value of partial expression
     * @return {double} one of equation factors or result of mathematical operation
     */
    double getValue();

    /**
     * Method accepts specific number of input values and stores them internally as output value
     * @param {double[]} values
     */
    void setValue(double... values);
}
