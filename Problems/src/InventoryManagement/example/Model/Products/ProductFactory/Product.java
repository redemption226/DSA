package InventoryManagement.example.Model.Products.ProductFactory;

import lombok.Data;
import InventoryManagement.example.contants.CategoryEnum;

@Data
public abstract class Product {

    private int productId;
    private String name;
    private int quantity;
    private int threshholdQty;
    private CategoryEnum category;
    private double price;

}
