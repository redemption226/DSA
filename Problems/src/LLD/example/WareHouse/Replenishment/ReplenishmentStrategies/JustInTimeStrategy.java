package LLD.example.WareHouse.Replenishment.ReplenishmentStrategies;

import LLD.example.Model.Products.ProductFactory.Product;
import LLD.example.WareHouse.Replenishment.ReplenishmentStartegy;

public class JustInTimeStrategy implements ReplenishmentStartegy {

    @Override
    public void update(Product product) {
        System.out.println("JIT Startegy called");
    }
}
