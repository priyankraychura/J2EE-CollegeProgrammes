package JDBC_Conn_Programes;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Users user1 = new Users("Priyank", "pr@12345");
        Users user2 = new Users("User2", "pass2");
        Users user3 = new Users("User3", "pass3");

        UserDAO dao = new UserDAO();

        try {
            Users user = dao.createUser(user1);
            System.out.println(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
