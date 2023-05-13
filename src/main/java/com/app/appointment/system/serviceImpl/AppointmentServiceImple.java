package com.app.appointment.system.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.appointment.system.adapter.AppointemntAdapter;
import com.app.appointment.system.dto.request.AppointmentRequestDto;
import com.app.appointment.system.dto.response.AppointmentResponseDTO;
import com.app.appointment.system.entity.Appointment;
import com.app.appointment.system.entity.CancelReasone;
import com.app.appointment.system.exception.BussinessException;
import com.app.appointment.system.repository.AppointmentRepository;
import com.app.appointment.system.repository.CancelReasoneRepository;
import com.app.appointment.system.service.AppointmentService;

@Service
public class AppointmentServiceImple implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
	CancelReasoneRepository cancelReasoneRepository;

	@Override
	public List<AppointmentResponseDTO> listTodayAppointment() throws ParseException {
		/* convert from dto to entity */
		List<AppointmentResponseDTO> list = new ArrayList<>();
		appointmentRepository.finAllByCurrentAppointmentDate().forEach(appointemnt -> {
			list.add(AppointemntAdapter.convertFromEntityToDto(appointemnt));

		});
		if (list.size() > 0)
			return list;
		else
			return null;
	}

	@Override
	public AppointmentResponseDTO addAppointment(AppointmentRequestDto dto) {
		Appointment entity = AppointemntAdapter.convertFromDtoToEntity(dto);
		entity = appointmentRepository.save(entity);
		AppointmentResponseDTO res = AppointemntAdapter.convertFromEntityToDto(entity);
		return res;
	}

	@Override
	public void cancelAppointment(Integer appointmentId, Integer cancelReasonId) throws BussinessException {
		Optional<Appointment> entity = appointmentRepository.findById(appointmentId);
		if (entity.isPresent()) {
			/* get reasone by id */
			Optional<CancelReasone> reasone = cancelReasoneRepository.findById(cancelReasonId);
			if (reasone.isPresent()) {
				// update
				entity.get().setCancelReasone(reasone.get());
				appointmentRepository.save(entity.get());
			} else {
				throw new BussinessException("resonse not found ");

			}
		} else {
			throw new BussinessException("AppointMnet not found ");

		}
	}

	@Override
	public List<AppointmentResponseDTO> getAppointmentByDate(String appointmentDate) throws ParseException {
		List<AppointmentResponseDTO> list = new ArrayList<>();
		appointmentRepository.findAllWithAppintmentDate(new SimpleDateFormat("yyyy-MM-dd").parse(appointmentDate))
				.forEach(appointemnt -> {
					list.add(AppointemntAdapter.convertFromEntityToDto(appointemnt));

				});

		return list;
	}

	@Override
	public List<AppointmentResponseDTO> getAppointmentByPatientName(String patientName) {
		List<AppointmentResponseDTO> list = new ArrayList<>();
		appointmentRepository.findByPatientName(patientName).forEach(appointemnt -> {
			list.add(AppointemntAdapter.convertFromEntityToDto(appointemnt));

		});

		return list;
	}

	@Override
	public List<AppointmentResponseDTO> getPatintAppointmentHistory(String patientName) {
		List<AppointmentResponseDTO> list = new ArrayList<>();
		appointmentRepository.findPatientHistory(patientName).forEach(appointemnt -> {
			list.add(AppointemntAdapter.convertFromEntityToDto(appointemnt));

		});

		return list;
	}

}
