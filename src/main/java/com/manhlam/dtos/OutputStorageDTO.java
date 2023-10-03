package com.manhlam.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutputStorageDTO {
    private int outputId;
    private Set<Integer> customerId;
    private Set<Integer> productId;
    private Integer quantity;
    private Date dateOutput;
    private Boolean status;
}
