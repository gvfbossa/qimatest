package com.qima.qimatest.config;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.qima.qimatest.model.Category;
import com.qima.qimatest.model.Product;
import com.qima.qimatest.service.CategoryService;
import com.qima.qimatest.service.ProductService;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private final ProductService productService;
    @Autowired
    private final CategoryService categoryService;

    private List<String> categories = Arrays.asList("Consoles", "Games", "Accessories");

    public DataLoader(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (String category : categories) {
            if (categoryService.findByName(category) == null)
                categoryService.save(new Category(category));
        }

        initializeProducts();
    }

    private void initializeProducts() {
        initializeProducts("Playstation 5", "Last Gen Sony Console", new BigDecimal("499.99"), categoryService.findByName(categories.get(0)), null, true);
        initializeProducts("Playstation 4", "Version 4 Sony Console", new BigDecimal("399.99"), categoryService.findByName(categories.get(0)), null, true);
        initializeProducts("XBox Series S", "Last Gen Microsoft Console", new BigDecimal("459.99"), categoryService.findByName(categories.get(0)), null, true);
        initializeProducts("Nintendo Switch", "Last Gen Nintendo Console", new BigDecimal("499.99"), categoryService.findByName(categories.get(0)), null, true);

        initializeProducts("God of War", "Kratos fights the Nords", new BigDecimal("49.99"), categoryService.findByName(categories.get(1)), null, true);
        initializeProducts("The Last of Us", "Best Survival Game of all times", new BigDecimal("39.99"), categoryService.findByName(categories.get(1)), null, true);
        initializeProducts("Hogwarts Legacy", "Become a Hogwarts Wizard", new BigDecimal("69.99"), categoryService.findByName(categories.get(1)), null, true);
        initializeProducts("Zelda, Breath of the Wild", "The name of the protagonist is Link, not Zelda", new BigDecimal("39.99"), categoryService.findByName(categories.get(1)), null, true);

        initializeProducts("Dual Sense Control", "PS5 Control", new BigDecimal("199.99"), categoryService.findByName(categories.get(2)), null, true);
        initializeProducts("Dual Shock Control", "PS4 Control", new BigDecimal("89.99"), categoryService.findByName(categories.get(2)), null, true);
        initializeProducts("Wireless Control", "MS XBoxSS Control", new BigDecimal("79.99"), categoryService.findByName(categories.get(2)), null, true);
        initializeProducts("PowerA Joy-Con", "Nintendo Switch Control", new BigDecimal("69.99"), categoryService.findByName(categories.get(2)), null, true);
    }

    private void initializeProducts(String name, String desc, BigDecimal price, Category cat, String catPath, boolean available) {
        if (productService.findByName(name) == null)
            productService.save(new Product(name, desc, price, cat, catPath, available));
    }

    
}
