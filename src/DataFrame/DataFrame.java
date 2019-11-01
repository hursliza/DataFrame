package DataFrame;
import java.io.*;

import javafx.util.Pair;
import value.*;

import java.lang.Integer;
import java.lang.String;
import java.util.*;


public class DataFrame implements Groupby{
    ArrayList<DataFrameColumn> dataFrame = new ArrayList<>();

    public DataFrame(String[] names, String[] types) {
        for (int i = 0; i < names.length; i++){
            DataFrameColumn newColumn = new DataFrameColumn(names[i], types[i]);
            dataFrame.add(newColumn);
        }
    }

    public DataFrame(String path, String[] types) throws IOException {
        ArrayList<String[]> data = getData(path);
        String[] names = data.get(0);
        for (int i = 0; i < names.length; i++){
            DataFrameColumn newColumn = new DataFrameColumn(names[i], types[i]);
            dataFrame.add(newColumn);
        }
        data.remove(0);
        ArrayList<ArrayList<Value>> columns = new ArrayList<>();
        for (int j = 0; j < data.get(0).length; j++){
            columns.add(new ArrayList<>());
        }
        for (int i = 0; i < data.size(); i++){
            for (int j = 0; j < data.get(0).length; j++){
                columns.get(j).add(i, Value.build(data.get(i)[j]));
            }
        }
        for (int i = 0; i < columns.size(); i++){
            this.data().get(i).fillInColumnValues(columns.get(i));
        }
    }

    DataFrame(){
        dataFrame = new ArrayList<>();
    }

    public ArrayList<DataFrameColumn> data(){
        return dataFrame;
    }

    public int sizeDF(){
        if (dataFrame.size() > 0)
            return dataFrame.get(0).columnSize();
        else
            return 0;
    }

    public DataFrameColumn get(String columnName){
        for (DataFrameColumn i : this.data())
            if (i.columnName().equals(columnName))
                return i;
        return new DataFrameColumn("null", "null");
    }

    public DataFrame getDF(String[] names, boolean copy){
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

    public DataFrame iloc(int num){
        DataFrame row = new DataFrame();
        for (DataFrameColumn column : this.data()){
            DataFrameColumn cell = column.createCell(column.getValue(num));
            row.dataFrame.add(cell);
        }
        return row;
    }

    public DataFrame iloc(int from, int to){
        DataFrame range = new DataFrame();
        for (DataFrameColumn column : this.data()){
            range.dataFrame.add(column.createRange(from, to));
        }
        return range;
    }

    public DataFrame addRow(DataFrame row){
        if (!this.dataFrame.isEmpty()){
            for (int i = 0; i < this.dataFrame.size(); i++){
                this.dataFrame.get(i).data.add(row.dataFrame.get(i).data.get(0));
            }
        }
        else
            for (DataFrameColumn cell : row.dataFrame){
                this.dataFrame.add(cell);
            }
        return this;
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

    static ArrayList<String[]> getData(String path) throws IOException {
        FileInputStream fstream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        ArrayList<String[]> lines= new ArrayList<>();

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            String[] row = strLine.split(",");
            lines.add(row);
        }

        return lines;
    }

    @Override
    public DataFrame max() {
        return null;
    }

    @Override
    public DataFrame min() {
        return null;
    }

    @Override
    public DataFrame std() {
        return null;
    }

    @Override
    public DataFrame sum() {
        return null;
    }

    @Override
    public DataFrame var() {
        return null;
    }

    @Override
    public LinkedList<DataFrame> groupby(String colname) {
        DataFrameColumn keys = this.get(colname);
        ArrayList<Value> uniqueKeys = removeDuplicates(keys.data);
        Map<Value, List<Integer>> entries = new HashMap<>();
        for (Value element : uniqueKeys) {
            entries.put(element, indexOfAll(element, keys.data));
        }
        LinkedList<DataFrame> grouped = new LinkedList<>();
        for (Map.Entry<Value, List<Integer>> entry : entries.entrySet()){
            DataFrame newDF = new DataFrame();
            for (int i : entry.getValue()){
                newDF.addRow(this.iloc(i));
            }
            grouped.add(newDF);
        }
        return grouped;
    }

    private ArrayList<Value> removeDuplicates(ArrayList<Value> list)
    {
        ArrayList<Value> newArray = new ArrayList<>();
        for (Value element : list) {
            if (!newArray.isEmpty()) {
                int ent = 0;
                for (int i = 0; i < newArray.size(); i++) {
                    if (element.eq(newArray.get(i))) {
                        ent += 1;
                        break;
                    }
                }
                if (ent == 0)
                    newArray.add(element);
            }
            else
                newArray.add(element);
        }
        return newArray;
    }

    private List<Integer> indexOfAll(Value obj, List<Value> list) {
        final List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (obj.eq(list.get(i))) {
                indexList.add(i);
            }
        }
        return indexList;
    }
}
