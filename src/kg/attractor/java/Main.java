package kg.attractor.java;

import kg.attractor.java.homework.RestaurantOrders;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String menu = "Меню:\n" +
                "Введите 1 чтобы вывезти все заказы.\n" +
                "Введите 2 чтобы вывезти на экран наиболее прибыльные заказы.\n" +
                "Введите 3 чтобы вывезти на экран наименее прибыльные заказы.\n" +
                "Введите 4 чтобы вывезти на экран заказы у которых доставка на дом.\n" +
                "Введите 5 чтобы вывезти на экран заказы наиболее прибыльные и намиенее прибыльные на дом.\n" +
                "Введите 6 чтобы вывезти заказы с общей суммой между максимальной и минимальной суммой.\n" +
                "Введите 7 чтобы вывезти общую стоимость всез заказов.\n" +
                "Введите 8 чтобы вывезти отсортированный список уникальных адресов электронной почты.\n" +
                "Введите 9 чтобы получить сгруппированный список по имени заказчика.\n" +
                "Введите 10 чтобы вывезти уникальный список заказчиков и их общую сумму заказа.\n" +
                "Ввекдите 11 чтобы вывезти клиента с максимаьлноый суммой заказов.\n" +
                "Ввдеите 12 чтобы вывезти клиента с минимальной суммой заказов.\n" +
                "Введите 13 чтобы получить список заказов и с их количеством.\n" +
                "Введите 0 чтобы выйти!";
        System.out.print(menu);

        while (true) {
            int userChoise = new Scanner(System.in).nextInt();
            switch (userChoise) {
                case 1:
                    RestaurantOrders.read("orders_100.json").printOrders();
                    System.out.println(menu);
                    break;
                case 2:
                    System.out.print("Сколько заказов вывезти?");
                    int userChoiseForPrint = new Scanner(System.in).nextInt();
                    System.out.println(RestaurantOrders.read("orders_100.json").ordersLargestAmounts(userChoiseForPrint));
                    System.out.println(menu);
                    break;
                case 3:
                    System.out.print("Сколько заказов вывезти?");
                    int userChoiseForPrint2 = new Scanner(System.in).nextInt();
                    System.out.println(RestaurantOrders.read("orders_100.json").ordersSmallestAmounts(userChoiseForPrint2));
                    System.out.println(menu);
                    break;
                case 4:
                    System.out.println(RestaurantOrders.read("orders_100.json").homeDeliveryOrders());
                    System.out.println(menu);
                    break;
                case 5:
                    System.out.println(RestaurantOrders.read("orders_100.json").profitableAndLeastHomeOrders());
                    System.out.println(menu);
                    break;
                case 6:
                    System.out.println(RestaurantOrders.read("orders_100.json").returnOrdersBetweenMinTotalAndMaxTotal());
                    System.out.println(menu);
                    break;
                case 7:
                    System.out.println(RestaurantOrders.read("orders_100.json").sumTotal());
                    System.out.println(menu);
                    break;
                case 8:
                    System.out.println(RestaurantOrders.read("orders_100.json").customerEmails());
                    System.out.println(menu);
                    break;
                case 9:
                    System.out.println(RestaurantOrders.read("orders_100.json").groupingByCustomerNames());
                    System.out.println(menu);
                    break;
                case 10:
                    System.out.println(RestaurantOrders.read("orders_100.json").grupingByNamesAndTotal());
                    System.out.println(menu);
                    break;
                case 11:
                    System.out.println(RestaurantOrders.read("orders_100.json").returnCustomerMaxTotal());
                    System.out.println(menu);
                    break;
                case 12:
                    System.out.println(RestaurantOrders.read("orders_100.json").returnCustomerMinTotal());
                    System.out.println(menu);
                    break;
                case 13:
                    RestaurantOrders.read("orders_100.json").groupingProductsByTotalQuantity().entrySet().stream().forEach(System.out::println);
                    System.out.println(menu);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неправильная команда, введите еще раз!");
                    System.out.println(menu);
                    break;
            }
        }


    }
}
