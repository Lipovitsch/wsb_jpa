package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "MedicalTreatment")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	@ManyToOne(
			fetch = FetchType.LAZY,
			optional = false) // relacja dwustronna od strony VisitEntity
	@JoinColumn(name = "VISIT_ID", nullable = false)
	private DoctorEntity visit;

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

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	public DoctorEntity getVisit() { return visit; }

	public void setVisit(DoctorEntity visit) { this.visit = visit; }
}
