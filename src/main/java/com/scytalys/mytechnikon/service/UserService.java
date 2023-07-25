package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.User;

public interface UserService extends BaseService<User, Long> {
    User findByTin(Long tin);
    User findByEmail(String email);
}
