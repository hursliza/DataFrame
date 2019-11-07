package value;

public abstract class Value implements Cloneable{
    public abstract java.lang.String toString();
    public abstract Value add(Value other);
    public abstract Value sub(Value other);
    public abstract Value mul(Value other);
    public abstract Value div(Value other);
    public abstract Value pow(Value other);
    public abstract boolean eq(Value other);
    public abstract boolean lte(Value other);
    public abstract boolean gte(Value other);
    public abstract boolean neq(Value other);
    public abstract boolean equals(Object other);
    public abstract int hashCode();

    public Value create(java.lang.String s) {
        return null;
    }

    public abstract Value returnValue();
    public static Value build(java.lang.String s){
        if (s.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            Date build = new Date();
            build.create(s);
            return build;
        }
        if (s.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
            Time build = new Time();
            build.create(s);
            return build;
        }
        if (s.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
            DateTime build = new DateTime();
            build.create(s);
            return build;
        }
        if (s.matches("^-?\\d+$")){
            Integer build = new Integer();
            build.create(s);
            return build;
        }
        if (s.matches("^\\-?\\d+[\\.]?\\d+e?E?\\+?-?\\d+$")){
            Double build = new Double();
            build.create(s);
            return build;
        }
        String build = new String();
        build.create(s);
        return build;
    }
}
