package LLD.OrderManagement;

public class Order implements IOrder{

    Integer cartValue = 0;

    Integer orderPrice;
    String orderName;

    Order(String orderName, Integer orderPrice ) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
    }


    @Override
    public Integer getOrderPrice() {
        return orderPrice;
    }

    @Override
    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String getOrderName() {
        return this.orderName;
    }
}
