package com.ttu.roman.dao.userlogin;

import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.user.UserAccount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserAccountDAO extends AbstractFacade<UserAccount> {
    public UserAccountDAO() {
        super(UserAccount.class);
    }

    public UserAccount findByUserName(String username) {
        return em.createQuery("from UserAccount u where u.username=:username", UserAccount.class).
                setParameter("username", username).getSingleResult();
    }
}