package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

import javax.print.Doc;
import java.util.stream.Collectors;

public class DoctorMapper {
    public static DoctorEntity mapToEntity(final DoctorTO doctorTO, boolean mapVisits) {
        if (doctorTO == null) {
            return null;
        }
        final DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setAddress(AddressMapper.mapToEntity(doctorTO.getAddress()));
        if (mapVisits) {
            doctorEntity.setVisits(doctorTO.getVisits().stream()
                    .map(visit -> VisitMapper.mapToEntity(visit, false, false))
                    .collect(Collectors.toList()));
        }
        return doctorEntity;
    }

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity, boolean mapVisits) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));
        if (mapVisits) {
            doctorTO.setVisits(doctorEntity.getVisits().stream()
                    .map(visit -> VisitMapper.mapToTO(visit, false, false))
                    .collect(Collectors.toList()));
        }
        return doctorTO;
    }
}
