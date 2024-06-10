package com.qima.qimatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qima.qimatest.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByName(String name);
	
}
