package LLD.example.Model.Products.ProductFactory;

import LLD.example.contants.CategoryEnum;

public abstract class ProductFactory {

    public static Product getProductInstance(CategoryEnum categoryEnum, int id, String name, int qty, int threshhold, int price) {
        if (categoryEnum.equals(CategoryEnum.ELECTRONICS))
            return new Electroinics(id, name, qty, threshhold, price);
        else
            throw new UnsupportedOperationException("Product class not supported");
    }

}
