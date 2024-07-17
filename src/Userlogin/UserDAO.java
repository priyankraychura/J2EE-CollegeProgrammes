package Userlogin;
import JDBC_Conn_Programes.Users;
import java.sql.*;

public class UserDAO {
    public static String DB_URL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "";

    public void loginUsername(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("Successfully logged in");
            } else{
                System.out.println("Username or password incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
    }
}
