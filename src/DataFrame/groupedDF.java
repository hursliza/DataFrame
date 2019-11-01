package DataFrame;

import value.Value;

import java.util.LinkedList;

public class groupedDF implements Groupby{
    LinkedList<DataFrame> dfList = new LinkedList<>();

    public groupedDF(DataFrame df, String colname){
        dfList = df.groupby(colname);
    }

    @Override
    public DataFrame max() {
        DataFrame maxDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                Value maxValue = group.dataFrame.get(j).data.get(0);
                for (int i=0; i < group.dataFrame.get(j).columnSize(); i++){
                    if (group.dataFrame.get(j).data.get(i).gte(maxValue)){
                        maxValue = group.dataFrame.get(j).data.get(i);
                    }
                }
                row.dataFrame.add(group.dataFrame.get(j).createCell(maxValue));
            }
            maxDF.addRow(row);
        }
        return maxDF;
    }

    @Override
    public DataFrame min() {
        DataFrame minDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                Value minValue = group.dataFrame.get(j).data.get(0);
                for (int i=0; i < group.dataFrame.get(j).columnSize(); i++){
                    if (group.dataFrame.get(j).data.get(i).lte(minValue)){
                        minValue = group.dataFrame.get(j).data.get(i);
                    }
                }
                row.dataFrame.add(group.dataFrame.get(j).createCell(minValue));
            }
            minDF.addRow(row);
        }
        return minDF;
    }

    @Override
    public DataFrame std() {
        return null;
    }

    @Override
    public DataFrame sum() {
        DataFrame sumDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                if ((group.dataFrame.get(j).columnType() == "int")||(group.dataFrame.get(j).columnType() == "float")
                ||(group.dataFrame.get(j).columnType() == "double")) {
                    Value sumValue = group.dataFrame.get(j).data.get(0);
                    for (int i = 1; i < group.dataFrame.get(j).columnSize(); i++) {
                        sumValue = sumValue.add(group.dataFrame.get(j).data.get(i));
                    }
                    row.dataFrame.add(group.dataFrame.get(j).createCell(sumValue));
                }
            }
            sumDF.addRow(row);
        }
        return sumDF;
    }

    @Override
    public DataFrame var() {
        return null;
    }

}
