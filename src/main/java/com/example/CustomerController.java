package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CustomerController {
    //default capacity is 16, declaring id as key, customer object as value
    HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
    //initializing value
    private long id = 1;

    //to get all populated customers
    @RequestMapping("/customer")
    public List<Customer> getAllCustomers() {
        //returns array list of hashmap values
        return new ArrayList<>(customerMap.values());
    }
    //insert new customer to hashmap
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void insertCustomer(@RequestBody Customer customer) {
        //set id in customer object
        customer.setId(id);
        //place in hashmap
        customerMap.put(String.valueOf(id++), customer);
    }
    //remove customer according to id pathVariable ->
    // @PathVariable ties the given string to the id in the path within brackets
    @RequestMapping(value ="/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id) {
        //remove customer based on given {id}
        customerMap.remove(id);
    }
    //get customer according to id pathVariable
    @RequestMapping(value="/customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        //returns customer based on given {id}
        return customerMap.get(id);
    }
}