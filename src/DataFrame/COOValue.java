package DataFrame;

import value.*;
import java.lang.String;
import java.util.Objects;

class COOValue extends Value{
    private int key;
    private Value value;

    public String toString() {
        return ("|\t(" + this.key + ", " + this.value + ")\t|");
    }

    public boolean eq(Value other) {
        return (this.key == ((COOValue)other).key && this.value.equals(((COOValue) other).value));
    }

    public boolean neq(Value other) {
        return (this != other);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        COOValue cooValue = (COOValue) other;
        return key == cooValue.key &&
                Objects.equals(value, cooValue.value);
    }

    COOValue(int key, Value value){
        this.key = key;
        this.value = value;
    }

    int getKey(){
        return this.key;
    }

    Value getValue() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    public COOValue returnValue() {
        return this;
    }

    public Value add(Value other) {
        return null;
    }
    public Value sub(Value other) {
        return null;
    }
    public Value mul(Value other) {
        return null;
    }
    public Value div(Value other) {
        return null;
    }
    public Value pow(Value other) {
        return null;
    }
    public boolean lte(Value other) {
        return false;
    }
    public boolean gte(Value other) {
        return false;
    }
    public Value create(String s) {
        return null;
    }
}
