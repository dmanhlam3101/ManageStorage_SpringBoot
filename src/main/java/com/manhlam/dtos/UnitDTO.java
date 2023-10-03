package com.manhlam.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitDTO {
    private int unitId;
    private String unitName;
    private Boolean status;
}
