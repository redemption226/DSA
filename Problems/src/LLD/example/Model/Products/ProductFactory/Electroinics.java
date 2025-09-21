package LLD.example.Model.Products.ProductFactory;


import lombok.Data;
import LLD.example.contants.CategoryEnum;

@Data
public class Electroinics extends Product{

    int ramSize;
    int cpu;

    public Electroinics(int id, String name, int qty, int threshhold, int price) {
        super();
        setProductId(id);
        setCategory(CategoryEnum.ELECTRONICS);
        setName(name);
        setQuantity(qty);
        setThreshholdQty(threshhold);
        setPrice(price);

    }
}
