package DataFrame;

import java.util.ArrayList;

public class DataFrame {
    ArrayList<DataFrameColumn> dataFrame = new ArrayList<>();

    DataFrame(String[] names, String[] types) {
        for (int i = 0; i < names.length; i++){
            DataFrameColumn newColumn = new DataFrameColumn(names[i], types[i]);
            dataFrame.add(newColumn);
        }
    }
    DataFrame(){
        dataFrame = new ArrayList<>();
    }

    ArrayList<DataFrameColumn> data(){
        return dataFrame;
    }

    public int sizeDF(){
        if (dataFrame.size() > 0)
            return dataFrame.get(0).columnSize();
        else
            return 0;
    }

    DataFrameColumn get(String columnName){
        for (DataFrameColumn i : this.data())
            if (i.columnName().equals(columnName))
                return i;
        return new DataFrameColumn("null", "null");
    }

    DataFrame getDF(String[] names, boolean copy){
        DataFrame myDF = new DataFrame();
        for (String name : names){
            for (DataFrameColumn column : this.data()){
                if (column.columnName().equals(name)){
                    if (copy) {
                        DataFrameColumn myColumn = new DataFrameColumn(column.columnName(), column.columnType());
                        myColumn.fillInColumn(column.listElements());
                        myDF.dataFrame.add(myColumn);
                    }
                    else{
                        DataFrameColumn myColumn = new DataFrameColumn(column.columnName(), column.columnType());
                        myColumn.data = column.listElements();
                        myDF.dataFrame.add(myColumn);
                    }

                }
            }
        }
        if (names.length != myDF.data().size())
            System.out.println("Some columns have not been found. Data frame of the existing columns: ");
        return myDF;
    }

    DataFrame iloc(int num){
        DataFrame row = new DataFrame();
        for (DataFrameColumn column : this.data()){
            DataFrameColumn cell = column.createCell(column.getValue(num));
            row.dataFrame.add(cell);
        }
        return row;
    }

    DataFrame iloc(int from, int to){
        DataFrame range = new DataFrame();
        for (DataFrameColumn column : this.data()){
            range.dataFrame.add(column.createRange(from, to));
        }
        return range;
    }

    public void printDataFrame(){
        for (DataFrameColumn column : this.data())
            System.out.print("|\t" + column.columnName() + "\t|");
        System.out.println();
        for (int i = 0; i < this.sizeDF(); i++){
            for (DataFrameColumn dataFrameColumn : dataFrame) {
                System.out.print("|\t" + dataFrameColumn.getValue(i) + "\t|");
            }
            System.out.println();
        }
    }

}
