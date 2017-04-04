package util.calculator.values;

import interfaces.RpnValue;

/**
 * Created by Karol Pokomeda on 2017-03-31.
 */
public class NumberValue implements RpnValue {
    private double value;

    public NumberValue(double value){
        this.value = value;
    }

    public void setValue(double... values){}

    public double getValue() {
        return this.value;
    }

    public String toString(){
        return Double.toString(this.value);
    }
}
