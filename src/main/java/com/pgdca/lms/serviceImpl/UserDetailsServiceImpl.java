package com.pgdca.lms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgdca.lms.LibraryManagementSystemApplication;
import com.pgdca.lms.model.Role;
import com.pgdca.lms.model.User;
import com.pgdca.lms.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
    	
    	log.info(this.getClass() + this.toString() +"");
    	
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
        	log.info("DB Role"+role.getName());
        	grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
    	log.info("User Role");
        Collection<Role> userRoles = user.getRoles();
    	for (Role  userRole : userRoles) {
			log.info(userRole.getName());
		}
    	

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
