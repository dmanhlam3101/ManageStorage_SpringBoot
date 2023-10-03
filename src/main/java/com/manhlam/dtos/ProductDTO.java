package com.manhlam.dtos;

import com.manhlam.models.InputStorage;
import com.manhlam.models.Supplier;
import com.manhlam.models.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private Integer productId;
    private String productName;
    private boolean status;
    private UnitDTO unit;
    private SupplierDTO supplier;
    private List<InputStorageDTO> inputStorages;
}
