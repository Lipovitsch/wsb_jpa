package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.time.LocalDate;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    public List<PatientEntity> findByLastName(String lastName);

    public List<VisitEntity> findAllVisitsByPatientId(Long patientId);

    public List<PatientEntity> findPatientsWithMoreThanXVisits(int numberOfVisits);

    public List<PatientEntity> findPatientsRegisteredLaterThanSpecifiedDate(LocalDate date);

}
