
package com.app.appointment.system.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.appointment.system.entity.Appointment;
import com.app.appointment.system.entity.CancelReasone;

public interface CancelReasoneRepository extends JpaRepository<CancelReasone, Integer> {

}
