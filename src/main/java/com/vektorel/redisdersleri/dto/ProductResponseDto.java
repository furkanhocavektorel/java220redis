package com.vektorel.redisdersleri.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

}
