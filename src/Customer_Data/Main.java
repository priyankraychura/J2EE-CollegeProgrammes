package Customer_Data;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        Customer showCustomer;
        Customer updateCustomer = new Customer(1, "Pruthvi", "pvr@gmail.com", "9429042215");

        try {
//            dao.createCustomer("Priyank", "priyank@gmail.com", "6359467208");
//            dao.updateCustomer(updateCustomer);
            showCustomer = dao.getCustomerById(1);
//            dao.deleteCustomer(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(showCustomer);
    }
}
