package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.User;
import com.scytalys.mytechnikon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    private final UserRepository userRepository;

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

    @Override
    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username,email);
    }
}
