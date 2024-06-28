package Employee_Data;

import java.sql.*;

public class EmpDAO {
    public Employee createEmployee(Employee emp) throws SQLException {
        Connection conn = DBConnect.getConnection();

        String QUERY = "insert into employee(empName, empDept) values(?,?)";
        PreparedStatement stmt = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, emp.getEmpName());
        stmt.setString(2, emp.getEmpDept());

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected == 1) {
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                emp.setEmpId(rs.getInt(1));
            }
            return emp;
        } else{
            return null;
        }
    }
}
