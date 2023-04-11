package edu.bru.usermicroservice.service;

import edu.bru.usermicroservice.dto.UserRegistrationDto;

public interface UserService {
    void registration(UserRegistrationDto userRegistrationDto);
}
