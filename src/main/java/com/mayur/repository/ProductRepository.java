package com.mayur.repository;

import org.springframework.data.repository.CrudRepository;

import com.mayur.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
