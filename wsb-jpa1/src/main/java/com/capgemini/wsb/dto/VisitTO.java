package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;

    private String description;

    private LocalDateTime time;

    private DoctorTO doctor;

//    private Long doctorId;

//    private Long patientId;

    private PatientTO patient;

//    private List<MedicalTreatmentEntity> medicalTreatments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

//    public Long getDoctorId() { return doctorId; }

//    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

//    public Long getPatientId() { return patientId; }

//    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public DoctorTO getDoctor() { return doctor; }

    public void setDoctor(DoctorTO doctor) { this.doctor = doctor; }

    public PatientTO getPatient() { return patient; }

    public void setPatient(PatientTO patient) { this.patient = patient; }

//    public List<MedicalTreatmentEntity> getMedicalTreatments() { return medicalTreatments; }

//    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) { this.medicalTreatments = medicalTreatments; }
}
