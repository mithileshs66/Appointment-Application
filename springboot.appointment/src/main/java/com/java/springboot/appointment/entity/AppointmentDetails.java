package com.java.springboot.appointment.entity;

import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class AppointmentDetails {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private LocalDate appointmentDate;
	@Column
	private Time appointmentStartTime;
	@Column
	private Time appointmentEndTime;
	@Column
	private Time durationOfTime;
	@Column
	private String name;
	@Column
	private String purposeOfAppointment;

	public AppointmentDetails() {

	}

	public AppointmentDetails(Long id, LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime,
			Time durationOfTime, String name, String purposeOfAppointment) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.appointmentStartTime = appointmentStartTime;
		this.appointmentEndTime = appointmentEndTime;
		this.durationOfTime = durationOfTime;
		this.name = name;
		this.purposeOfAppointment = purposeOfAppointment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Time getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(Time appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public Time getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(Time appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public Time getDurationOfTime() {
		return durationOfTime;
	}

	public void setDurationOfTime(Time durationOfTime) {
		this.durationOfTime = durationOfTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurposeOfAppointment() {
		return purposeOfAppointment;
	}

	public void setPurposeOfAppointment(String purposeOfAppointment) {
		this.purposeOfAppointment = purposeOfAppointment;
	}

}
