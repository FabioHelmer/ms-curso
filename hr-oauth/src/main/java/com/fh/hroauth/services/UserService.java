package com.fh.hroauth.services;

import com.fh.hroauth.entities.User;
import com.fh.hroauth.feignclients.UserFeignClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email) {

        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found " + email);
            throw new IllegalArgumentException("email not found");
        }

        log.info("Email found " + email);
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found " + email);
            throw new UsernameNotFoundException("email not found");
        }

        log.info("Email found " + email);
        return user;
    }
}
