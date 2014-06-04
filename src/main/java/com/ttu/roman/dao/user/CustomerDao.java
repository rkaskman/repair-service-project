package com.ttu.roman.dao.user;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.user.AbstractCustomer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDAO extends AbstractFacade<AbstractCustomer>{
    public CustomerDAO() {
        super(AbstractCustomer.class);
    }
}
