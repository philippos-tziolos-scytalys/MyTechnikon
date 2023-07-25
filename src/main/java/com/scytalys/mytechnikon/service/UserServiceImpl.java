package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.User;
import com.scytalys.mytechnikon.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    private UserRepository userRepository;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByTin(Long tinNumber) {
        return (userRepository.findByTin(tinNumber));
    }

    @Override
    public User findByEmail(String email) {
        return (userRepository.findByEmail(email));
    }
}
