package com.ttu.roman.dao.user;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EnterpriseDAO extends AbstractFacade<EnterpriseDAO> {
    public EnterpriseDAO() {
        super(EnterpriseDAO.class);
    }
}
