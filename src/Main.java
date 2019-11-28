import DataFrame.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import value.*;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
/*
        String[] columnName = new String[]{"group", "name", "language", "mark"};
        String[] columnType = new String[]{"int", "String", "String", "int"};

        DataFrame test = new DataFrame(columnName, columnType);

        Integer[] group = new Integer[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        String[] name = new String[]{"a", "b", "c", "d", "a", "b", "c", "d","a", "b", "c", "d"};
        String[] language = new String[]{"E", "F", "F", "S", "E", "S", "F", "E", "S", "F", "E", "S"};
        Integer[] mark = new Integer[]{1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1};

        test.data().get(0).fillInColumn(group);
        test.data().get(1).fillInColumn(name);
        test.data().get(2).fillInColumn(language);
        test.data().get(3).fillInColumn(mark);

        test.printDataFrame();

        System.out.println("\nTestowanie sizeDF()");
        System.out.println(test.sizeDF());

        groupedDF tstGPB = test.groupby(new String[]{"group", "language"});


        //Mediana
        DataFrame applyDF = tstGPB.apply(new Applyable() {
            @Override
            public DataFrame apply(DataFrame group) {
                DataFrame newRow = new DataFrame();
                if (group.dataFrame.get(0).columnSize() % 2 == 1) {
                    for (DataFrameColumn col : group.dataFrame) {
                        if ((col.columnType().equals("int"))||(col.columnType().equals("double"))||(col.columnType().equals("float"))) {
                            Value value;
                            value = Value.build(String.valueOf(col.data.get(group.dataFrame.get(0).columnSize() / 2)));
                            newRow.dataFrame.add(col.createCell(value));
                        }
                    }
                } else
                    for (DataFrameColumn col : group.dataFrame) {
                        Value value;
                        if (col.columnType().equals("int")) {
                            value = Value.build(String.valueOf(
                                    col.data.get(group.dataFrame.get(0).columnSize() / 2 - 1).add(
                                            col.data.get(group.dataFrame.get(0).columnSize() / 2)
                                    ).div(Value.build("2"))
                            ));
                            newRow.dataFrame.add(col.createCell(value));
                        }
                        if ((col.columnType().equals("float"))||(col.columnType().equals("double"))) {
                            value = Value.build(String.valueOf(
                                    col.data.get(group.dataFrame.get(0).columnSize() / 2 - 1).add(
                                            col.data.get(group.dataFrame.get(0).columnSize() / 2)
                                    ).div(Value.build("2.0"))
                            ));
                            newRow.dataFrame.add(col.createCell(value));
                        }
                    }
                return newRow;
            }
        });

*/


/*
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
/*
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

        SparseDataFrame sparseDF = new SparseDataFrame(sparseTest, new value.Integer("0"));
        System.out.println("\nSparse DF:");
        sparseDF.printDataFrame();

        DataFrame denseDF = sparseDF.toDense(new value.Integer("0"));
        System.out.println("\nBack to dense:");
        denseDF.printDataFrame();
        */


        String path = new String("D:\\studia\\R2\\PrO\\Labs1\\data_frame\\files\\groupby\\groubymulti.csv");
        DataFrame DFFromFile = new DataFrame(path, new String[]{"String", "Date", "double", "double"});
        DFFromFile.groupby("id").max().printDataFrame();


        /*
        String path = new String("D:\\studia\\R2\\PrO\\Labs1\\data_frame\\files\\sparse.csv");
        DataFrame DFFromFile = new DataFrame(path, new String[]{"float", "float", "float"});
        SparseDataFrame SDFFromFile = new SparseDataFrame(DFFromFile, "0.0");
        SDFFromFile.printDataFrame();
        */

/*
        value.Integer a, b;
        String number1 = "12";
        String number2 = "20";
        a = new value.Integer(number1);
        b = new value.Integer(number2);
        System.out.println("Add: " + a.add(b));
        System.out.println("Sub: " + a.sub(b));
        System.out.println("Mul: " + a.mul(b));
        System.out.println("Div: " + a.div(b));
        System.out.println("Pow: " + a.pow(b));
        System.out.println("Eq: " + a.eq(b));
        System.out.println("Neq: " + a.neq(b));
        System.out.println("Lte: " + a.lte(b));
        System.out.println("Gte: " + a.gte(b));
        System.out.println("equals(Object = 12): " + a.equals(12));
        System.out.println(a.toString() + "; " + b.toString());

 */
/*
        System.out.println();
        number1 = "12.5";
        number2 = "20.146";
        value.Double ad, bd;
        ad = new value.Double(number1);
        bd = new value.Double(number2);
        System.out.println("Add: " + ad.add(bd));
        System.out.println("Sub: " + ad.sub(bd));
        System.out.println("Mul: " + ad.mul(bd));
        System.out.println("Div: " + ad.div(bd));
        System.out.println("Pow: " + ad.pow(bd));
        System.out.println("Eq: " + ad.eq(bd));
        System.out.println("Neq: " + ad.neq(bd));
        System.out.println("Lte: " + ad.lte(bd));
        System.out.println("Gte: " + ad.gte(bd));
        System.out.println("equals(Object = 12.5): " + ad.equals(12.5));
        System.out.println(ad.toString() + "; " + bd.toString());

        System.out.println();
        value.Float af, bf;
        af = new value.Float(number1);
        bf = new value.Float(number2);
        System.out.println("Add: " + af.add(bf));
        System.out.println("Sub: " + af.sub(bf));
        System.out.println("Mul: " + af.mul(bf));
        System.out.println("Div: " + af.div(bf));
        System.out.println("Pow: " + af.pow(bf));
        System.out.println("Eq: " + af.eq(bf));
        System.out.println("Neq: " + af.neq(bf));
        System.out.println("Lte: " + af.lte(bf));
        System.out.println("Gte: " + af.gte(bf));
        System.out.println("equals(Object = 12.5): " + af.equals(12.5));
        System.out.println(af.toString() + "; " + bf.toString());


        value.String a, b;
        String string1 = "My substring is just here!";
        String string2 = "ing";
        a = new value.String(string1);
        b = new value.String(string2);
        System.out.println("Add: " + a.add(b));
        System.out.println("Sub: " + a.sub(b));
        System.out.println("Mul: " + a.mul(b));
        System.out.println("Div: " + a.div(b));
        System.out.println("Pow: " + a.pow(b));
        System.out.println("Eq: " + a.eq(b));
        System.out.println("Neq: " + a.neq(b));
        System.out.println("Lte: " + a.lte(b));
        System.out.println("Gte: " + a.gte(b));
        System.out.println("equals(Object = \"Ing\"): " + b.equals("Ing"));
        System.out.println(a.toString() + "; " + b.toString());
        
 */
/*
        value.Time a, b, c;
        String aS = "20:10:15";
        String bS = "1:2:5";
        a = new Time(aS);
        b = new Time(bS);
        System.out.println(a.add(b).toString());
        System.out.println(b.sub(a).toString());
        c = new Time("20:10:16");
        System.out.println(a.lte(c));
}
 */

/*
        launch(args);

 */
    }


    public void start(Stage stage) throws Exception {
        FileChooser choose = new FileChooser();
        choose.setTitle("Choose the file: ");
        File file = choose.showOpenDialog(stage);
        DataFrame DFFromFile = new DataFrame(file);
        DataFrame gdf = DFFromFile.groupby("id").max();
        chooseData(stage, gdf);
    }


    public static void drawPlot(Stage stage, ArrayList<Value> x, ArrayList<Value> y){
        stage.setTitle("Chart");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        xAxis.setAutoRanging(true);
        yAxis.setLabel("y");
        yAxis.setAutoRanging(true);

        final ScatterChart<Number,Number> scatterChart =
                new ScatterChart<>(xAxis,yAxis);

        XYChart.Series series = new XYChart.Series();
        java.lang.Float minX=x.get(0).toNumber(), minY=y.get(0).toNumber();
        for(int i=0; i < x.size(); i++){
            series.getData().add(new XYChart.Data(x.get(i).toNumber(), y.get(i).toNumber()));
            if (x.get(i).toNumber()<minX) minX=x.get(i).toNumber();
            if (y.get(i).toNumber()<minY) minY=y.get(i).toNumber();
        }

        xAxis.setLowerBound((double)minX);
        yAxis.setLowerBound((double)minY);

        Scene scene  = new Scene(scatterChart,800,600);
        scatterChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }

    public void chooseData(Stage stage, DataFrame DF){
        final Label notification = new Label ();
        ComboBox comboBoxX = new ComboBox();
        comboBoxX.setPromptText("Choose X:");
        ComboBox comboBoxY = new ComboBox();
        comboBoxY.setPromptText("Choose Y:");

        Button submit = new Button("Draw Chart");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (comboBoxX.getValue() != null &&
                        !comboBoxX.getValue().toString().isEmpty() && comboBoxY.getValue() != null &&
                        !comboBoxY.getValue().toString().isEmpty()){
                        drawPlot(stage, DF.get(comboBoxX.getValue().toString()).data, DF.get(comboBoxY.getValue().toString()).data);
                }
                else {
                    notification.setText("Data not chosen!");
                }
            }
        });

        comboBoxX.getItems().addAll(DF.colNames());
        comboBoxY.getItems().addAll(DF.colNames());


        GridPane grid = new GridPane();
        grid.add(comboBoxX, 0, 0);
        grid.add(comboBoxY, 0, 1);
        grid.add(submit, 0, 2);

        Scene scene = new Scene(grid, 200, 120);
        stage.setScene(scene);
        stage.show();

    }
}
