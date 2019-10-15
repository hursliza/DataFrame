package DataFrame;

import java.util.ArrayList;

public class SparseDataFrame extends DataFrame{
    private ArrayList<SparseDataFrameColumn> dataFrame = new ArrayList<>();

    public SparseDataFrame(DataFrame init, Object hide){
        for (DataFrameColumn column : init.data()){
            SparseDataFrameColumn sparseColumn = new SparseDataFrameColumn(column, hide);
            this.dataFrame.add(sparseColumn);
        }
    }

    public int sizeDF(){
        return this.dataFrame.get(0).data.size();
    }

    public void printDataFrame(){
        for (SparseDataFrameColumn column : this.dataFrame){
            System.out.print("|\t" + column.columnName() + "\t|");
        }
        System.out.println();
        for (int i = 0; i < this.sizeDF(); i++){
            for (DataFrameColumn dataFrameColumn : dataFrame) {
                ((COOValue) dataFrameColumn.getValue(i)).printCOOValue();
            }
            System.out.println();
        }
    }

    public DataFrame toDense(Object hide){
        DataFrame denseDF = new DataFrame();
        for (SparseDataFrameColumn column : this.dataFrame){
            DataFrameColumn newColumn = column.createDenseColumn(hide);
            denseDF.dataFrame.add(newColumn);
        }
        return  denseDF;
    }
}
