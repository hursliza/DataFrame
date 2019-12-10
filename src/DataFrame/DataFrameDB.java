package DataFrame;

import value.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DataFrameDB extends DataFrame {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;


    public DataFrameDB() {
    }

    public DataFrame groupBy(String colname) {
        String sql = "SELECT id, min(date), min(total), min(val) FROM groupby GROUP BY id";
        DataFrame result = new DataFrame(new String[]{"id", "date", "total", "val"}, new String[]{"String", "Date", "double", "double"});

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            parseDF(rs, result);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private Connection connect() {
        // db parameters
        String url = "jdbc:sqlite:D:\\studia\\R2\\PrO\\Labs1\\data_frame\\db\\groupby";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void parseDF(ResultSet rs, DataFrame DF) throws SQLException {
        while (rs.next()) {
            Value id = Value.build(rs.getString(1));
            Value date = Value.build(rs.getString(2));
            Value total = Value.build(rs.getString(3));
            Value val = Value.build(rs.getString(4));
            DataFrame newRow = new DataFrame(new String[]{"id", "date", "total", "val"}, new String[]{"String", "Date", "double", "double"});
            newRow.data().get(0).fillInColumn(new Value[]{id});
            newRow.data().get(1).fillInColumn(new Value[]{date});
            newRow.data().get(2).fillInColumn(new Value[]{total});
            newRow.data().get(3).fillInColumn(new Value[]{val});
            DF.addRow(newRow);
        }
    }


    public void csvLoad(String csvFilePath, String tablename) throws IOException {
        BufferedReader br = null;
        File file = new File(csvFilePath);
        String line = "";
        String csvSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(file));
            Connection connection = this.connect();
            connection.createStatement().execute("DELETE FROM " + tablename);
            Statement statement = connection.createStatement();
            int limit=0;
            while ((line = br.readLine()) != null && limit < 1000)
            {
                if (limit == 0){
                    limit++;
                    continue;
                }
                try{
                    String[] col = line.split(csvSplitBy);
                    String query = "INSERT INTO "+ tablename + " ('id', 'date', 'total', 'val') VALUES ('" +
                            col[0] + "', '" + col[1] + "', '" +  col[2] + "', '" + col[3] + "')";
                    statement.execute(query);
                    limit++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Imported.");
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            {
                if (br != null) {
                    br.close();
                }
            }
        }
    }
}

