package com.appsdevelopers.springresourceserver.OrderResourceServer.model.dto;

import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Car;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class CustomerDto {

    private int customerId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    List<Car> customerCars = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(customerId);
    }
}
