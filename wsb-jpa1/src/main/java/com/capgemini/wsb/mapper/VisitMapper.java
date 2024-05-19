package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public class VisitMapper {
    public static VisitEntity mapToEntity(final VisitTO visitTO, boolean mapPatient, boolean mapDoctor) {
        if (visitTO == null) {
            return null;
        }
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        if (mapDoctor) {
            visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor(), false));
        }
        if (mapPatient) {
            visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatient(), false));
        }
        return visitEntity;
    }

    public static VisitTO mapToTO(final VisitEntity visitEntity, boolean mapPatient, boolean mapDoctor) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        if (mapDoctor) {
            visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor(), false));
        }
        if (mapPatient) {
            visitTO.setPatient(PatientMapper.mapToTO(visitEntity.getPatient(), false));
        }
        return visitTO;
    }

    public static List<VisitTO> mapToTOs(List<VisitEntity> visits) {
        return visits.stream()
                .map(visit -> mapToTO(visit, true, true))
                .collect(java.util.stream.Collectors.toList());
    }
}
