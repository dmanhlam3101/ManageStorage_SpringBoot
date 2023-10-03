package com.manhlam.dtos;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private int supplierId;


    private String displayName;


    private String address;

    private String phone;


    private String email;


    private String moreInfo;

    private Date contractDate;
    private Boolean status;
}
