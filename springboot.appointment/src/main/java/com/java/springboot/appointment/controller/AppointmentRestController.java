package com.java.springboot.appointment.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.appointment.entity.AppointmentDetails;
import com.java.springboot.appointment.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentRestController {

	private static Logger logger = Logger.getLogger(AppointmentRestController.class.getName());

	@Autowired
	private AppointmentService appointmentService;

	/**
	 * GET request to return specific appointments
	 * 
	 * @throws Exception
	 **/
	@RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
	public Optional<AppointmentDetails> findById(@PathVariable Long appointmentId) {
		logger.log(Level.INFO, "Executing findById method");
		logger.log(Level.INFO, "AppointmentId:{0}", appointmentId);
		Optional<AppointmentDetails> appointmentDetails = null;
		try {
			appointmentDetails = appointmentService.findById(appointmentId);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception Occured at findById method:{0}", e.getMessage());
		}
		return appointmentDetails;
	}

	/**
	 * GET request to return all appointments
	 * 
	 * @throws Exception
	 **/
	@RequestMapping(path = "/getAllAppointment", method = RequestMethod.GET)
	public List<AppointmentDetails> findAll() {
		logger.log(Level.INFO, "Executing findAll method");
		List<AppointmentDetails> appointmentList = null;
		try {
			appointmentList = appointmentService.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception Occured at findAll method:{0}", e.getMessage());
		}
		return appointmentList;
	}

	/**
	 * GET request to return all appointments based on a date range
	 * 
	 * @throws Exception
	 **/
	@RequestMapping(path = "/time", method = RequestMethod.GET)
	public List<AppointmentDetails> findByDateRange(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
		logger.log(Level.INFO, "Executing  findByDateRange method");
		logger.log(Level.INFO, "StartDate:{0}", startDate);
		logger.log(Level.INFO, "enddateDate:{0}", endDate);
		List<AppointmentDetails> data = null;
		try {
			data = appointmentService.findByDateRange(startDate, endDate);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception Occured at findByDateRange method method:{0}", e.getMessage());
		}
		return data;
	}

	/**
	 * POST request to add new appointments
	 * 
	 * @throws Exception
	 **/
	@RequestMapping(path = "/createAppointment", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public AppointmentDetails create(@RequestBody AppointmentDetails appointment) {
		logger.log(Level.INFO, "Executing  create method");
		logger.log(Level.INFO, "Appointment Details:{0}", appointment);
		AppointmentDetails created = null;
		try {
			created = appointmentService.create(appointment);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception Occured at  create method method:{0}", e.getMessage());
		}
		return created;
	}

	/**
	 * PUT request to update appointments
	 * 
	 * @throws Exception
	 **/
	@RequestMapping(path = "update/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public AppointmentDetails update(@PathVariable Long appointmentId, @RequestBody AppointmentDetails appointment)
			throws Exception {
		logger.log(Level.INFO, "Executing  update method");
		logger.log(Level.INFO, "AppointmentID:{0}", appointmentId);
		logger.log(Level.INFO, "Appointment Details:{0}", appointment);
		AppointmentDetails update = null;
		try {
			update = appointmentService.update(appointmentId, appointment);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception Occured at update method method:{0}", e.getMessage());
		}
		return update;
	}

	/**
	 * DELETE request to delete specific appointments
	 * 
	 * @throws Exception
	 **/
	@RequestMapping(path = "delete/{appointmentId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable Long appointmentId) throws Exception {
		logger.log(Level.INFO, "Executing deleteById method");
		logger.log(Level.INFO, "AppointmentID to be deleted:{0}", appointmentId);
		appointmentService.deleteById(appointmentId);
	}

}
