package Userlogin;
import JDBC_Conn_Programes.Users;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        Users user = new Users(username, password);

        try {
            dao.loginUsername(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
