package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CustomerController {
    HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
    private long id = 1;

    @RequestMapping("/customer")
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void insertCustomer(@RequestBody Customer customer) {
        customer.setId(id);
        customerMap.put(String.valueOf(id++), customer);
    }
    @RequestMapping(value ="/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id) {
        customerMap.remove(id);
    }
    @RequestMapping(value="/customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerMap.get(id);
    }
}