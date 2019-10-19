package value;

import java.util.Objects;

public class Double extends Value{
    private double myValue;

    public Double(String s){
        this.create(s);
    }

    public Double() {
        this.create("-87654.321");
    }

    public String toString() {
        return String.valueOf(myValue);
    }

    public Double add(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            String thisStr = this.toString();
            String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) + java.lang.Double.parseDouble(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Double sub(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            String thisStr = this.toString();
            String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) - java.lang.Double.parseDouble(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value mul(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            String thisStr = this.toString();
            String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) * java.lang.Double.parseDouble(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value div(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            String thisStr = this.toString();
            String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) / java.lang.Double.parseDouble(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value pow(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            String thisStr = this.toString();
            String otherStr = other.toString();
            double newValue = Math.pow(java.lang.Double.parseDouble(thisStr), java.lang.Double.parseDouble(otherStr));
            newInstance.create(String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public boolean eq(Value other) {
        return (this == other);
    }

    public boolean lte(Value other) {
        return (this.myValue <= ((Double)other).myValue);
    }

    public boolean gte(Value other) {
        return (this.myValue >= ((Double)other).myValue);
    }

    public boolean neq(Value other) {
        return (this != other);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Double aDouble = (Double) other;
        return this.returnValue() == aDouble.returnValue();
    }

    public int hashCode() {
        return Objects.hash(this.returnValue());
    }

    public Double create(String s) {
        this.myValue = java.lang.Double.parseDouble(s);
        return this;
    }

    public Value returnValue() {
        return this;
    }
}
