package KTTKPM_Lab02.order_management.StatePattern;

import KTTKPM_Lab02.order_management.StatePattern.model.Order;
import KTTKPM_Lab02.order_management.StatePattern.model.User;

public class index {
    public static void main(String[] args) {
        User user = new User("u123", "John Doe", "john.doe@example.com");
        System.out.println("User created: " + user);
        Order order1 = new Order("o123", user.getUserId());
        System.out.println("Order 1 created: " + order1);
        System.out.println("Order 1 status: " + order1.getStatus());
        System.out.println("Order 1 change to next state");
        order1.nextState();
        System.out.println("Order 1 status: " + order1.getStatus());
        System.out.println("Order 1 canceling:");
        order1.cancelOrder();
        System.out.println("Order 1 status: " + order1.getStatus());
        System.out.println("================================");
        Order order2 = new Order("o124", user.getUserId());
        System.out.println("Order 2 created: " + order2);
        System.out.println("Order 2 status: " + order2.getStatus());
        System.out.println("Order 2 change to next state:");
        order2.nextState();
        System.out.println("Order 2 status: " + order2.getStatus());
        System.out.println("Order 2 change to next state:");
        order2.nextState();
        System.out.println("Order 2 status: " + order2.getStatus());
        System.out.println("Order 2 change to next state:");
        order2.nextState();
        System.out.println("Order 2 status: " + order2.getStatus());
    }
}
