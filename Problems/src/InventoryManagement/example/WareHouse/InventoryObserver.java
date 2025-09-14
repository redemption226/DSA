package InventoryManagement.example.WareHouse;

import InventoryManagement.example.Model.Products.ProductFactory.Product;

public interface InventoryObserver {
    public void update(Product product);
}
