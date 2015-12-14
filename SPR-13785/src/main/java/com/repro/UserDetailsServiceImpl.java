/* ***************************************************************************
 * Copyright 2015 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * **************************************************************************/
package com.repro;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, "password", Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

}
