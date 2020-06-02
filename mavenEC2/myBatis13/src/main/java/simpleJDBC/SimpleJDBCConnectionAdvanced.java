package simpleJDBC;

import java.sql.*;

public class SimpleJDBCConnectionAdvanced {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=rootlh&password=root");
        Statement statement = conn.createStatement();
        String sqlStr = ("USE 'mySimpleDBSchema';" +
                                     "SELECT * FROM 'user';");
        ResultSet resultSet = statement.executeQuery(sqlStr);
        System.out.println(resultSet);
    }
}
