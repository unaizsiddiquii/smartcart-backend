package com.smartcart.smartcart_backend.service.impl;

import com.smartcart.smartcart_backend.DTO.UserDTO;
import com.smartcart.smartcart_backend.exception.ResourceNotFoundException;
import com.smartcart.smartcart_backend.mapper.UserMapper;
import com.smartcart.smartcart_backend.model.User;
import com.smartcart.smartcart_backend.repository.UserRepository;
import com.smartcart.smartcart_backend.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO dto) {
        User user = UserMapper.toEntity(dto);
        user.setRole("USER");
        userRepository.save(user);
        return UserMapper.toDto(user);

    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toDto).toList();

    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found with id " + id));
        return UserMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found with id " + id));
        userRepository.deleteById(id);

    }
}
