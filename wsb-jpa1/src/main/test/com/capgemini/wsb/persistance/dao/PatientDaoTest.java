package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    @Test
    public void shouldFindByLastName() {
        // given
        // given data is loaded from data.sql

        // when
        List<PatientEntity> patients = patientDao.findByLastName("Martin");

        // then
        assertThat(patients).hasSize(1);
        assertThat(patients.get(0).getId()).isEqualTo(7L);
    }

    @Test
    public void shouldFindPatientsWithMoreThanXVisits() {
        // given
        // given data is loaded from data.sql

        // when
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(2);

        // then
        assertThat(patients).hasSize(2);
        assertThat(patients.get(0).getId()).isEqualTo(5L);
        assertThat(patients.get(1).getId()).isEqualTo(6L);

    }

    @Test
    public void shouldFindPatientsRegisteredLaterThanSpecifiedDate() {
        // given
        // given data is loaded from data.sql

        // when
        List<PatientEntity> patients = patientDao.findPatientsRegisteredLaterThanSpecifiedDate(LocalDate.of(2020, 1, 5));

        // then
        assertThat(patients).hasSize(5);
        assertThat(patients.get(0).getId()).isEqualTo(6L);
        assertThat(patients.get(1).getId()).isEqualTo(7L);
        assertThat(patients.get(2).getId()).isEqualTo(8L);
        assertThat(patients.get(3).getId()).isEqualTo(9L);
        assertThat(patients.get(4).getId()).isEqualTo(10L);
    }
}
