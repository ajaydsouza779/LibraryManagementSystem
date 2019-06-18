package com.pgdca.lms.service;

import com.pgdca.lms.model.User;

public interface UserService {
    void save(User user);
    
    void saveLibrarian(User user);

    User findByUsername(String username);

	void savePublic(User user);
}