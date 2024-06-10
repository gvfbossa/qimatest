package com.qima.qimatest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qima.qimatest.controller.AuthController;
import com.qima.qimatest.controller.CategoryController;
import com.qima.qimatest.controller.ProductController;
import com.qima.qimatest.service.CategoryService;
import com.qima.qimatest.service.ProductService;
import com.qima.qimatest.service.TokenService;

@SpringBootTest
class QimatestApplicationTests {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthController authController;
	@Autowired
	private ProductController productController;
	@Autowired
	private CategoryController categoryController;

	@Test
	void contextLoads() {
		assertNotNull(categoryService);
		assertNotNull(productService);
		assertNotNull(tokenService);
		assertNotNull(authController);
		assertNotNull(productController);
		assertNotNull(categoryController);
	}

}
