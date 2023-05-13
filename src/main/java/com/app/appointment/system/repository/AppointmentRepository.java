
package com.app.appointment.system.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.appointment.system.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment> findByPatientName(String patientName);

	@Query("select a from Appointment a where a.appointmentDate = CURRENT_DATE")
	public List<Appointment> finAllByCurrentAppointmentDate();

	@Query("select a from Appointment a where a.appointmentDate = :appointmentDate")
	List<Appointment> findAllWithAppintmentDate(@Param("appointmentDate") java.util.Date date);

	@Query("select a from Appointment a where a.appointmentDate < CURRENT_DATE and a.patientName =:patientName ")
	List<Appointment> findPatientHistory(@Param("patientName") String patientName);
}
