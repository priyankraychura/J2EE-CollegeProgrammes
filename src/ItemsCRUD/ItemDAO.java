/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemsCRUD;
import java.sql.*;

/**
 *
 * @author Priya
 */
public class ItemDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bca-sem-5b";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    
    public void insertItem(ItemPojo item) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            String SQL = "INSERT INTO items (itemName, itemRate) VALUES(?, ?)";
            stmt = conn.prepareStatement(SQL);
            
            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getItemRate());
            
            int rowsAffected = stmt.executeUpdate();
            
            if(rowsAffected == 1){
                System.out.println("item Inserted Successfully!");
            } else{
                System.out.println("Failed to Insert Item");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            if(stmt != null){
                stmt.close();            
            }
            if(conn != null){
                conn.close();
            }
        }
        
    }
    
    public void showItems() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        String SQL = "SELECT * FROM items";
        stmt = conn.prepareStatement(SQL);
        rs = stmt.executeQuery();

        while(rs.next()){
            String itemName = rs.getString("itemName");
            String itemRate = rs.getString("itemRate");
            System.out.println(itemName + " : " + itemRate);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
    }
    
}
