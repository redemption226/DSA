package LLD.example.InventoryManager;

import lombok.Data;
import LLD.example.Model.Products.ProductFactory.Product;
import LLD.example.WareHouse.WareHouse;

import java.util.ArrayList;
import java.util.List;

@Data
public class InventoryManager {

    private static InventoryManager instance;
    List<WareHouse> wareHouses;
    private InventoryManager() {
        wareHouses = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addWareHouse(WareHouse wareHouse) {
        wareHouses.add(wareHouse);
    }

    public void addProduct(WareHouse wareHouse, Product p) {
        for (WareHouse ware : wareHouses) {
            if (wareHouse.equals(ware)) {
                wareHouse.addProduct(p);
            }
        }
    }

    public void updateProduct(WareHouse wareHouse, int productId, int qty) {
        for (WareHouse ware : wareHouses) {
            if (wareHouse.equals(ware)) {
                wareHouse.removeProduct(productId, qty );
            }
        }
    }
}
