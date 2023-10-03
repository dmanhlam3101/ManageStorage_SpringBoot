package com.manhlam.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
@Entity
@Table(name = "supplier")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY

    )
    private int supplierId;

    @Column(name = "display_name")
    @NotEmpty(message = "Display Name is required")
    private String displayName; // Assuming DisplayName is not nullable

    @Column(name = "address")
    @NotEmpty(message = "address is required")
    private String address; // Assuming Address is not nullable

    @Column(name = "phone")
    @NotEmpty(message = "phone is required")
    private String phone; // Assuming Phone is not nullable

    @Column(name = "email")
    @NotEmpty(message = "email is required")
    private String email; // Assuming Email is not nullable

    @Column(name = "more_info")
    private String moreInfo; // Assuming MoreInfo is  nullable

    @Column(name = "contract_date")
    @NotNull
    private Date contractDate; // Using java.util.Date for DateTime
    @Column(name = "status")
    private Boolean status; // Using Boolean for nullable properties
}
