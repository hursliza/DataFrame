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


    public static void main(String[] args) {
        String[] columnName = new String[]{"index", "name", "language", "mark"};
        String[] columnType = new String[]{"int", "String", "String", "double"};

        DataFrame test = new DataFrame(columnName, columnType);

        Integer[] index = new Integer[]{12100, 12110, 12320, 14521, 13207};
        String[] name = new String[]{"olga", "michal", "poco", "agata", "piotr"};
        String[] language = new String[]{"english", "french", "english", "java", "spanish"};
        Double[] mark = new Double[]{4.5, 3.0, 3.5, 4.0, 3.5};

        test.data().get(0).fillInColumn(index);
        test.data().get(1).fillInColumn(name);
        test.data().get(2).fillInColumn(language);
        test.data().get(3).fillInColumn(mark);

        test.printDataFrame();

        System.out.println("\nTestowanie sizeDF()");
        System.out.println(test.sizeDF());


        //testowanie metod get
        DataFrameColumn testColumn;

        System.out.println("\nTestowanie get(String colname)");
        testColumn = test.get("name");
        testColumn.printColumn();

        System.out.println("\nTestowanie getDF(String[] colname, boolean copy)");
        DataFrame getTest;
        String[] testNames = new String[]{"index", "mark", "name", "grade"};
        getTest = test.getDF(testNames, true);
        getTest.printDataFrame();

        //iloc
        System.out.println("\nTestowanie iloc(int i)");
        DataFrame ilocTest = test.iloc(4);
        ilocTest.printDataFrame();

        System.out.println("\nTestowanie iloc(int from, int to)");
        ilocTest = test.iloc(2, 4);
        ilocTest.printDataFrame();

        //Sparse Data Frame tests
        columnName = new String[]{"poems", "music"};
        columnType = new String[]{"int", "int"};

        DataFrame sparseTest = new DataFrame(columnName, columnType);

        Integer[] poems = new Integer[]{0, 7, 0, 0, 5 , 0, 0};
        Integer[] music = new Integer[]{0, 0, 1, 0, 0, 2, 0};

        sparseTest.data().get(0).fillInColumn(poems);
        sparseTest.data().get(1).fillInColumn(music);

        sparseTest.printDataFrame();

        SparseDataFrame sparseDF = new SparseDataFrame(sparseTest, 0);
        System.out.println("Sparse DF:");
        sparseDF.printDataFrame();

        DataFrame denseDF = sparseDF.toDense(0);
        System.out.println("Back to dense:");
        denseDF.printDataFrame();
    }
}
