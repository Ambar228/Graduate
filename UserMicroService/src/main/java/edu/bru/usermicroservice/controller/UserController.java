package edu.bru.usermicroservice.controller;

import edu.bru.usermicroservice.dto.UserAuthenticationDto;
import edu.bru.usermicroservice.dto.UserRegistrationDto;
import edu.bru.usermicroservice.model.User;
import edu.bru.usermicroservice.repository.UserRepository;
import edu.bru.usermicroservice.security.JwtUtil;
import edu.bru.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserService userService;

    private final JwtUtil jwtUtil;


    @PostMapping("/authentication")
    public ResponseEntity<String> authenticate(@RequestBody UserAuthenticationDto user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getNumberPhone(), user.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getNumberPhone());

        if (userDetails == null) {
            throw new BadCredentialsException("Not Valid email or password");
        }

        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
    }

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.registration(userRegistrationDto);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRegistrationDto.getNumberPhone(), userRegistrationDto.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userRegistrationDto.getNumberPhone());

        if (userDetails == null) {
            throw new BadCredentialsException("Not Valid email or password");
        }

        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
    }
}
