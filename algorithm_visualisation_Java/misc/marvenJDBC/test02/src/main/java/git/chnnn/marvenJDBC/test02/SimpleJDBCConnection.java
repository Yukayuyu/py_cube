package git.chnnn.marvenJDBC.test02;

import java.sql.*;

public class SimpleJDBCConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn = DriverManager
                .getConnection("jdbc:mariadb://localhost:3306/mySimpleDBSchema?user=rootlh&password=root");
        Statement statement = conn.createStatement();
        String sqlStr = ("SELECT * FROM user");
        // ! statement.executeUpdate(sqlStr);
        // !ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        ResultSet rs = statement.executeQuery(sqlStr);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
}
