package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.ApplicationForm;
import com.dnr.brrts.web.model.FormName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationFormRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Test
    public void testFindByFormId() {
    }

    @Test
    public void testSave() {
        ApplicationForm form = new ApplicationForm();
        form.setFormName(FormName.NOTIFICATION_FORM);
        form.setType("1");

        this.entityManager.persist(form);
        ApplicationForm returnedForm = this.applicationFormRepository.findByFormName(FormName.NOTIFICATION_FORM);
        assertNotNull(returnedForm);
        assertNotNull(returnedForm.getFormId());

        System.out.println(form.getFormId());
        assertTrue(form.getFormName() == FormName.NOTIFICATION_FORM);
        assertTrue(form.getType().equals("1"));
    }
}