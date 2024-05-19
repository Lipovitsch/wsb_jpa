package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.dto.PatientTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Visit")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(
			fetch = FetchType.LAZY,
			optional = false) // relacja dwustronna od strony DoctorEntity
	@JoinColumn(name = "DOCTOR_ID", nullable = false)
	private DoctorEntity doctor;

	@ManyToOne(
			fetch = FetchType.LAZY,
			optional = false) // relacja dwustronna od strony PatientEntity
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	private PatientEntity patient;

	@OneToMany(
			mappedBy = "visit",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY) // relacja dwustronna od strony VisitEntity
	private List<MedicalTreatmentEntity> medicalTreatments;

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

	public DoctorEntity getDoctor() { return doctor; }

	public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }

	public PatientEntity getPatient() { return patient; }

	public void setPatient(PatientEntity patient) { this.patient = patient; }

	public List<MedicalTreatmentEntity> getMedicalTreatments() { return medicalTreatments; }

	public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) { this.medicalTreatments = medicalTreatments; }
}
