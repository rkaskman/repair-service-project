package com.ttu.roman.dao.user;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.user.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDAO extends AbstractFacade<Person> {
    public PersonDAO() {
        super(Person.class);
    }
}
