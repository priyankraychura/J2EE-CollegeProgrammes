package Employee_Data;

import java.sql.*;

public class DBConnect {
    static final  String DBURL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    static final  String DBUSER = "root";
    static final  String DBPASS = "";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

        return conn;
    }
}
