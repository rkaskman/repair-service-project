package com.ttu.roman.service.userlogin;

import com.ttu.roman.model.user.CustomerUserAccount;
import com.ttu.roman.model.user.EmployeeUserAccount;
import com.ttu.roman.model.user.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


public class UserPrincipal implements UserDetails {

    UserAccount userAccount;

    public UserPrincipal(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(getRoleByUserAccount(userAccount)));
    }

    private String getRoleByUserAccount(UserAccount userAccount) {
        if (userAccount instanceof EmployeeUserAccount) {
            return "ROLE_WORKER";
        }
        if (userAccount instanceof CustomerUserAccount) {
            return "ROLE_CLIENT";
        }
        return "";
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
