package Customer_Data;

import java.sql.*;

public class CustomerDAO {
    private  static final String DB_URL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    private  static final String DB_USERNAME = "root";
    private  static final String DB_PASSWORD = "";

    public void createCustomer(String name, String email, String phone) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String SQL = "INSERT INTO customers (name, email, phone) values(?,?,?)";
            stmt = conn.prepareStatement(SQL);

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);

            stmt.executeUpdate();

            System.out.println("Customer created successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public Customer getCustomerById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String SQL = "SELECT * FROM customers WHERE id = ?";
            stmt = conn.prepareStatement(SQL);

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()){
                int customerId = rs.getInt("id");
                String customerName = rs.getString("name");
                String customerEmail = rs.getString("email");
                String customerPhone = rs.getString("phone");

                return new Customer(customerId, customerName, customerEmail, customerPhone);
            } else{
                System.out.println("Customer not found with id: " + id);
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void updateCustomer(Customer customer) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);


            String SQL = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";
            stmt = conn.prepareStatement(SQL);

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setInt(4, customer.getId());

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Customer updated successfully!");
            } else{
                System.out.println("Customer update failed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void deleteCustomer(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String SQL = "DELETE FROM customers WHERE id = ?";
            stmt = conn.prepareStatement(SQL);

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Customer deleted successfully!");
            } else{
                System.out.println("Customer not found with id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
