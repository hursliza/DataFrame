package DataFrame;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class SparseDataFrameColumn extends DataFrameColumn {
    private int initialSize = 0;
    SparseDataFrameColumn(String _name, String _type) {
        super(_name, _type);
    }

    SparseDataFrameColumn(DataFrameColumn init, Object hide) {
        super(init.columnName(), init.columnType());
        this.initialSize = init.columnSize();
        for (int i = 0; i < init.columnSize(); i++){
            Object element = init.getValue(i);
            if (!element.equals(hide)){
                COOValue pair= new COOValue(i, element);
                data.add(pair);
            }
        }
    }

    private int getInitialSize(){
        return initialSize;
    }

    private Object getPair(int i)
    {
        return this.listElements().get(i);
    }


    DataFrameColumn createDenseColumn(Object hide){
        DataFrameColumn denseColumn = new DataFrameColumn(this.columnName(), this.columnType());
        for (int i = 0; i < this.getInitialSize(); i++){
            denseColumn.data.add(hide);
        }
        for (int i = 0; i < this.columnSize(); i++){
            COOValue pair = (COOValue) this.getPair(i);
            denseColumn.data.set(pair.getKey(), pair.getValue());
        }
        return denseColumn;
    }
}
