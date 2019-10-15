package DataFrame;

import java.util.ArrayList;
import java.util.Arrays;

class DataFrameColumn{
    private String name;
    private String type;
    ArrayList<Object> data;

    DataFrameColumn(String _name, String _type){
        name = _name;
        type = _type;
        data = createColumn(_type);
    }

    int columnSize(){
        return this.data.size();
    }

    String columnName(){
        return this.name;
    }

    String columnType(){
        return this.type;
    }

    ArrayList<Object> listElements(){
        return this.data;
    }

    void fillInColumn(Object[] array){
        this.data.addAll(Arrays.asList(array));
    }

    void fillInColumn(ArrayList<Object> array){
        this.data.addAll(array);
    }

    DataFrameColumn createCell(Object ex){
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

    Object getValue(int i){
        if (i < data.size()){
            return data.get(i);
        }
        else
            return null;
    }

    void printColumn(){
        if (this.data.isEmpty()){
            System.out.println("Column not found.");
        }
        else {
            System.out.println("Column name = " + this.columnName());
            for (int i = 0; i < this.columnSize(); i++)
                System.out.println(this.data.get(i) + ";");
        }
    }

    private ArrayList<Object> createColumn(String type){
        return new ArrayList<>();
    }
}
