package LLD.OrderManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IOrderSystem {

    List<IOrder> orderItems = new ArrayList<>();
    Map<String, Integer> categoryDiscountMap = new HashMap<>();
    
    void addOrder(IOrder order);
    void removeOrder(IOrder order);
    Integer calculateDiscountedPrice();
    Map<String, Integer> getCategoryDiscounts();
    Map<String, Integer> getQuantity();
}
