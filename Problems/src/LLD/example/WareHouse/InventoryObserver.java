package LLD.example.WareHouse;

import LLD.example.Model.Products.ProductFactory.Product;

public interface InventoryObserver {
    public void update(Product product);
}
