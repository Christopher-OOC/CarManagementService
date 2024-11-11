package com.appsdevelopers.springresourceserver.OrderResourceServer.repository;

import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Car;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findByCarId(int carId);

}
