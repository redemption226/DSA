package InventoryManagement.example.WareHouse.Replenishment;

import InventoryManagement.example.Model.Products.ProductFactory.Product;

public interface ReplenishmentStartegy {

    void update(Product product);
}
