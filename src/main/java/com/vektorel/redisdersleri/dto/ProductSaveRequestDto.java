package com.vektorel.redisdersleri.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequestDto {
    private String name;
    private String description;
    private Double price;
    private Integer stock;

}
