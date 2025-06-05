package com.smartcart.smartcart_backend.service;

import com.smartcart.smartcart_backend.DTO.UserDTO;
import com.smartcart.smartcart_backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO dto);

    List<UserDTO> getAllUser();

    UserDTO getUserById(Long id);

    void deleteUser(Long id);
}
