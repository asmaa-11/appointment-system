package com.app.appointment.system.dto.response;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class AppointmentResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;

	private CancelReasoneDTO cancelReasoneDto;

	private String patientName;

	private Date appointmentDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CancelReasoneDTO getCancelReasoneDto() {
		return cancelReasoneDto;
	}

	public void setCancelReasoneDto(CancelReasoneDTO cancelReasoneDto) {
		this.cancelReasoneDto = cancelReasoneDto;
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