package DataFrame;

import value.Double;
import value.Value;

import java.util.ArrayList;
import java.util.LinkedList;

public class groupedDF implements Groupby{
    public LinkedList<DataFrame> dfList;

    public groupedDF(DataFrame df, String colname){ dfList= df.groupby(colname).dfList; }
    public groupedDF() {dfList = new LinkedList<>();}

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
    public DataFrame mean() {
        DataFrame meanDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                if ((group.dataFrame.get(j).columnType().equals("int"))||(group.dataFrame.get(j).columnType().equals("float"))
                        ||(group.dataFrame.get(j).columnType().equals("double"))) {
                    Double meanValue = (Double) group.dataFrame.get(j).data.get(0);
                    for (int i = 1; i < group.dataFrame.get(j).columnSize(); i++) {
                        meanValue = meanValue.add(group.dataFrame.get(j).data.get(i));
                    }
                    meanValue = (Double) meanValue.div(new Double(String.valueOf(group.dataFrame.get(j).columnSize())));
                    row.dataFrame.add(group.dataFrame.get(j).createCell(meanValue));
                }
            }
            meanDF.addRow(row);
        }
        return meanDF;
    }

    @Override
    public DataFrame std() {
        DataFrame stdDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                if ((group.dataFrame.get(j).columnType().equals("int"))||(group.dataFrame.get(j).columnType().equals("float"))
                        ||(group.dataFrame.get(j).columnType().equals("double"))) {

                    Double meanValue = (Double) group.dataFrame.get(j).data.get(0);
                    for (int i = 1; i < group.dataFrame.get(j).columnSize(); i++) {
                        meanValue = meanValue.add(group.dataFrame.get(j).data.get(i));
                    }
                    meanValue = (Double) meanValue.div(new Double(String.valueOf(group.dataFrame.get(j).columnSize())));

                    Double sumValue = (Double) group.dataFrame.get(j).data.get(0).sub(meanValue).mul
                            (group.dataFrame.get(j).data.get(0).sub(meanValue));
                    for (int i = 1; i < group.dataFrame.get(j).columnSize(); i++) {
                        sumValue = sumValue.add(group.dataFrame.get(j).data.get(i).sub(meanValue).mul
                                (group.dataFrame.get(j).data.get(i).sub(meanValue)));
                    }
                    Double varVal = new Double(sumValue.div(Value.build(String.valueOf(group.dataFrame.get(j).columnSize()))).toString());
                    String strVal = varVal.toString();
                    Double stdVal = new Double(String.valueOf(Math.sqrt(java.lang.Double.parseDouble(strVal))));
                    row.dataFrame.add(group.dataFrame.get(j).createCell(stdVal));
                }

            }
            stdDF.addRow(row);
        }
        return stdDF;
    }

    @Override
    public DataFrame sum() {
        DataFrame sumDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                if ((group.dataFrame.get(j).columnType().equals("int"))||(group.dataFrame.get(j).columnType().equals("float"))
                ||(group.dataFrame.get(j).columnType().equals("double"))) {
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
        DataFrame varDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame row = new DataFrame();
            for (int j=0; j < group.dataFrame.size(); j++) {
                if ((group.dataFrame.get(j).columnType().equals("int"))||(group.dataFrame.get(j).columnType().equals("float"))
                        ||(group.dataFrame.get(j).columnType().equals("double"))) {

                    Double meanValue = (Double) group.dataFrame.get(j).data.get(0);
                    for (int i = 1; i < group.dataFrame.get(j).columnSize(); i++) {
                        meanValue = meanValue.add(group.dataFrame.get(j).data.get(i));
                    }
                    meanValue = (Double) meanValue.div(new Double(String.valueOf(group.dataFrame.get(j).columnSize())));

                    Double sumValue = (Double) group.dataFrame.get(j).data.get(0).sub(meanValue).mul
                            (group.dataFrame.get(j).data.get(0).sub(meanValue));
                    for (int i = 1; i < group.dataFrame.get(j).columnSize(); i++) {
                        sumValue = sumValue.add(group.dataFrame.get(j).data.get(i).sub(meanValue).mul
                                (group.dataFrame.get(j).data.get(i).sub(meanValue)));
                    }
                    row.dataFrame.add(group.dataFrame.get(j).createCell(new Double(sumValue.div(Value.build(String.valueOf(group.dataFrame.get(j).columnSize()))).toString())));
                }

            }
            varDF.addRow(row);
        }
        return varDF;
    }

    @Override
    public DataFrame apply(Applyable fun) {
        DataFrame newDF = new DataFrame();
        for (DataFrame group : this.dfList){
            DataFrame newRow = fun.apply(group);
            newDF.addRow(newRow);
        }
        return newDF;
    }
}

