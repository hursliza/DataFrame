package value;

import java.util.Objects;

public class Double extends Value{
    public double myValue;

    public Double(java.lang.String s){
        this.create(s);
    }

    Double() {
        this.create("-87654.321");
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(myValue);
    }

    @Override
    public java.lang.Float toNumber() {
        return (float) myValue;
    }

    public Double add(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) + java.lang.Double.parseDouble(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Double sub(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) - java.lang.Double.parseDouble(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value mul(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            double newValue = java.lang.Double.parseDouble(thisStr) * java.lang.Double.parseDouble(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value div(Value other) {
        Double newInstance = new Double();
        java.lang.String thisStr = this.toString();
        java.lang.String otherStr = other.toString();
        double newValue = java.lang.Double.parseDouble(thisStr) / java.lang.Double.parseDouble(otherStr);
        newInstance.create(java.lang.String.valueOf(newValue));
        return newInstance;
    }

    public Value pow(Value other) {
        Double newInstance = new Double();
        if (other instanceof Double){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            double newValue = Math.pow(java.lang.Double.parseDouble(thisStr), java.lang.Double.parseDouble(otherStr));
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Double)) return false;
        Double aDouble = (Double) o;
        return java.lang.Double.compare(aDouble.myValue, myValue) == 0;
    }

    public int hashCode() {
        return Objects.hash(myValue);
    }

    public boolean eq(Value other) {
        return (this.myValue == ((Double)other).myValue);
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

    public Double create(java.lang.String s) {
        this.myValue = java.lang.Double.parseDouble(s);
        return this;
    }

    public Double returnValue() {
        return this;
    }
}
