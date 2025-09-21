package LLD.example.WareHouse;


import lombok.Data;
import LLD.example.Model.Products.ProductFactory.Product;
import LLD.example.WareHouse.Replenishment.ReplenishmentStartegy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class WareHouse {

    int pincode;
    String location;
    String wareHouseName;
    int warehouseId;
    HashMap<Integer, Product> productMap ;
    List<InventoryObserver> observerList ;
    ReplenishmentStartegy replenishmentStartegy;


    public WareHouse(ReplenishmentStartegy replenishmentStartegy) {
        productMap = new HashMap();
        observerList = new ArrayList<>();
        this.replenishmentStartegy = replenishmentStartegy;
    }

    public void addObserver(InventoryObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(InventoryObserver observer) {
        observerList.remove(observer);
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
        System.out.println("Product added");
    }

    public void removeProduct(int productId, int qty ) {

        Product product = productMap.get(productId);
        if (product != null) {
            if (product.getQuantity() >= qty) {
                product.setQuantity(product.getQuantity() - qty);

                if (product.getQuantity() < product.getThreshholdQty()) {
                    notifyObservers(product);
                    replenishmentStartegy.update(product);
                }
            }
        }
        else
            System.out.println("Item not found " + productId);
    }

    void notifyObservers(Product product) {
        for (InventoryObserver observer : observerList) {
            observer.update(product);
        }
    }






}
