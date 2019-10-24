package value;

import java.util.Objects;

public class Float extends Value {
    private float myValue;

    public Float(java.lang.String s){
        this.create(s);
    }

    Float(){
        this.create("-87654.32");
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(myValue);
    }

    public Float add(Value other) {
        Float newInstance = new Float();
        if (other instanceof Float){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            float newValue = java.lang.Float.parseFloat(thisStr) + java.lang.Float.parseFloat(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Float sub(Value other) {
        Float newInstance = new Float();
        if (other instanceof Float){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            float newValue = java.lang.Float.parseFloat(thisStr) - java.lang.Float.parseFloat(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value mul(Value other) {
        Float newInstance = new Float();
        if (other instanceof Float){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            float newValue = java.lang.Float.parseFloat(thisStr) * java.lang.Float.parseFloat(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value div(Value other) {
        Float newInstance = new Float();
        if (other instanceof Float){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            float newValue = java.lang.Float.parseFloat(thisStr) / java.lang.Float.parseFloat(otherStr);
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public Value pow(Value other) {
        Float newInstance = new Float();
        if (other instanceof Float){
            java.lang.String thisStr = this.toString();
            java.lang.String otherStr = other.toString();
            float newValue = (float) Math.pow(java.lang.Float.parseFloat(thisStr), java.lang.Float.parseFloat(otherStr));
            newInstance.create(java.lang.String.valueOf(newValue));
        }
        else
            newInstance.create("-87654.321");
        return newInstance;
    }

    public boolean eq(Value other) {
        return (this == other);
    }

    public boolean lte(Value other) {
        return (this.myValue <= ((Float)other).myValue);
    }

    public boolean gte(Value other) {
        return (this.myValue >= ((Float)other).myValue);
    }

    public boolean neq(Value other) {
        return (this != other);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Float aFloat = (Float) other;
        return this.returnValue() == aFloat.returnValue();
    }

    public int hashCode() {
        return Objects.hash(this.returnValue());
    }

    public Float create(java.lang.String s) {
        this.myValue = java.lang.Float.parseFloat(s);
        return this;
    }

    public Float returnValue() {
        return this;
    }
}
