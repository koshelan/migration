package com.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    private LocalDateTime dat;
    private String productName;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id",referencedColumnName = "id",nullable = false)
    private Customer customerId;
    private int amount;

    public Orders(Customer customerId, String productName,  int amount) {
        this.productName = productName;
        this.customerId = customerId;
        this.amount = amount;
    }
}
