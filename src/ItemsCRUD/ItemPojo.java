/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemsCRUD;

/**
 *
 * @author Priya
 */
public class ItemPojo {
    int itemId;
    String itemName;
    String itemRate;

    public ItemPojo(String itemName, String itemRate) {
        this.itemName = itemName;
        this.itemRate = itemRate;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemRate() {
        return itemRate;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemRate(String itemRate) {
        this.itemRate = itemRate;
    }

    @Override
    public String toString() {
        return "ItemPojo{" + "itemId=" + itemId + ", itemName=" + itemName + ", itemRate=" + itemRate + '}';
    }
   
}
