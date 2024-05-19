package com.capgemini.wsb.persistence.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Patient")
public class PatientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	@Column(nullable = false)
	private LocalDate dateOfRegistration;

	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false) // relacja jednostronna od strony PatientEntity
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
	private AddressEntity address;

	@OneToMany(
			mappedBy = "patient",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY) // relacja dwustronna od strony PatientEntity
	private List<VisitEntity> visits;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfRegistration() { return dateOfRegistration; }

	public void setDateOfRegistration(LocalDate dateOfRegistration) { this.dateOfRegistration = dateOfRegistration; }

	public AddressEntity getAddress() { return address; }

	public void setAddress(AddressEntity address) { this.address = address; }

	public List<VisitEntity> getVisits() { return visits; }

	public void setVisits(List<VisitEntity> visits) { this.visits = visits; }
}
