package com.example.giuaky.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private BigDecimal totalAmount;

    private String status;


    public Order() {
        this.orderDate = new Timestamp(System.currentTimeMillis()); // Thiết lập ngày đặt hàng mặc định
        this.status = "pending"; // Trạng thái mặc định
    }

    public Order(Long id, Customer customer, BigDecimal totalAmount) {
        this.id = id;
        this.orderDate = new Timestamp(System.currentTimeMillis());
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.status = "pending";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
