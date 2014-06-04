package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceNote;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceNoteDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceNote serviceNote = serviceNoteDAO.findAll().get(0);
        assertTrue(serviceNote instanceof ServiceNote);
        assertNotNull(serviceNote.getServiceOrder());
    }
}