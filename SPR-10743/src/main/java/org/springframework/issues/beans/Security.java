package org.springframework.issues.beans;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class Security {

	private AuthenticationManager authenticationManager;

	@Autowired
	public Security(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Autowired
	ApplicationEventPublisher _eventPublisher;

	public Authentication authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				username, password);
		
		SecurityContextHolder.setStrategyName( SecurityContextHolder.MODE_GLOBAL );
		
		Authentication auth = authenticationManager.authenticate(token);
		if (null != auth) {
			SecurityContextHolder.getContext().setAuthentication(auth);

			_eventPublisher
					.publishEvent(new InteractiveAuthenticationSuccessEvent(
							auth, this.getClass()));

			return auth;
		}
		throw new BadCredentialsException("null authentication");
	}

	 public final boolean hasRole(String role) {
		    boolean hasRole = false;
		    UserDetails userDetails = getUserDetails();
		    if (userDetails != null) {
		      Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		      if (isRolePresent(authorities, role)) {
		        hasRole = true;
		      }
		    } 
		    return hasRole;
		  }
		  /**
		   * Get info about currently logged in user
		   * @return UserDetails if found in the context, null otherwise
		   */
		  protected UserDetails getUserDetails() {
		    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    UserDetails userDetails = null;
		    if (principal instanceof UserDetails) {
		      userDetails = (UserDetails) principal;
		    }
		    return userDetails;
		  }
		  /**
		   * Check if a role is present in the authorities of current user
		   * @param authorities all authorities assigned to current user
		   * @param role required authority
		   * @return true if role is present in list of authorities assigned to current user, false otherwise
		   */
		  private boolean isRolePresent(Collection<? extends GrantedAuthority> authorities, String role) {
		    boolean isRolePresent = false;
		    for (GrantedAuthority grantedAuthority : authorities) {
		      isRolePresent = grantedAuthority.getAuthority().equals(role);
		      if (isRolePresent) break;
		    }
		    return isRolePresent;
		  }


}



