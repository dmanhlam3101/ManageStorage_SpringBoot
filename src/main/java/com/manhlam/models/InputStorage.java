package com.manhlam.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "input_storage")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputStorage {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private int inputId;

    @ManyToMany
    @JoinTable(
            name = "input_storage_product", // Corrected table name
            joinColumns = @JoinColumn(name = "input_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @Column(name = "quantity")
    private Integer quantity; // Using Integer for nullable properties

    @Column(name = "date_input")
    @NotNull
    private Date dateInput; // Using java.util.Date for DateTime

    @Column(name = "input_price")
    private Double inputPrice; // Using Double for nullable properties

    @Column(name = "output_price")
    private Double outputPrice; // Using Double for nullable properties

    @Column(name = "status")
    private Boolean status; // Using Boolean for nullable properties


}
