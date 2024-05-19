package com.capgemini.wsb.service.impl;


import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity, true);
    }

    @Override
    public void delete(Long id) {
        patientDao.delete(id);
    }

    @Override
    public List<PatientTO> findByLastName(String lastName) {
        List<PatientEntity> patients = patientDao.findByLastName(lastName);
        return PatientMapper.mapToTOs(patients);
    }

    @Override
    public List<VisitTO> findAllVisitsByPatientId(Long patientId) {
        List<VisitEntity> visits = patientDao.findAllVisitsByPatientId(patientId);
        return VisitMapper.mapToTOs(visits);
    }

    @Override
    public List<PatientTO> findPatientsWithMoreThanXVisits(int numberOfVisits) {
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(numberOfVisits);
        return PatientMapper.mapToTOs(patients);
    }

    @Override
    public List<PatientTO> findPatientsRegisteredLaterThanSpecifiedDate(LocalDate date) {
        List<PatientEntity> patients = patientDao.findPatientsRegisteredLaterThanSpecifiedDate(date);
        return PatientMapper.mapToTOs(patients);
    }
}
