package com.example.dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
