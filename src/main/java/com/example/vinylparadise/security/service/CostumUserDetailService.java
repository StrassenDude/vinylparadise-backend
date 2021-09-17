package com.example.vinylparadise.security.service;

import com.example.vinylparadise.model.User;
import com.example.vinylparadise.repository.UserRepository;
import com.example.vinylparadise.security.config.CostumUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CostumUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CostumUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        if (null == user) { throw new UsernameNotFoundException(s); }

        return new CostumUserDetails(user);
    }
}
