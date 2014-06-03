package com.ttu.roman.userlogin;

import com.ttu.roman.model.user.UserAccount;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAccountUtil {

    public static UserAccount getCurrentUser() {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return principal.getUserAccount();
    }
}
