package com.pavansai.Springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pavansai.Springsecurity.filters.JwtService;
import com.pavansai.Springsecurity.model.User;
import com.pavansai.Springsecurity.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authManager;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);

    }

    public String verify(User user) {

        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        // ! we need to generate a token here
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }

        return "not authenticated";
    }

}
