import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Cp34_PreparedStatement {
    void run() throws SQLException {
        Connection con;
        PreparedStatement pstmt =
                con.prepareStatement("UPDATE EMPLOYEES SET SALARY = ? WHERE ID = ?");
        pstmt.setInt(2, 110592);
    }
}

