package value;

import java.io.InvalidObjectException;
import java.util.Objects;

public class Date extends Value {
    Integer year;
    Integer month;
    Integer day;

    public java.lang.String toString() {
        return (year.toString() + '-' + month.toString() + '-' + day.toString());
    }

    public Date(java.lang.String s){    this.create(s); }
    Date(){
        this.year = new Integer("0");
        this.month = new Integer("0");
        this.day = new Integer("0");
    }

    Integer toNum(){
        return this.year.mul(new Integer("360")).add(this.month.mul(new Integer("30")).add(this.day));
    }

    Date toDate(Integer numDate){
        Date newInstance = new Date();
        newInstance.year = numDate.div(new Integer("360"));
        if (numDate.sub(newInstance.year.mul(new Integer("360"))).gte(new Integer("31"))){
            newInstance.month = numDate.sub(newInstance.year.mul(new Integer("360"))).div(new Integer("30"));
            newInstance.day = numDate.sub(newInstance.year.mul(new Integer("360"))).sub(newInstance.month.mul(new Integer("30")));
            return newInstance;
        }
        else {
            newInstance.day = numDate.sub(newInstance.year.mul(new Integer("360")));
            newInstance.year = newInstance.year.sub(new Integer("1"));
            newInstance.month = new Integer("12");
            return newInstance;
        }
    }

    public Date add(Value interval) {
        if (interval instanceof Date){
            Integer thisNum = this.toNum();
            Integer intervalNum = ((Date) interval).toNum();
            Integer newNum = thisNum.add(intervalNum);
            return toDate(newNum);
        }
        return null;
    }

    public Date sub(Value interval) {
        if (interval instanceof Date){
            Integer thisNum = this.toNum();
            Integer intervalNum = ((Date) interval).toNum();
            Integer newNum = thisNum.sub(intervalNum);
            return toDate(newNum);
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
        if (other instanceof Date){
            return (((Date) other).year.eq(this.year)) && (((Date) other).month.eq(this.month)) && (((Date) other).day.eq(this.day));
        }
        return false;
    }

    public boolean lte(Value other) {
        if (other instanceof Date){
            if (((Date) other).year.gt(this.year))
                return true;
            if (((Date) other).year.eq(this.year))
            {
                if (((Date) other).month.gt(this.month))
                    return true;
                if (((Date) other).month.eq(this.month)){
                    return ((Date) other).day.gte(this.day);
                }
            }
        }
        return false;
    }

    public boolean gte(Value other) {
        if (other instanceof Date){
            if (((Date) other).year.lt(this.year))
                return true;
            if (((Date) other).year.eq(this.year))
            {
                if (((Date) other).month.lt(this.month))
                    return true;
                if (((Date) other).month.eq(this.month)){
                    return ((Date) other).day.lte(this.day);
                }
            }
        }
        return false;
    }

    public boolean neq(Value other) {
        return this != other;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return Objects.equals(year, date.year) &&
                Objects.equals(month, date.month) &&
                Objects.equals(day, date.day);
    }

    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public Date create(java.lang.String s) {
        java.lang.String[] date = s.split("-");
        if (date.length > 3) {
            try {
                throw new InvalidObjectException("Incorrect date.");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
                return null;
            }
        }
        this.year = new Integer(date[0]);
        this.month = new Integer(date[1]);
        this.day = new Integer(date[2]);
/*
        this.year = new Integer(date[0]);
        if ((java.lang.Integer.parseInt(date[1]) < 13) && (java.lang.Integer.parseInt(date[1]) > 0))
            this.month = new Integer(date[1]);
        else
            try {
                throw new InvalidObjectException("Incorrect date.");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
                return null;
            }
        if ((java.lang.Integer.parseInt(date[2]) < 31) && (java.lang.Integer.parseInt(date[2]) > 0))
            this.day = new Integer(date[2]);
        else
            try {
                throw new InvalidObjectException("Incorrect date.");
            } catch (InvalidObjectException e) {
                e.printStackTrace();
                return null;
            }

 */
        return  this;
    }

    public Date returnValue() {
        return this;
    }
}
