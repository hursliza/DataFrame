package DataFrame;

import value.Value;

public class DFGT implements Runnable{
    Thread thread;
    public DataFrame myDF;
    DataFrame group;

    public DFGT(DataFrame _myDF, DataFrame _group){
        myDF = _myDF;
        group = _group;
    }

    public void run() {
        try {
            DataFrame row = new DataFrame();
            for (int j = 0; j < group.dataFrame.size(); j++) {
                Value maxValue = group.dataFrame.get(j).data.get(0);
                for (int i = 0; i < group.dataFrame.get(j).columnSize(); i++) {
                    if (group.dataFrame.get(j).data.get(i).gte(maxValue)) {
                        maxValue = group.dataFrame.get(j).data.get(i);
                    }
                }
                row.dataFrame.add(group.dataFrame.get(j).createCell(maxValue));
            }
            this.myDF.addRow(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.myDF.dataFrame.get(0).data.size() == 10)
            this.myDF.printDataFrame();
    }
}














