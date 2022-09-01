package com.java.springboot.appointment.service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.appointment.entity.AppointmentDetails;
import com.java.springboot.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService {

	private static Logger logger = Logger.getLogger(AppointmentService.class.getName());

	@Autowired
	AppointmentRepository appointmentRepository;

	public Optional<AppointmentDetails> findById(Long appointmentId) throws Exception {
		logger.log(Level.INFO, "Service class: Executing findById method");
		logger.log(Level.INFO, "AppointmentId:{0}", appointmentId);
		return appointmentRepository.findById(appointmentId);
	}

	public List<AppointmentDetails> findAll() throws Exception {
		logger.log(Level.INFO, "Service Class: Executing findAll method");
		return appointmentRepository.findAll();
	}

	public AppointmentDetails create(AppointmentDetails appointment) throws Exception {
		logger.log(Level.INFO, "Executing  create method");
		logger.log(Level.INFO, "Appointment Details:{0}", appointment);
		return appointmentRepository.save(appointment);
	}

	public List<AppointmentDetails> findByDateRange(LocalDate startDate, LocalDate endDate) throws Exception {
		logger.log(Level.INFO, "Service Class: Executing  findByDateRange method");
		logger.log(Level.INFO, "StartDate:{0}", startDate);
		logger.log(Level.INFO, "enddateDate:{0}", endDate);
		return appointmentRepository.findByDateRange(startDate, endDate);
	}

	public AppointmentDetails update(Long appointmentId, AppointmentDetails appointment) throws Exception {
		logger.log(Level.INFO, "Service class: Executing  update method");
		logger.log(Level.INFO, "Service class: AppointmentID:{0}", appointmentId);
		logger.log(Level.INFO, "Service class: Appointment Details:{0}", appointment);
		AppointmentDetails data = appointmentRepository.getReferenceById(appointmentId);
		LocalDate appointmentDate = appointment.getAppointmentDate();
		Time appointmentStartTime = appointment.getAppointmentStartTime();
		Time appointmentEndTime = appointment.getAppointmentEndTime();
		Time durationOfTime = appointment.getDurationOfTime();
		String name = appointment.getName();
		String purposeOfAppointment = appointment.getPurposeOfAppointment();
		data.setAppointmentDate(appointmentDate);
		data.setAppointmentStartTime(appointmentStartTime);
		data.setAppointmentEndTime(appointmentEndTime);
		data.setDurationOfTime(durationOfTime);
		data.setName(name);
		data.setPurposeOfAppointment(purposeOfAppointment);
		return appointmentRepository.save(data);

	}

	public void deleteById(Long appointmentId) throws Exception {
		logger.log(Level.INFO, "Service class: Executing deleteById method");
		logger.log(Level.INFO, "Service class: AppointmentID to be deleted:{0}", appointmentId);
		appointmentRepository.deleteById(appointmentId);
	}

}
