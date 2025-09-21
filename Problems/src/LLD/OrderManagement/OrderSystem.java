package LLD.OrderManagement;

import java.util.HashMap;
import java.util.Map;

public class OrderSystem implements IOrderSystem{


    Map<PRODUCT_CATEGORY, Integer> categoryToDiscountMap = new HashMap<>();

    OrderSystem() {
        categoryToDiscountMap.putIfAbsent(PRODUCT_CATEGORY.CHEAP, 10);
        categoryToDiscountMap.putIfAbsent(PRODUCT_CATEGORY.MODERATE, 20);
        categoryToDiscountMap.putIfAbsent(PRODUCT_CATEGORY.EXPENSIVE, 30);
    }

    @Override
    public Integer calculateDiscountedPrice() {
        Integer finalDiscountedPrice = 0;
        for (IOrder order : orderItems) {
            Integer discountedPrice = 0;
            Integer discount = 0;
            Integer orderPrice = order.getOrderPrice();
            if (orderPrice <= 10) {
                discount = categoryToDiscountMap.get(PRODUCT_CATEGORY.CHEAP);
                discountedPrice = (orderPrice * discount / 100);

                categoryDiscountMap.put(PRODUCT_CATEGORY.CHEAP.toString(), categoryDiscountMap.getOrDefault(PRODUCT_CATEGORY.CHEAP.toString(), 0) + discountedPrice);
            }
            else if (orderPrice > 10 && orderPrice <= 20) {
                discount = categoryToDiscountMap.get(PRODUCT_CATEGORY.MODERATE);
                discountedPrice = (orderPrice * discount / 100);

                categoryDiscountMap.put(PRODUCT_CATEGORY.MODERATE.toString(), categoryDiscountMap.getOrDefault(PRODUCT_CATEGORY.MODERATE.toString(), 0) + discountedPrice);

            } else {
                discount = categoryToDiscountMap.get(PRODUCT_CATEGORY.EXPENSIVE);
                discountedPrice = (orderPrice * discount / 100);
                //System.out.println(discountedPrice);
                categoryDiscountMap.put(PRODUCT_CATEGORY.EXPENSIVE.toString(), categoryDiscountMap.getOrDefault(PRODUCT_CATEGORY.EXPENSIVE.toString(), 0) + discountedPrice);

            }
            finalDiscountedPrice += (orderPrice - discountedPrice);
        }
        return  finalDiscountedPrice;
    }

    @Override
    public Map<String, Integer> getCategoryDiscounts() {
        return categoryDiscountMap;
    }

    @Override
    public void addOrder(IOrder order) {
        orderItems.add(order);
    }

    @Override
    public void removeOrder(IOrder order) {
        orderItems.remove(order);
    }

    @Override
    public Map<String, Integer> getQuantity() {
        Map<String, Integer> res = new HashMap<>();

        for (IOrder order : orderItems) {
            res.put(order.getOrderName(), 1);
        }

        return res;

    }
}
