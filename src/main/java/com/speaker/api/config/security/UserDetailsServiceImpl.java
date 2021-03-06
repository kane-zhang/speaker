package com.speaker.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
/*    @Autowired
    private UserRepository userRepository;*/
 
    @Override
    public UserDetails loadUserByUsername(String username) {
/*        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }*/
        return new UserPrincipal();
    }
}
