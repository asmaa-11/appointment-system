package com.app.appointment.system.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.app.appointment.system.dto.request.AppointmentRequestDto;
import com.app.appointment.system.dto.response.AppointmentResponseDTO;

public interface AppointmentService {

	List<AppointmentResponseDTO> listTodayAppointment() throws ParseException;

	AppointmentResponseDTO addAppointment(AppointmentRequestDto dto);

	void cancelAppointment(Integer appointmentId, Integer cancelReasonId);

	List<AppointmentResponseDTO> getAppointmentByDate(String appointmentDate) throws ParseException;

	List<AppointmentResponseDTO> getAppointmentByPatientName(String patientName);

	List<AppointmentResponseDTO> getPatintAppointmentHistory(String patientName);

}
