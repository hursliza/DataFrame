package value;

import java.util.Objects;

public class Integer extends Value{
    private int myValue;

    public Integer(String s){
        create(s);
    }

    private Integer() {
        myValue = -8754321;
    }

    public Integer returnValue(){
        return this;
    }

    public String toString() {
        return String.valueOf(this.returnValue().myValue);
    }

    public Integer add(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            String thisStr = this.toString();
            String otherStr = other.toString();
            int newValue = java.lang.Integer.parseInt(thisStr) + java.lang.Integer.parseInt(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        return newInstance;
    }

    public Integer sub(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            String thisStr = this.toString();
            String otherStr = other.toString();
            int newValue = java.lang.Integer.parseInt(thisStr) - java.lang.Integer.parseInt(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        return newInstance;
    }

    public Integer mul(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            String thisStr = this.toString();
            String otherStr = other.toString();
            int newValue = java.lang.Integer.parseInt(thisStr) * java.lang.Integer.parseInt(otherStr);
            newInstance.create(String.valueOf(newValue));
        }
        return newInstance;
    }

    public Integer div(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            String thisStr = this.toString();
            String otherStr = other.toString();
            float newValue = (float) java.lang.Integer.parseInt(thisStr) / (float) java.lang.Integer.parseInt(otherStr);
            newInstance.create(String.valueOf((int) newValue));
        }
        return newInstance;
    }

    public Integer pow(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer) {
            String thisStr = this.toString();
            String otherStr = other.toString();
            double newValue = Math.pow((double) java.lang.Integer.parseInt(thisStr), (double) java.lang.Integer.parseInt(otherStr));
            newInstance.create(String.valueOf((int) newValue));
        }
        return newInstance;
    }

    public boolean eq(Value other) {
        return (this == other);
    }

    public boolean lte(Value other) {
        return (this.myValue <=  ((Integer)other).myValue);
    }

    public boolean gte(Value other) {
        return (this.myValue >=  ((Integer)other).myValue);
    }

    public boolean neq(Value other) {
        return (this !=  other);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Integer integer = (Integer) other;
        return this.returnValue() == integer.returnValue();
    }

    public int hashCode() {
        return Objects.hash(this.returnValue());
    }

    public Integer create(String s) {
        this.myValue = java.lang.Integer.parseInt(s);
        return this;
    }
}
