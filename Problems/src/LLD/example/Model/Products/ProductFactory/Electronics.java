package LLD.example.Model.Products.ProductFactory;


import lombok.Data;
import LLD.example.contants.CategoryEnum;

@Data
public class Electronics extends Product{

    int ramSize;
    int cpu;

    public Electronics(int id, String name, int qty, int threshhold, int price) {
        super();
        setProductId(id);
        setCategory(CategoryEnum.ELECTRONICS);
        setName(name);
        setQuantity(qty);
        setThreshholdQty(threshhold);
        setPrice(price);

    }
}
