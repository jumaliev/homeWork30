package kg.attractor.java;

import kg.attractor.java.homework.RestaurantOrders;
import kg.attractor.java.homework.domain.Order;

public class Main {

    public static void main(String[] args) {
        var orders = RestaurantOrders.read("orders_100.json").getOrders();
//        var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
        orders.stream().map(order -> order.toString()).forEach(System.out::println);

    }
}
