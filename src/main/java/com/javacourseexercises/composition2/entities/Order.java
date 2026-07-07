package com.javacourseexercises.composition2.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javacourseexercises.composition2.entities.enums.OrderStatus;

public class Order {
    private LocalDateTime  moment;
    private OrderStatus status;

    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    Order(){}

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public Client getClient() {
        return client;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public double total(){
        double total = 0;

        for(OrderItem item : orderItems){
            int quantity = item.getQuantity();
            double price = item.getPrice();
            total += quantity * price;
        }

        return total;
    }
}
