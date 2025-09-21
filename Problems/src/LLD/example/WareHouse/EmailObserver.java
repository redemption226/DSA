package LLD.example.WareHouse;

import LLD.example.Model.Products.ProductFactory.Product;

public class EmailObserver implements InventoryObserver {


    @Override
    public void update(Product product) {
        System.out.println("Email sent for Product " + product.getName());
    }
}
