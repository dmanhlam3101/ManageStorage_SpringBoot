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
public class OutputStorageResponseDTO {
    private int outputId;
    private Integer quantity;
    private Date dateOutput;
    private Boolean status;
    private Set<CustomerDAO> customer;
    private Set<ProductDTO> product;
}
