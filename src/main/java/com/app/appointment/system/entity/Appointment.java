package com.app.appointment.system.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cancel_reasone_id")
	private CancelReasone cancelReasone;
	@Column(name = "patient_name")
	private String patientName;
	@Column(name = "appointment_date")

	private Date appointmentDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CancelReasone getCancelReasone() {
		return cancelReasone;
	}

	public void setCancelReasone(CancelReasone cancelReasone) {
		this.cancelReasone = cancelReasone;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}