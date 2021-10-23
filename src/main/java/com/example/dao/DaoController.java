package com.example.dao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class DaoController {

    private Repo repository;

    public DaoController(Repo repository) {
        this.repository = repository;
    }

    @GetMapping("/fetch-product")
    public List<String> getProductsByUserName(@RequestParam String name) {
        System.out.println(name);
        return repository.productsByUserName(name);
    }

    @GetMapping("/fetch-product/h")
    public String getProductsByUserName() {
        var customers = new ArrayList<Customer>(Arrays.asList(
                new Customer("Ivan", "Ivanov", 25, "123456"),
                new Customer("Petr", "Petrov", 13, "654321"),
                new Customer("aLexey", "Ivanov", 27, "223456"),
                new Customer("Alexey", "Aksyonov", 70, "78964")
        ));

        customers.forEach(c -> repository.persistC(c));

        repository.persistO(new Orders(customers.get(3), "bread", 2));
        repository.persistO(new Orders(customers.get(3), "milk", 1));
        repository.persistO(new Orders(customers.get(2), "bread", 2));
        repository.persistO(new Orders(customers.get(0), "orange", 10));

        return "ok";
    }

}
