package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController

@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // @GetMapping
    // public ResponseEntity<List<Customers>> getAllCustomers() {
    //     try {
    //         List<Customers> customersList = customerService.getAllCustomers();
    //         return new ResponseEntity<>(customersList, HttpStatus.OK);
    //     } catch (SQLException e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("/{customerId}")
    // public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId) {
    //     try {
    //         Customers customer = customerService.getCustomerById(customerId);
    //         return new ResponseEntity<>(customer, HttpStatus.OK);
    //     } catch (SQLException e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @PostMapping
    // public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) {
    //     try {
    //         int createdCustomerId = customerService.addCustomer(customers);
    //         return new ResponseEntity<>(createdCustomerId, HttpStatus.CREATED);
    //     } catch (SQLException e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @PutMapping("/{customerId}")
    // public ResponseEntity<Void> updateCustomer(@PathVariable int customerId, @RequestBody Customers customers) {
    //     try {
    //         customers.setCustomerId(customerId); // Set the ID from the path variable
    //         customerService.updateCustomer(customers);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } catch (SQLException e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @DeleteMapping("/{customerId}")
    // public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
    //     try {
    //         customerService.deleteCustomer(customerId);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } catch (SQLException e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersFromArrayList() {
        List<Customers> customersList = customerService.getAllCustomersFromArrayList();
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<List<Customers>> addCustomersToArrayList(@RequestBody Customers customers) {
        List<Customers> updatedCustomersList = customerService.addCustomersToArrayList(customers);
        return new ResponseEntity<>(updatedCustomersList, HttpStatus.OK);
    }

    @GetMapping("/fromArrayList/{customerId}")
    public ResponseEntity<List<Customers>> getAllCustomersSortedByNameFromArrayList(@PathVariable int customerId) {
        List<Customers> sortedCustomersList = customerService.getAllCustomersSortedByNameFromArrayList();
        return new ResponseEntity<>(sortedCustomersList, HttpStatus.OK);
    }

    // public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
    //     try {
    //         // Assuming you have a method in CustomerService for retrieving transactions by customer ID
    //         List<Transactions> transactionsList = customerService.getAllTransactionsByCustomerId(customerId);
    //         return new ResponseEntity<>(transactionsList, HttpStatus.OK);
    //     } catch (SQLException e) {
    //         // Handle the exception appropriately (e.g., log it) and return an error response.
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}
