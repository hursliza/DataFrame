package DataFrame;

import java.util.LinkedList;

public interface Groupby {
    DataFrame max();
    DataFrame min();
    DataFrame std();
    DataFrame sum();
    DataFrame var();
}
