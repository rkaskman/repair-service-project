package com.ttu.roman.dao.user;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.user.AbstractCustomer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CustomerDAO extends AbstractFacade<AbstractCustomer>{

    public CustomerDAO() {
        super(AbstractCustomer.class);
    }
        //todo: maybe use like predicate??
    List<AbstractCustomer> findCustomersByName(String name) {
        List<AbstractCustomer> customers = new ArrayList<AbstractCustomer>();
        customers.addAll(getPersonCustomers(name));
        customers.addAll(getEnterpriseCustomers(name));

        return customers;
    }

    private List getEnterpriseCustomers(String name) {
        return em.createQuery("from EnterpriseCustomer pc where pc.enterprise.name=:name").
                setParameter("name", name).getResultList();
    }

    private List<AbstractCustomer> getPersonCustomers(String name) {
        return em.createQuery("from PersonCustomer pc where pc.person.lastName=:lastName").
        setParameter("lastName", name).getResultList();
    }
}
