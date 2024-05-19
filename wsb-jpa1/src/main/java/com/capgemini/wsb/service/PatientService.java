package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.time.LocalDate;
import java.util.List;

public interface PatientService
{
    public PatientTO findById(final Long id);

    void delete(Long id);

    public List<PatientTO> findByLastName(String lastName);

    public List<VisitTO> findAllVisitsByPatientId(Long patientId);

    public List<PatientTO> findPatientsWithMoreThanXVisits(int numberOfVisits);

    public List<PatientTO> findPatientsRegisteredLaterThanSpecifiedDate(LocalDate date);
}
