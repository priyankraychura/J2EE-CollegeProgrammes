package Employee_Data;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Employee-2", "Dept-2");

        EmpDAO e1 = new EmpDAO();

        try {
            Employee em = e1.createEmployee(emp1);
            System.out.println(em);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
