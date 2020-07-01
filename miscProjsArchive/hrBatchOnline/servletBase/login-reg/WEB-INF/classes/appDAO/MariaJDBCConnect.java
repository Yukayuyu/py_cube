package appDAO;

import static appService.logger.AppLogLevels.WARN;
import static appService.logger.AppLogger.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import appDAO.dataObjects.UserDO;

public class MariaJDBCConnect {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mySimpleDBSchema";
    static final String uID = "rootlh";
    static final String uPW = "root";
    static final String uTBL = "batch_user_TBL";
    static DataSource ds;

    // public static void main(String[] args) {
    //     System.out.println(getAllUsers().get(0).getUPWHashed());
    // }

    public static List<UserDO> getAllUsers() {
        try{
        if(ds==null){
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/mySimpleDBSchema");
        } 
        }catch (Exception e){
            System.err.println(e);
        }
        List<UserDO> outList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // Open connection
            // conn = DriverManager.getConnection(DB_URL, uID, uPW);
            conn = ds.getConnection();

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, uPWHashed, email FROM " + uTBL;
            rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String id = rs.getString("id");
                String uPWHashed = rs.getString("uPWHashed");
                String email = rs.getString("email");
                UserDO userdo = new UserDO(id, uPWHashed, email);
                outList.add(userdo);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                log(e, WARN);
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                log(e, WARN);
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
                log(e, WARN);
            }
        }
        return outList;
    }

}
