package com.manhlam.dtos;


import com.manhlam.models.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StorageDTO {
    private Integer productId ;
    private String productName ;
    private Integer quantity ;
    private String unitName ;

    private Supplier supplier;

}
