package value;

import java.io.InvalidObjectException;
import java.util.Objects;

public class Time extends Value {
    Integer hours;
    Integer minutes;
    Integer seconds;

    public java.lang.String toString() {
        return (hours.toString() + ':' + minutes.toString() + ':' + seconds.toString());
    }

    public Time(java.lang.String s){    this.create(s); }
    private Time(){
        this.hours = new Integer("0");
        this.minutes = new Integer("0");
        this.seconds = new Integer("0");
    }

    Integer toNum(){
        return this.hours.mul(new Integer("3600")).add(this.minutes.mul(new Integer("60")).add(this.seconds));
    }

    Time toTime(Integer numTime){
        Time newInstance = new Time();
        newInstance.hours = numTime.div(new Integer("3600"));
        newInstance.minutes = numTime.sub(newInstance.hours.mul(new Integer("3600"))).div(new Integer("60"));
        newInstance.seconds = numTime.sub(newInstance.hours.mul(new Integer("3600")).add(newInstance.minutes.mul(new Integer("60"))));
        return newInstance;
    }

    public Time add(Value interval) {
        if (interval instanceof Time){
            Integer thisNum = this.toNum();
            Integer intervalNum = ((Time) interval).toNum();
            Integer newNum = thisNum.add(intervalNum);
            if (newNum.gte(new Integer("86400")))
                newNum = newNum.sub(new Integer("86400"));
            return toTime(newNum);
        }
        return null;
    }

    public Time sub(Value interval) {
        if (interval instanceof Time){
            Integer thisNum = this.toNum();
            Integer intervalNum = ((Time) interval).toNum();
            Integer newNum = thisNum.sub(intervalNum);
            if (newNum.lte(new Integer("-1")))
                newNum = newNum.add(new Integer("86400"));
            return toTime(newNum);
        }
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

    public boolean eq(Value other) {
        if (other instanceof Time){
            return (((Time) other).hours.eq(this.hours)) && (((Time) other).minutes.eq(this.minutes)) && (((Time) other).seconds.eq(this.seconds));
        }
        return false;
    }

    public boolean lte(Value other) {
        if (other instanceof Time){
            if (((Time) other).hours.gt(this.hours))
                return true;
            if (((Time) other).hours.eq(this.hours)){
                if (((Time) other).minutes.gt(this.minutes))
                    return true;
                if (((Time) other).minutes.eq(this.minutes))
                    return ((Time) other).seconds.gte(this.seconds);
            }
        }
        return false;
    }

    public boolean gte(Value other) {
        if (other instanceof Time){
            if (((Time) other).hours.lt(this.hours))
                return true;
            if (((Time) other).hours.eq(this.hours)){
                if (((Time) other).minutes.lt(this.minutes))
                    return true;
                if (((Time) other).minutes.eq(this.minutes))
                    return ((Time) other).seconds.lte(this.seconds);
            }
        }
        return false;
    }

    public boolean neq(Value other) {
        return (this != other);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        Time aTime = (Time) other;
        return aTime.returnValue() == this.returnValue();
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    public Value create(java.lang.String s) {

        java.lang.String[] date = s.split(":");
        if (date.length > 3) {
            try {
                throw new InvalidObjectException("Incorrect date.");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
                return null;
            }
        }
        if ((java.lang.Integer.parseInt(date[0]) < 24) && (java.lang.Integer.parseInt(date[0]) > -1))
            this.hours = new Integer(date[0]);
        if ((java.lang.Integer.parseInt(date[1]) < 60) && (java.lang.Integer.parseInt(date[1]) > -1))
            this.minutes = new Integer(date[1]);
        else
            try {
                throw new InvalidObjectException("Incorrect time.");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
                return null;
            }
        if ((java.lang.Integer.parseInt(date[2]) < 60) && (java.lang.Integer.parseInt(date[2]) > -1))
            this.seconds = new Integer(date[2]);
        else
            try {
                throw new InvalidObjectException("Incorrect time.");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
                return null;
            }
        return  this;
    }

    public Value returnValue() {
        return this;
    }
}
