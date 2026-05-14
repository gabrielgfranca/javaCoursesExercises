package com.javacourseexercises.composition1.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javacourseexercises.composition1.entities.enums.OrderStatus;

public class Order {
    private Date moment;
    private OrderStatus status;

    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    Order(){}

    public Order(Date moment, OrderStatus status, List<OrderItem> orderItems, Client client) {
        this.moment = moment;
        this.status = status;
        this.orderItems = orderItems;
        this.client = client;
    }

    public Date getMoment() {
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

    public void setMoment(Date moment) {
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
        return orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
    }
}
