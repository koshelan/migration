package com.example.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Repo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> productsByUserName(String name) {
        var query = entityManager.createQuery(
                "select o.productName from Orders o join o.customerId c where lower(c.name)= :name",String.class);
        query.setParameter("name",name);
        return query.getResultList();
    }

    @Transactional
    public void persistC(Customer customer){
                entityManager.persist(customer);
    }

    @Transactional
    public void persistO(Orders order){
        entityManager.persist(order);
    }

}
