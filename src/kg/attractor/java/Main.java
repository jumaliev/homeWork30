package kg.attractor.java;

import kg.attractor.java.homework.RestaurantOrders;

public class Main {

    public static void main(String[] args) {
        var orders = RestaurantOrders.read("orders_100.json").getOrders();
//        var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
//        RestaurantOrders.read("orders_100.json").printOrders();
//        RestaurantOrders.read("orders_100.json").ordersLargestAmounts(15);
//        RestaurantOrders.read("orders_100.json").ordersSmallestAmounts(15);
//        System.out.println(RestaurantOrders.read("orders_100.json").homeDeliveryOrders());
//        System.out.println(RestaurantOrders.read("orders_100.json").profitableAndLeastHomeOrders());
//        System.out.println(RestaurantOrders.read("orders_100.json").sumTotal());
//        System.out.println(RestaurantOrders.read("orders_100.json").customerEmails());
//        System.out.println(RestaurantOrders.read("orders_100.json").groupingByCustomerNames());
//        System.out.println(RestaurantOrders.read("orders_100.json").grupingByNamesAndTotal());
        System.out.println(RestaurantOrders.read("orders_100.json").returnCustomerMaxTotal());
        System.out.println(RestaurantOrders.read("orders_100.json").returnCustomerMinTotal());








    }
}
