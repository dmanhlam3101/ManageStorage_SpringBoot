package com.manhlam.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "unit")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int unitId;

    @Column(name = "unit_name")
    @NotNull
    private String unitName; // Assuming UnitName is not nullable

    @Column(name = "status")
    private Boolean status; // Using Boolean for nullable properties
}
