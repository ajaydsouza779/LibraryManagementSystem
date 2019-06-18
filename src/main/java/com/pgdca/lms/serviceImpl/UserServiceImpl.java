package com.pgdca.lms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pgdca.lms.model.Role;
import com.pgdca.lms.model.User;
import com.pgdca.lms.repository.RoleRepository;
import com.pgdca.lms.repository.UserRepository;
import com.pgdca.lms.service.UserService;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
     
        userRepository.save(user);
    }

	@Override
	public void savePublic(User user) {
	    //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	     
        Role role = roleRepository.findRoleByName("ROLE_PUBLIC"); 
        if(role != null ) user.setRoles(Arrays.asList(role));
        
        this.save(user);
        
        //userRepository.save(user);
		
	}
    
	@Override
	public void saveLibrarian(User user) {
	    //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	     
        Role role = roleRepository.findRoleByName("ROLE_LIB"); 
         if(role != null ) user.setRoles(Arrays.asList(role));
		 
        this.save(user);
         
        //userRepository.save(user);
		
	}
}