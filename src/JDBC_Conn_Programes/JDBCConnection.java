package JDBC_Conn_Programes;

import java.sql.*;

public class JDBCConnection {
    static  final String DBURL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    static  final String USER = "root";
    static  final String PASS = "";
    static  final String QUERY = "select * from users";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(DBURL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("username"));
                System.out.println(", Password: " + rs.getString("password"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
