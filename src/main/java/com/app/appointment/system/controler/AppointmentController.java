package com.app.appointment.system.controler;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.appointment.system.dto.request.AppointmentRequestDto;
import com.app.appointment.system.dto.response.AppointmentResponseDTO;
import com.app.appointment.system.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/addAppointment")
	public ResponseEntity<?> addAppointment(@RequestBody AppointmentRequestDto dto) {
		/* for creating folder and appointment */
		AppointmentResponseDTO response = appointmentService.addAppointment(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/cancelAppointment")
	public ResponseEntity<?> cancelAppointment(@RequestParam("appointmentId") int appointmentId,@RequestParam("cancelReasonId") int cancelReasonId) {
		String message = "";
		/* for creating file */
		appointmentService.cancelAppointment(appointmentId,cancelReasonId);
		return ResponseEntity.status(HttpStatus.OK).body(message);

	}

	@GetMapping("/listTodayAppointment")
	public ResponseEntity<?> listTodayAppointment() throws ParseException {
		List<AppointmentResponseDTO> list = appointmentService.listTodayAppointment();
		if (list != null) {
			return ResponseEntity.ok().header(HttpHeaders.ACCEPT).body(list);

		} else {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION).body("no Appointments Today");

		}
	}

	@GetMapping("/getAppointmentByDate")
	public ResponseEntity<?> getAppointmentByDate(@RequestParam("appointmentDate") String appointmentDate)
			throws ParseException {
		List<AppointmentResponseDTO> list = appointmentService.getAppointmentByDate(appointmentDate);
		if (list != null) {
			return ResponseEntity.ok().header(HttpHeaders.ACCEPT).body(list);

		} else {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION).body("no Appointments in this date");

		}
	}

	@GetMapping("/getAppointmentByPatientName")
	public ResponseEntity<?> getAppointmentByPatientName(@RequestParam("patientName") String patientName) {
		List<AppointmentResponseDTO> list = appointmentService.getAppointmentByPatientName(patientName);
		if (list != null) {
			return ResponseEntity.ok().header(HttpHeaders.ACCEPT).body(list);

		} else {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION).body("no Appointments Today");

		}
	}

	@GetMapping("/getPatintAppointmentHistory")
	public ResponseEntity<?> getPatintAppointmentHistory(@RequestParam("patientName") String patientName) {
		List<AppointmentResponseDTO> list = appointmentService.getPatintAppointmentHistory(patientName);
		if (list != null) {
			return ResponseEntity.ok().header(HttpHeaders.ACCEPT).body(list);

		} else {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION).body("no Appointments Today");

		}
	}
}
