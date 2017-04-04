package util.calculator.values;

import interfaces.RpnValue;

/**
 * Created by Karol Pokomeda on 2017-03-31.
 */
public class DivideValues implements RpnValue {
    private double value;

    public void setValue(double... values){
        this.value = values[1]/values[0];
    }

    public boolean moreImportantThan(RpnValue value) {
        if (value instanceof SubtractValues || value instanceof AddValues) return false;
        return true;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    public String toString(){
        return "/";
    }
}
