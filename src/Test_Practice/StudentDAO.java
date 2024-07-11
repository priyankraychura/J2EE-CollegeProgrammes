package Test_Practice;

import java.sql.*;

public class StudentDAO {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "";

    public void insertStudent(Student st) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String URL = "INSERT INTO student (name, password) VALUES (?, ?)";
            stmt = conn.prepareStatement(URL);

            stmt.setString(1, st.getName());
            stmt.setString(2, st.getPassword());

            stmt.executeUpdate();

            System.out.println("Student inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            conn.close();
        }
    }
}
