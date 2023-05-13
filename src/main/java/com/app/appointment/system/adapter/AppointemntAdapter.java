package com.app.appointment.system.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.appointment.system.dto.request.AppointmentRequestDto;
import com.app.appointment.system.dto.response.AppointmentResponseDTO;
import com.app.appointment.system.entity.Appointment;

@Service
public class AppointemntAdapter {
	public static Appointment convertFromDtoToEntity(AppointmentRequestDto dto) {
		ModelMapper mapper = new ModelMapper();

		Appointment entity = mapper.map(dto, Appointment.class);

		return entity;
	}

	public static AppointmentResponseDTO convertFromEntityToDto(Appointment entity) {
		ModelMapper mapper = new ModelMapper();

		AppointmentResponseDTO dto = mapper.map(entity, AppointmentResponseDTO.class);

		return dto;
	}
}
