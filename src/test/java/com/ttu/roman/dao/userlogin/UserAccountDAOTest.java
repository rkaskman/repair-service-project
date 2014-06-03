package com.ttu.roman.dao.userlogin;

import com.ttu.roman.dao.DAOTest;
import junit.framework.Assert;
import org.junit.Test;


public class UserAccountDAOTest extends DAOTest{

    @Test
    public void testSelectUserAccount() throws Exception {
        Assert.assertNotNull(userAccountDAO.findByUserName("kaarel"));
    }
}
