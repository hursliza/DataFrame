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
        DataFrame maxDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                Value maxValue = group.dataFrame.get(j).data.get(0);
                for (int i=0; i < group.dataFrame.get(j).columnSize(); i++){
                    if (group.dataFrame.get(j).data.get(i).lte(maxValue)){
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

}
