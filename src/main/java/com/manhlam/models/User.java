package com.manhlam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private int userId;
    @Column(name = "display_name")
    @NotEmpty(message = "displayName is required")
    private String displayName; // Assuming DisplayName is not nullable

    @Column(name = "username")
    @NotEmpty(message = "username is required")
    private String username; // Assuming Username is not nullable

    @Column(name = "password")
    @NotEmpty(message = "password is required")
    private String password; // Assuming Password is not nullable

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private Boolean status;
}
