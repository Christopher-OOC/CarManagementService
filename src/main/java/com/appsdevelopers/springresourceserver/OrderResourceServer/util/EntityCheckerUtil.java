package com.appsdevelopers.springresourceserver.OrderResourceServer.util;

import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Car;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Customer;
import com.appsdevelopers.springresourceserver.OrderResourceServer.repository.CarRepository;
import com.appsdevelopers.springresourceserver.OrderResourceServer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class EntityCheckerUtil {

    private CustomerRepository customerRepository;
    private CarRepository carRepository;

    public EntityCheckerUtil(
            CustomerRepository customerRepository,
            CarRepository carRepository

    ) {
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
    }

    public Customer checkIfCustomerExists(int customerId) {

        Customer customer = customerRepository.findByCustomerId(customerId);

        if (customer == null) {
            throw new RuntimeException("No such customer found!!!");
        }

        return customer;
    }

    public Car checkIfCarExists(int carId) {

        Car car = carRepository.findByCarId(carId);

        if (car == null) {
            throw new RuntimeException("No such car found!!!");
        }

        return car;
    }

}
