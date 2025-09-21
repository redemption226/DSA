package LLD.OrderManagement;

public class Controller {

    public static void main(String[] args) {
//        IOrder order = new Order("Order-1", 57);
//
//        IOrderSystem orderSystem = new OrderSystem();
//
//        orderSystem.addOrder(order);
//        System.out.println(orderSystem.calculateDiscountedPrice());
//        System.out.println((orderSystem.getCategoryDiscounts()));
//
//
//        System.out.println(orderSystem.getQuantity());


        IOrder order1 = new Order("Order-1", 49);
        IOrder order2 = new Order("Order-2", 31);
        IOrder order3 = new Order("Order-3", 74);
        IOrder order4 = new Order("Order-4", 21);
        IOrder order5 = new Order("Order-5", 64);
        IOrder order6 = new Order("Order-6", 94);
        IOrder order7 = new Order("Order-7", 23);
        IOrder order8 = new Order("Order-8", 23);
        IOrder order9 = new Order("Order-9", 71);
        IOrder order10 = new Order("Order-10", 15);
        IOrder order11 = new Order("Order-11", 15);
        IOrder order12 = new Order("Order-12", 10);



        IOrderSystem orderSystem2 = new OrderSystem();

        orderSystem2.addOrder(order1);
        orderSystem2.addOrder(order2);
        orderSystem2.addOrder(order3);
        orderSystem2.addOrder(order4);
        orderSystem2.addOrder(order5);
        orderSystem2.addOrder(order6);
        orderSystem2.addOrder(order7);
        orderSystem2.addOrder(order8);
        orderSystem2.addOrder(order9);
        orderSystem2.addOrder(order10);
        orderSystem2.addOrder(order11);
        orderSystem2.addOrder(order12);

        System.out.println(orderSystem2.calculateDiscountedPrice());

        System.out.println((orderSystem2.getCategoryDiscounts()));


        System.out.println(orderSystem2.getQuantity());
    }
}
