package com.appsdevelopers.springresourceserver.OrderResourceServer.controllers;

import com.appsdevelopers.springresourceserver.OrderResourceServer.model.dto.CarDto;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.dto.CustomerDto;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Car;
import com.appsdevelopers.springresourceserver.OrderResourceServer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/services")
public class CustomerApiController {

    private CustomerService customerService;
    private ModelMapper modelMapper;

    public CustomerApiController(
            CustomerService customerService,
            ModelMapper modelMapper
    ) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) {

        CustomerDto customer = customerService.createCustomer(customerDto);

        return ResponseEntity.created(null).body(customer);
    }

    @PostMapping("/cars")
    public ResponseEntity<?> createCar(@RequestBody CarDto carDto) {

        CarDto car = customerService.createACar(carDto);

        return ResponseEntity.created(null).body(car);
    }

    @PutMapping("/cars/{carId}")
    public ResponseEntity<?> updateCar(
            @PathVariable("carId") int carId,
            @RequestBody CarDto carDto) {

        CarDto returnValue = customerService.updateCarInfo(carId, carDto);

        return ResponseEntity.ok(returnValue);
    }

    @GetMapping("/cars/{carId}")
    public ResponseEntity<?> getCar(
            @PathVariable("carId") int carId) {

        CarDto returnValue = customerService.getCar(carId);

        return ResponseEntity.ok(returnValue);
    }

    @PostMapping("/buy-car/{customerId}/{carId}")
    public ResponseEntity<?> buyCar(
            @PathVariable("customerId") int customerId,
            @PathVariable("carId") int carId
    ) {

        CustomerDto customerDto = customerService.customerBuysACar(customerId, carId);

        return ResponseEntity.ok(customerDto);
    }
}
