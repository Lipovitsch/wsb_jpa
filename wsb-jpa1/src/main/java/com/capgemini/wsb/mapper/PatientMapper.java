package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PatientMapper {
    public static PatientEntity mapToEntity(final PatientTO patientTO, boolean mapVisits) {
        if (patientTO == null) {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setDateOfRegistration(patientTO.getDateOfRegistration());
        patientEntity.setAddress(AddressMapper.mapToEntity(patientTO.getAddress()));
        if (mapVisits) {
            patientEntity.setVisits(patientTO.getVisits().stream()
                    .map(visit -> VisitMapper.mapToEntity(visit, false, false))
                    .collect(Collectors.toList()));
        }
        return patientEntity;
    }

    public static PatientTO mapToTO(final PatientEntity patientEntity, boolean mapVisits) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        AddressEntity addressEntity;
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setDateOfRegistration(patientEntity.getDateOfRegistration());
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        if (mapVisits) {
            patientTO.setVisits(patientEntity.getVisits().stream()
                    .map(visit -> VisitMapper.mapToTO(visit, false, false))
                    .collect(Collectors.toList()));
        }
        return patientTO;
    }

    public static List<PatientTO> mapToTOs(List<PatientEntity> patients) {
        return patients.stream()
                .map(patient -> mapToTO(patient, true))
                .collect(Collectors.toList());
    }
}