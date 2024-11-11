package com.appsdevelopers.springresourceserver.OrderResourceServer.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class CarDto {

    private int carId;
    private String carName;
    private String carBrand;
    private Integer modelYear;
    private Double carPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return carId == carDto.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carId);
    }
}
