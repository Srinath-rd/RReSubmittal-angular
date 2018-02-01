package com.dnr.brrts.web.repository;

import com.dnr.brrts.web.model.NfApplicationForm;
import com.dnr.brrts.web.model.FormName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NfApplicationFormRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NfApplicationFormRepository nfApplicationFormRepository;


    @Test
    public void testSave() {
        NfApplicationForm form = new NfApplicationForm();
        form.setFormName(FormName.NOTIFICATION_FORM);
        form.setType("1");

        this.entityManager.persist(form);
        NfApplicationForm returnedForm = this.nfApplicationFormRepository.findByFormName(FormName.NOTIFICATION_FORM);
        assertNotNull(returnedForm);
        System.out.println("FormID is : hello:" + returnedForm.getFormId());
        assertNotNull(returnedForm.getFormId());

        System.out.println(form.getFormId());
        assertTrue(form.getFormName() == FormName.NOTIFICATION_FORM);
        assertTrue(form.getType().equals("1"));
    }

    @Test
    public void testFindAll(){
        NfApplicationForm form1 = new NfApplicationForm();
        form1.setFormName(FormName.NOTIFICATION_FORM);
        form1.setType("1");

        this.entityManager.persist(form1);


        NfApplicationForm form2 = new NfApplicationForm();
        form2.setFormName(FormName.TECHNICAL_ASSISTANCE_FORM);
        form2.setType("2");

        this.entityManager.persist(form2);

        NfApplicationForm form3 = new NfApplicationForm();
        form3.setFormName(FormName.CLOSURE_FORM);
        form3.setType("3");

        this.entityManager.persist(form3);

        List<NfApplicationForm> results = this.nfApplicationFormRepository.findAll();
        assertNotNull(results);
        assertTrue(results.size() == 3);
    }
}