package com.qima.qimatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qima.qimatest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Product findByName(String name);
}
