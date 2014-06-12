package com.ttu.roman.service;


import com.ttu.roman.note.ServiceOrderNoteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ServiceNoteService {

    JdbcTemplate jdbcTemplate;

    public void insertNote(ServiceOrderNoteForm serviceOrderNoteForm, Integer reporterType) {

        try {
            jdbcTemplate.update("select ri.public.ri_rep_add_service_note(?,null,?,?,?)", serviceOrderNoteForm.getCustomerId(),
                    serviceOrderNoteForm.getServiceOrderId(),
                    reporterType,
                    serviceOrderNoteForm.getCustomerNote()
            );

        }catch (Exception ignored) {
}

        }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
