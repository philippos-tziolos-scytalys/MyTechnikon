package com.scytalys.mytechnikon.repository;

import com.scytalys.mytechnikon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameOrEmail(String username, String email);

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByTin(Long tin);

    User findByEmail(String email);
}
