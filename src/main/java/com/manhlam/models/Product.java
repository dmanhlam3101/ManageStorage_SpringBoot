package com.manhlam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Table(name = "product")
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer productId;


    @Column(name = "product_name")
    @NotEmpty(message = "productName is required")
    private  String productName;

    @ManyToOne
    @JoinColumn(name = "unit")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "supplier")
    private  Supplier supplier;

    @Column(name = "status")
    private   boolean status;

    @ManyToMany(mappedBy = "products")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Collection<InputStorage> inputStorages;
}
