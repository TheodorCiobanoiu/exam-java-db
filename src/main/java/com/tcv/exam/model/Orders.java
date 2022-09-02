package com.tcv.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Store store;
    @ManyToOne
    private Client client;
    @OneToMany
    private List<Product> products;

    public Double getOrderCost(){
        return products.stream().map(Product::getPrice).reduce(0.00, Double::sum);
    }
}
