package com.example.workshop21.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.workshop21.model.Customer;
import com.example.workshop21.model.Order;

@Repository
public class CustomerRepo {
    
    private final String listAllSQL = "select * from customers";
    private final String findByIdSQL = "select * from customers where id = ?";
    private final String orderListSQL = "select * from orders where customer_id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> listAll(Integer limit, Integer offset) {
        List<Customer> resultList = new ArrayList<Customer>();
        resultList = jdbcTemplate.query(listAllSQL + " LIMIT " + limit + " OFFSET " + offset, BeanPropertyRowMapper.newInstance(Customer.class));
        return resultList;

    }

    public Customer getCustomerById(String id) {
        Customer result = new Customer();
        result = jdbcTemplate.queryForObject(findByIdSQL, BeanPropertyRowMapper.newInstance(Customer.class), id);
        return result;
    }

    public List<Order> getOrderListByCustomerId(String customerId) {
        List<Order> resultList = new ArrayList<Order>();
        resultList = jdbcTemplate.query(orderListSQL, BeanPropertyRowMapper.newInstance(Order.class), customerId);
        return resultList;
    } 


}
