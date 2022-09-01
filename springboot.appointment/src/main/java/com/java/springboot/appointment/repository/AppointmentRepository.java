package com.java.springboot.appointment.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.java.springboot.appointment.entity.AppointmentDetails;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentDetails, Long> {

	@Query(value = "from AppointmentDetails t where appointmentDate BETWEEN :startDate AND :endDate")
	List<AppointmentDetails> findByDateRange(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);
}
