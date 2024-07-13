package Test_Practice;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s1 = new Student("Pruthvi", "pruthvi@12345");
        Student s2 = new Student("Priyank", "pr@12345");
//        s1.setRollNo(1);

        try {
//            dao.updateStudent(s1);
//            dao.deleteStudent(1);
            dao.insertStudent(s1);
            dao.insertStudent(s2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
