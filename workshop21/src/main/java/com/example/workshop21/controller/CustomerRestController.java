package com.example.workshop21.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop21.model.Customer;
import com.example.workshop21.model.Order;
import com.example.workshop21.repo.CustomerRepo;

@RestController
@RequestMapping(path="/api")
public class CustomerRestController {
    
    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(value="offset", defaultValue = "0") Integer offset,
     @RequestParam(value="limit", defaultValue = "5") Integer limit) {
        List<Customer> listCustomer = new ArrayList<Customer>();
        listCustomer = customerRepo.listAll(limit, offset);

        if (listCustomer.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(listCustomer, HttpStatus.OK);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer result = new Customer();
        result = customerRepo.getCustomerById(id);

        if (result == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/customer/{id}/orders")
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable String id) {
        List<Order> resultList = new ArrayList<Order>();
        resultList = customerRepo.getOrderListByCustomerId(id);
        List<Order> emptyArr = new ArrayList<>();

        if (resultList.isEmpty()) {
            return new ResponseEntity<>(emptyArr, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resultList, HttpStatus.OK);
        }

    }




}
