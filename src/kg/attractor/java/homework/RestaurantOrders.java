package kg.attractor.java.homework;

import com.google.gson.Gson;

import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    // Наполните этот класс решением домашнего задания.
    // Вам необходимо создать все необходимые методы
    // для решения заданий из домашки :)
    // вы можете добавлять все необходимые imports
    //
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
    public List<Order> profitableAndLeastHomeOrders(){
        System.out.println("Заказ на дом который был наиболее прибыльным: ");
        List<Order> orders1 = new ArrayList<>();
        orders1.add(homeDeliveryOrders().stream()
                .max(Comparator.comparingDouble(Order::getTotal)).get());
        System.out.println("Заказ на дом который был наименее прибыльным: ");
        orders1.add(homeDeliveryOrders().stream()
                .min(Comparator.comparingDouble(Order::getTotal)).get());
        return orders1;
    }






}
