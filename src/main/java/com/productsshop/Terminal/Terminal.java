package com.productsshop.Terminal;

import com.productsshop.dto.UserDto;
import com.productsshop.entities.Product;
import com.productsshop.entities.User;
import com.productsshop.io.JsonParser;
import com.productsshop.services.CategoryService;
import com.productsshop.services.ProductService;
import com.productsshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;
    private final JsonParser jsonParser;

    @Autowired //!!! Important
    public Terminal(CategoryService categoryService, ProductService productService, UserService userService, JsonParser jsonParser) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.jsonParser = jsonParser;
    }

    @Override
    public void run(String... strings) throws Exception {
        importUsers();
    }

    public void importUsers() {
        UserDto[] users = this.jsonParser.getObject(UserDto[].class, "/files/in/users.json");
        for (UserDto user : users) {
            this.userService.save(user);
        }

    }
}
