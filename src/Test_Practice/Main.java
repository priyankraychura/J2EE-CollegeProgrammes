package Test_Practice;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s1 = new Student("Priyank", "pr@12345");

        try {
            dao.insertStudent(s1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
