package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.dao.impl.VisitDaoImpl;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadeVisits() {
        // given
        // given data is loaded from data.sql

        // when
        patientService.delete(1L);

        // then
        PatientEntity patient = patientDao.findOne(1L);
        assertThat(patient).isNull();

        VisitEntity visit = visitDao.findOne(1L);
        assertThat(visit).isNull();

        VisitEntity visit2 = visitDao.findOne(3L);
        assertThat(visit2).isNull();

        DoctorEntity doctor = doctorDao.findOne(1L);
        assertThat(doctor).isNotNull();
        assertThat(doctor.getFirstName()).isEqualTo("John");

        DoctorEntity doctor2 = doctorDao.findOne(2L);
        assertThat(doctor2).isNotNull();
        assertThat(doctor2.getFirstName()).isEqualTo("Jane");
    }

    @Test
    public void testShouldGetPatientById() {
        // given
        // given data is loaded from data.sql

        // when
        PatientTO patient = patientService.findById(1L);

        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getId()).isEqualTo(1L);
        assertThat(patient.getFirstName()).isEqualTo("Adam");
        assertThat(patient.getLastName()).isEqualTo("Johnson");
        assertThat(patient.getDateOfBirth()).isEqualTo("1990-01-13");
        assertThat(patient.getDateOfRegistration()).isEqualTo("2020-01-01");
        assertThat(patient.getPatientNumber()).isEqualTo("0001");
        assertThat(patient.getEmail()).isEqualTo("adam.johnson@mail.com");
        assertThat(patient.getTelephoneNumber()).isEqualTo("123123133");
        assertThat(patient.getAddress().getId()).isEqualTo(11L);
        assertThat(patient.getVisits()).hasSize(2);
        assertThat(patient.getVisits().get(0).getId()).isEqualTo(1L);
        assertThat(patient.getVisits().get(1).getId()).isEqualTo(3L);
    }

    @Test
    public void testShouldFindAllVisitsByPatientId() {
        // given
        // given data is loaded from data.sql

        // when
        List<VisitTO> visits = patientService.findAllVisitsByPatientId(1L);

        // then
        assertThat(visits).hasSize(2);
        assertThat(visits).allMatch(visit -> visit.getPatient().getId().equals(1L));
        assertThat(visits.get(0).getId()).isEqualTo(1L);
        assertThat(visits.get(1).getId()).isEqualTo(3L);
    }
}