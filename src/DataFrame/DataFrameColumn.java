package DataFrame;
import value.*;

import java.lang.String;
import java.util.ArrayList;

public class DataFrameColumn{
    private java.lang.String name;
    private java.lang.String type;
    public ArrayList<Value> data;

    DataFrameColumn(java.lang.String _name, java.lang.String _type){
        name = _name;
        type = _type;
        data = createColumn(_type);
    }

    public int columnSize(){
        return this.data.size();
    }

    public java.lang.String columnName(){
        return this.name;
    }

    public java.lang.String columnType(){
        return this.type;
    }

    ArrayList<Value> listElements(){
        return this.data;
    }

    public void fillInColumn(Object[] array){
        for (Object el:array) {
            String element = String.valueOf(el);
            this.data.add(Value.build(element));
        }
    }
    public void fillInColumn(ArrayList<Value> array){
        for (Object el:array) {
            String element = String.valueOf(el);
            this.data.add(Value.build(element));
        }
    }
    public void fillInColumnValues(ArrayList<Value> array){
        for (Object el:array) {
            this.data.add((Value) el);
        }
    }

    public DataFrameColumn createCell(Value ex){
        DataFrameColumn cell = new DataFrameColumn(this.columnName(), this.columnType());
        cell.data.add(ex);
        return cell;
    }

    DataFrameColumn createRange(int from, int to){
        DataFrameColumn newColumn = new DataFrameColumn(this.columnName(), this.columnType());
        for (int i = from; i < to + 1; i++){
            newColumn.data.add(this.getValue(i));
        }
        return newColumn;
    }

    Value getValue(int i){
        if (i < data.size()){
            return data.get(i);
        }
        else
            return null;
    }

    public void printColumn(){
        if (this.data.isEmpty()){
            System.out.println("Column not found.");
        }
        else {
            System.out.println("Column name = " + this.columnName());
            for (int i = 0; i < this.columnSize(); i++)
                System.out.println(this.data.get(i) + ";");
        }
    }

    private ArrayList<Value> createColumn(java.lang.String type){
        return new ArrayList<>();
    }
}
