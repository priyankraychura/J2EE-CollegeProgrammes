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

    public void updateStudent(Student st) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String SQL = "UPDATE student SET name = ?, password = ? WHERE id = ?";
            stmt = conn.prepareStatement(SQL);

            stmt.setString(1, st.getName());
            stmt.setString(2, st.getPassword());
            stmt.setInt(3, st.getRollNo());

            int rowsUpdated = stmt.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Student updated successfully");
            } else{
                System.out.println("Student update failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            conn.close();
        }


    }

    public void deleteStudent(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String SQL = "DELETE FROM student WHERE id = ?";
            stmt = conn.prepareStatement(SQL);

            stmt.setInt(1, id);

            int rowsUpdated = stmt.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Student deleted successfully");
            } else{
                System.out.println("Student delete failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            stmt.close();
            conn.close();
        }
    }
}
