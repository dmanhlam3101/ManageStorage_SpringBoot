package com.manhlam.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "output_storage")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutputStorage {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private int outputId;

    @ManyToMany
    @JoinTable(
            name = "output_storage_customer", // Specify the name of the join table
            joinColumns = @JoinColumn(name = "output_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;
    @ManyToMany
    @JoinTable(
            name = "output_storage_product", // Specify the name of the join table
            joinColumns = @JoinColumn(name = "output_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @Column(name = "quantity")
    private Integer quantity; // Using Integer for nullable properties

    @Column(name = "date_output")
    private Date dateOutput; // Using java.util.Date for DateTime

    @Column(name = "status")
    private Boolean status; // Using Boolean for nullable properties

}
