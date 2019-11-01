package value;

import java.util.Objects;

public class String extends Value {
    private java.lang.String myValue;

    public String(java.lang.String s) {
        create(s);
    }

    public String() {
        create("");
    }

    public java.lang.String toString() {
        return myValue;
    }

    public String add(Value other) {
        if (other instanceof String){
            return new String(this.myValue + other.toString());
        }
        return new String("");
    }

    public String sub(Value other) {
        if (other instanceof String){
            if (this.myValue.contains(((String) other).myValue)){
                int first = this.myValue.indexOf(((String) other).myValue);
                int last = first + other.toString().length();
                java.lang.String firstPart = this.myValue.substring(0, first);
                java.lang.String secondPart = this.myValue.substring(last);
                java.lang.String result = firstPart + secondPart;
                return new String(result);
            }
        }
        return null;
    }

    public String mul(Value other) {
        return null;
    }

    public String div(Value other) {
        return null;
    }

    public String pow(Value other) {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof String)) return false;
        String string = (String) o;
        return Objects.equals(myValue, string.myValue);
    }

    public int hashCode() {
        return Objects.hash(myValue);
    }

    public boolean eq(Value other) {
        return (this.myValue == ((String)other).myValue);
    }

    public boolean lte(Value other) {
        return (this.myValue.compareToIgnoreCase(other.toString()) < 0);
    }

    public boolean gte(Value other) {
        return (this.myValue.compareToIgnoreCase(other.toString()) > 0);
    }

    public boolean neq(Value other) {
        return (this != other);
    }

    public Value create(java.lang.String s) {
        this.myValue = s;
        return this;
    }

    public String returnValue() {
        return this;
    }
}
