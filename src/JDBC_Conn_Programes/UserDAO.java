package JDBC_Conn_Programes;

import java.sql.*;

public class UserDAO {
    private  static  final String DBURL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    private  static  final String USER = "root";
    private  static  final String PASS = "";

    public Users createUser(Users user) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(DBURL, USER, PASS);

            String QUERY = "INSERT INTO users (username, password) VALUES (?,?)";
            stmt = conn.prepareStatement(QUERY, stmt.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected == 1){
                rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    user.setId(rs.getInt(1));
                }
                return user;
            } else{
                throw new SQLException("Falied");
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
