package InventoryManagement.example;

import InventoryManagement.example.contants.CategoryEnum;
import InventoryManagement.example.InventoryManager.InventoryManager;
import InventoryManagement.example.Model.Products.ProductFactory.Product;
import InventoryManagement.example.Model.Products.ProductFactory.ProductFactory;
import InventoryManagement.example.WareHouse.EmailObserver;
import InventoryManagement.example.WareHouse.InventoryObserver;
import InventoryManagement.example.WareHouse.Replenishment.ReplenishmentStrategies.JustInTimeStrategy;
import InventoryManagement.example.WareHouse.WareHouse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        InventoryManager inventoryManager = InventoryManager.getInstance();

        WareHouse wareHouse1 = new WareHouse(new JustInTimeStrategy());
        InventoryObserver emailObserver = new EmailObserver();
        wareHouse1.addObserver(emailObserver);
        WareHouse wareHouse2 = new WareHouse(new JustInTimeStrategy());
        wareHouse2.addObserver(emailObserver);

        Product mobile =
                ProductFactory.getProductInstance
                        (CategoryEnum.ELECTRONICS, 12,"Mobile", 10, 5, 30000);

        Product tv =
                ProductFactory.getProductInstance
                        (CategoryEnum.ELECTRONICS, 100,"TV", 10, 5, 40000);

//        wareHouse1.addProduct(mobile);
//
//        wareHouse1.addProduct(tv);
//        InventoryObserver emailObserver = new EmailObserver();
//        wareHouse1.addObserver(emailObserver);
//
//
//        wareHouse1.removeProduct(12, 10);
//        wareHouse1.removeProduct(100, 2);

        inventoryManager.addWareHouse(wareHouse1);
        inventoryManager.addWareHouse(wareHouse2);

        inventoryManager.addProduct(wareHouse1, mobile);
        inventoryManager.addProduct(wareHouse2, tv);

        inventoryManager.updateProduct(wareHouse1, 12, 10);
        inventoryManager.updateProduct(wareHouse1, 100, 6);
    }

}