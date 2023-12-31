package com.manhlam.dtos;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputStorageDTO {
    private int inputId;
    private Set<Integer> productId;
    private Integer quantity;
    private Date dateInput;
    private Double inputPrice;
    private Double outputPrice;
    private Boolean status;
}
