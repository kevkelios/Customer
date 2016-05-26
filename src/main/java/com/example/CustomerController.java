package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CustomerController {
    HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
    private long id = 1;

    //to get all populated customers
    @RequestMapping("/customer")
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
    //insert new customer to hashmap
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void insertCustomer(@RequestBody Customer customer) {
        customer.setId(id);
        customerMap.put(String.valueOf(id++), customer);
    }
    //remove customer according to id pathVariable
    @RequestMapping(value ="/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id) {
        customerMap.remove(id);
    }
    //get customer according to id pathVariable
    @RequestMapping(value="/customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerMap.get(id);
    }
}