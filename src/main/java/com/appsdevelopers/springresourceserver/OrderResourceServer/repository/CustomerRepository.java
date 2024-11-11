package com.appsdevelopers.springresourceserver.OrderResourceServer.repository;

import com.appsdevelopers.springresourceserver.OrderResourceServer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(int customerId);

}
