/***
 * Reference : https://stackoverflow.com/a/47711211/5456372
 */

package com.pgdca.auth;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	 @Override
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	            throws IOException {
	        String targetUrl = determineTargetUrl(authentication);

	        if (response.isCommitted()) {
	            System.out.println("Can't redirect");
	            return;
	        }

	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }
	 /*
	     * This method extracts the roles of currently logged-in user and returns
	     * appropriate URL according to his/her role.
	     */
	    protected String determineTargetUrl(Authentication authentication) {
	        String url = "";

	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

	        List<String> roles = new ArrayList<String>();

	        for (GrantedAuthority a : authorities) {
	            roles.add(a.getAuthority());
	        }

	        log.info(roles.toString());
	        
	         if (isAdmin(roles)) {
	            url = "/admin";
	        } else if (isLibrarian(roles)) {
	            url = "/librarianBoard";
	        } else if (isPublic(roles)) {
	            url = "/homepage";
	        } else {
	            url = "/homepage?noAccess=true";
	        }

	        return url;
	    }
	    
	    private boolean isAdmin(List<String> roles) {
	        if (roles.contains("ROLE_ADMIN")) {
	            return true;
	        }
	        return false;
	    }
	    private boolean isLibrarian(List<String> roles) {
	        if (roles.contains("ROLE_LIB")) {
	            return true;
	        }
	        return false;
	    }
	    private boolean isPublic(List<String> roles) {
	        if (roles.contains("ROLE_PUBLIC")) {
	            return true;
	        }
	        return false;
	    }

	
}
