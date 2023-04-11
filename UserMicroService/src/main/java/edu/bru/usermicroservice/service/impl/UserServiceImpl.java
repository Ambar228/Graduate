package edu.bru.usermicroservice.service.impl;

import edu.bru.usermicroservice.converter.UserDtoConverter;
import edu.bru.usermicroservice.dto.UserRegistrationDto;
import edu.bru.usermicroservice.model.User;
import edu.bru.usermicroservice.repository.UserRepository;
import edu.bru.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    @Override
    public void registration(UserRegistrationDto userRegistrationDto) {
        User user = userDtoConverter.convertFromDto(userRegistrationDto);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String numberPhone) throws UsernameNotFoundException {
        User user = userRepository.findByNumberPhone(numberPhone);
        return null;
    }
}
