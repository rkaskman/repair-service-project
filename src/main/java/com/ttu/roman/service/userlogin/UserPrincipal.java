package com.ttu.roman.service.userlogin;

import com.ttu.roman.model.user.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class UserPrincipal implements UserDetails {

    UserAccount userAccount;
    private static Map<Integer, String> codeRoleMap = new HashMap<Integer, String>() {
        {
            put(3, "ROLE_WORKER");
            put(4, "ROLE_CLIENT");
        }
    };


    public UserPrincipal(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(codeRoleMap.get(userAccount.getSubjectTypeFk())));
    }

    @Override
    public String getPassword() {
        return userAccount.getPassw();
    }

    @Override
    public String getUsername() {
        return userAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
}
