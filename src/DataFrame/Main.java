package DataFrame;

public class Main {
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
        columnName = new String[]{"houses", "flats"};
        columnType = new String[]{"int", "int"};

        DataFrame sparseTest = new DataFrame(columnName, columnType);

        Integer[] houses = new Integer[]{0, 7, 0, 0, 5 , 0, 0};
        Integer[] flats = new Integer[]{0, 0, 1, 0, 0, 2, 0};

        sparseTest.data().get(0).fillInColumn(houses);
        sparseTest.data().get(1).fillInColumn(flats);

        System.out.println("\nNew data frame:");
        sparseTest.printDataFrame();

        SparseDataFrame sparseDF = new SparseDataFrame(sparseTest, 0);
        System.out.println("\nSparse DF:");
        sparseDF.printDataFrame();

        DataFrame denseDF = sparseDF.toDense(0);
        System.out.println("\nBack to dense:");
        denseDF.printDataFrame();
    }
}
