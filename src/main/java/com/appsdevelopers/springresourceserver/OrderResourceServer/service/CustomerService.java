package com.appsdevelopers.springresourceserver.OrderResourceServer.service;

import com.appsdevelopers.springresourceserver.OrderResourceServer.model.dto.CarDto;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.dto.CustomerDto;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Car;
import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Customer;
import com.appsdevelopers.springresourceserver.OrderResourceServer.repository.CarRepository;
import com.appsdevelopers.springresourceserver.OrderResourceServer.repository.CustomerRepository;
import com.appsdevelopers.springresourceserver.OrderResourceServer.util.EntityCheckerUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CarRepository carRepository;
    private ModelMapper modelMapper;
    private EntityCheckerUtil entityCheckerUtil;

    public CustomerService(
            CustomerRepository customerRepository,
            CarRepository carRepository,
            ModelMapper modelMapper,
            EntityCheckerUtil entityCheckerUtil
    ) {

        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.entityCheckerUtil = entityCheckerUtil;

    }

    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = modelMapper.map(customerDto, Customer.class);

        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);

    }

    public CarDto createACar(CarDto carDto) {

        Car car = modelMapper.map(carDto, Car.class);

        return modelMapper.map(carRepository.save(car), CarDto.class);

    }

    public CarDto getCar(int carId) {

        Car car = entityCheckerUtil.checkIfCarExists(carId);

        return modelMapper.map(car, CarDto.class);

    }

    public CustomerDto customerBuysACar(int customerId, int carId) {

        Customer customer = entityCheckerUtil.checkIfCustomerExists(customerId);
        Car car = entityCheckerUtil.checkIfCarExists(carId);

        customer.getCustomerCars().add(car);

        Customer saved = customerRepository.save(customer);

        return modelMapper.map(saved, CustomerDto.class);
    }

    public CarDto updateCarInfo(int carId, CarDto carDto) {

        Car car = entityCheckerUtil.checkIfCarExists(carId);

        carDto.setCarId(car.getCarId());

        if (carDto.getCarBrand() != null) {
            car.setCarBrand(carDto.getCarBrand());
        }
        if (carDto.getCarName() != null) {
            car.setCarName(carDto.getCarName());
        }
        if (carDto.getModelYear() != null) {
            car.setModelYear(carDto.getModelYear());
        }
        if (carDto.getCarPrice() != null) {
            car.setCarPrice(carDto.getCarPrice());
        }

        return modelMapper.map(carRepository.save(car), CarDto.class);
    }

}
