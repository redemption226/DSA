package InventoryManagement.example.WareHouse.Replenishment.ReplenishmentStrategies;

import InventoryManagement.example.Model.Products.ProductFactory.Product;
import InventoryManagement.example.WareHouse.Replenishment.ReplenishmentStartegy;

public class JustInTimeStrategy implements ReplenishmentStartegy {

    @Override
    public void update(Product product) {
        System.out.println("JIT Startegy called");
    }
}
