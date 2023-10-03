package com.manhlam.dtos;

import com.manhlam.models.OutputStorage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDAO {
    private int customerId;


    private String displayName;
    private String address;

    private String phone;

    private String email;

    private String moreInfo;

    private Date contractDate;
    private Boolean status;
    private Collection<OutputStorage> outputStorages;
}
