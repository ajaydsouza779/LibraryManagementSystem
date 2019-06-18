package com.pgdca.lms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.pgdca.auth.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
	private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/registration", "/*.css/**", "/*.jpg/**", "/*.png/**","/*.js").permitAll()
                .antMatchers("/", "/dashboardV2", "/homepage").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN') or hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").successHandler(customLoginSuccessHandler).permitAll()
                //.defaultSuccessUrl("/homePage")
                //.failureUrl("/loginPage?error")
                //.usernameParameter("username").passwordParameter("password")	
                .and()
      
            .logout()
                .permitAll();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
    
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
    	authenticationMgr.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        
		/*
		 * authenticationMgr.inMemoryAuthentication()
		 * .withUser("jduser").password("jdu@123").authorities("ROLE_USER") .and()
		 * .withUser("jdadmin").password("jda@123").authorities("ROLE_USER","ROLE_ADMIN"
		 * );
		 */
        
    }
}
