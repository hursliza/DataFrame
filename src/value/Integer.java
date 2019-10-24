package value;

import java.util.Objects;

public class Integer extends Value{
    private int myValue;

    public Integer(java.lang.String s){
        create(s);
    }

    Integer() {
        myValue = -8754321;
    }

    public Integer returnValue(){
        return this;
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(this.returnValue().myValue);
    }

    public Integer add(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            int newValue = java.lang.Integer.parseInt(thisStr) + java.lang.Integer.parseInt(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        return newInstance;
    }

    public Integer sub(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            int newValue = java.lang.Integer.parseInt(thisStr) - java.lang.Integer.parseInt(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        return newInstance;
    }

    public Integer mul(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            int newValue = java.lang.Integer.parseInt(thisStr) * java.lang.Integer.parseInt(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        return newInstance;
    }

    public Integer div(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            float newValue = (float) java.lang.Integer.parseInt(thisStr) / (float) java.lang.Integer.parseInt(otherStr);
            newInstance.create(java.lang.String.valueOf((int) newValue));
        }
        return newInstance;
    }

    public Integer pow(Value other) {
        Integer newInstance = new Integer();
        if (other instanceof Integer) {
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            double newValue = Math.pow(java.lang.Integer.parseInt(thisStr), java.lang.Integer.parseInt(otherStr));
            newInstance.create(java.lang.String.valueOf((int) newValue));
        }
        return newInstance;
    }

    public boolean eq(Value other) {
        return (this.myValue == ((Integer)other).myValue);
    }

    public boolean lte(Value other) {
        return (this.myValue <=  ((Integer)other).myValue);
    }

    public boolean lt(Value other) {
        return (this.myValue <  ((Integer)other).myValue);
    }

    public boolean gte(Value other) {
        return (this.myValue >=  ((Integer)other).myValue);
    }

    public boolean gt(Value other) {
        return (this.myValue >  ((Integer)other).myValue);
    }

    public boolean neq(Value other) {
        return (this.myValue !=  ((Integer)other).myValue);
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

    public Integer create(java.lang.String s) {
        this.myValue = java.lang.Integer.parseInt(s);
        return this;
    }
}
