package value;

import java.util.Objects;

public class DateTime extends Value {
    private Date date;
    private Time time;

    public java.lang.String toString() {
        return (date.year.toString() + '-' + date.month.toString() + '-' + date.day.toString() + ' '
                + time.hours.toString() + ':' + time.minutes.toString() + ':' + time.seconds.toString());
    }

    public DateTime add(Value other) {
        if (other instanceof DateTime){
            DateTime newInstance = new DateTime();
            Integer dateNum = this.date.toNum();
            Integer dateIntervalNum = ((DateTime) other).date.toNum();
            Integer newDate = dateNum.add(dateIntervalNum);
            newInstance.date = date.toDate(newDate);
            Integer thisNum = this.time.toNum();
            Integer intervalNum = ((DateTime) other).time.toNum();
            Integer newNum = thisNum.add(intervalNum);
            if (newNum.gte(new Integer("86400"))){
                newInstance.date.day = newInstance.date.day.add(new Integer("1"));
                newNum = newNum.sub(new Integer("86400"));
            }
            newInstance.time = time.toTime(newNum);
            return newInstance;
        }
        return null;
    }

    public Value sub(Value other) {
        if (other instanceof DateTime){
            DateTime newInstance = new DateTime();
            Integer dateNum = this.date.toNum();
            Integer dateIntervalNum = ((DateTime) other).date.toNum();
            Integer newDate = dateNum.sub(dateIntervalNum);
            newInstance.date = date.toDate(newDate);
            Integer thisNum = this.time.toNum();
            Integer intervalNum = ((DateTime) other).time.toNum();
            Integer newNum = thisNum.add(intervalNum);
            if (newNum.lte(new Integer("-1"))){
                newInstance.date.day = newInstance.date.day.sub(new Integer("1"));
                newNum = newNum.add(new Integer("86400"));
            }
            newInstance.time = time.toTime(newNum);
            return newInstance;
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
        if (other instanceof DateTime){
            return ((((DateTime) other).date.eq(this.date))&&(((DateTime) other).time.eq(this.time)));
        }
        return false;
    }

    public boolean lte(Value other) {
        if (other instanceof DateTime){
            if (((DateTime) other).date.year.gt(this.date.year))
                return true;
            if (((DateTime) other).date.year.eq(this.date.year))
            {
                if (((DateTime) other).date.month.gt(this.date.month))
                    return true;
                if (((DateTime) other).date.month.eq(this.date.month)){
                    if (((DateTime) other).date.day.gt(this.date.day))
                        return true;
                    if (((DateTime) other).date.day.eq(this.date.day)){
                        if (((DateTime) other).time.hours.gt(this.time.hours))
                            return true;
                        if (((DateTime) other).time.hours.eq(this.time.hours)){
                            if (((DateTime) other).time.minutes.gt(this.time.minutes))
                                return true;
                            if (((DateTime) other).time.minutes.eq(this.time.minutes))
                                return ((DateTime) other).time.seconds.gte(this.time.seconds);
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean gte(Value other) {
        if (other instanceof DateTime){
            if (((DateTime) other).date.year.lt(this.date.year))
                return true;
            if (((DateTime) other).date.year.eq(this.date.year))
            {
                if (((DateTime) other).date.month.lt(this.date.month))
                    return true;
                if (((DateTime) other).date.month.eq(this.date.month)){
                    if (((DateTime) other).date.day.lt(this.date.day))
                        return true;
                    if (((DateTime) other).date.day.eq(this.date.day)){
                        if (((DateTime) other).time.hours.lt(this.time.hours))
                            return true;
                        if (((DateTime) other).time.hours.eq(this.time.hours)){
                            if (((DateTime) other).time.minutes.lt(this.time.minutes))
                                return true;
                            if (((DateTime) other).time.minutes.eq(this.time.minutes))
                                return ((DateTime) other).time.seconds.lte(this.time.seconds);
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean neq(Value other) {
        return (this != other);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass()!=this.getClass()) return false;
        DateTime aDateTime = (DateTime) other;
        return (this.returnValue() == ((DateTime) other).returnValue());
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    public DateTime create(java.lang.String s) {
        java.lang.String[] date_time = s.split(" ");
        this.date.create(date_time[0]);
        this.time.create(date_time[1]);
        return this;
    }

    public Value returnValue() {
        return this;
    }
}
