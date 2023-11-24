package com.manhlam.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private Integer productId;
    private String productName;
    private boolean status;
    private int unitId;
    private int supplierId;
}
