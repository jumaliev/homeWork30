package kg.attractor.java.homework;

import com.google.gson.Gson;

import kg.attractor.java.homework.domain.Customer;
import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class RestaurantOrders {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private List<Order> orders;

    private RestaurantOrders(String fileName) {
        var filePath = Path.of("data", fileName);
        Gson gson = new Gson();
        try {
            orders = List.of(gson.fromJson(Files.readString(filePath), Order[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RestaurantOrders read(String fileName) {
        var ro = new RestaurantOrders(fileName);
        ro.getOrders().forEach(Order::calculateTotal);
        return ro;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    public void printOrders() {
        System.out.println(orders);
    }

    public List<Order> ordersLargestAmounts(int i) {
        return orders.stream()
                .sorted(((o1, o2) -> Double.compare(o2.getTotal(), o1.getTotal())))
                .limit(15)
                .collect(Collectors.toList());
    }

    public List<Order> ordersSmallestAmounts(int i) {
        return orders.stream()
                .sorted(((o1, o2) -> Double.compare(o1.getTotal(), o2.getTotal())))
                .limit(15)
                .collect(Collectors.toList());
    }

    public List<Order> homeDeliveryOrders() {
        return orders.stream()
                .filter(Order::isHomeDelivery)
                .collect(Collectors.toList());
    }

    public List<Order> profitableAndLeastHomeOrders() {
        List<Order> orders1 = new ArrayList<>();
        orders1.add(homeDeliveryOrders().stream()
                .max(Comparator.comparingDouble(Order::getTotal)).get());
        orders1.add(homeDeliveryOrders().stream()
                .min(Comparator.comparingDouble(Order::getTotal)).get());
        return orders1;
    }

    public List<Order> returnOrdersBetweenMinTotalAndMaxTotal() {
        return orders.stream()
                .dropWhile(order -> order.getTotal() > profitableAndLeastHomeOrders().get(1).getTotal())
                .takeWhile(order -> order.getTotal() < profitableAndLeastHomeOrders().get(0).getTotal())
                .collect(Collectors.toList());
    }

    public double sumTotal() {
        return orders.stream().mapToDouble(Order::getTotal).sum();
    }

    public Set<String> customerEmails() {
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .collect(Collectors.toSet());
    }

    public Map<Customer, List<Order>> groupingByCustomerNames() {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    public Map<Customer, Double> grupingByNamesAndTotal() {
        return groupingByCustomerNames().entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), e -> e.getValue().stream().mapToDouble(Order::getTotal).sum()));
    }

    public Customer returnCustomerMaxTotal() {
        return groupingByCustomerNames().entrySet()
                .stream()
                .max(Comparator.comparingDouble(v -> v.getValue().stream().mapToDouble(Order::getTotal).sum()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Customer returnCustomerMinTotal() {
        return groupingByCustomerNames().entrySet()
                .stream()
                .min(Comparator.comparingDouble(v -> v.getValue().stream().mapToDouble(Order::getTotal).sum()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<String, Integer> groupingProductsByTotalQuantity() {
        return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getAmount)));
    }


}
