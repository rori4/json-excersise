package com.productsshop.servicesImpl;

import com.productsshop.dto.UserDto;
import com.productsshop.entities.User;
import com.productsshop.io.ModelParser;
import com.productsshop.repositories.UserRepository;
import com.productsshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserDto userDto) {
        User user = ModelParser.getInstance().map(userDto, User.class);
        this.userRepository.saveAndFlush(user);
    }
}
