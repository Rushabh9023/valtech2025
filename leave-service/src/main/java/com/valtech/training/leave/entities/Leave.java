package com.valtech.training.leave.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Leave {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_seq")
	@SequenceGenerator(name = "leave_seq",sequenceName = "leave_seq",allocationSize = 1)
	private long id;
	private LocalDate fromDate;
	private LocalDate toDate;
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	private String reasone;
	private String comments;
	private long employeeId;
	
	public Leave() {}

	public Leave(long id, LocalDate fromDate, LocalDate toDate, LeaveType leaveType, LeaveStatus leaveStatus,
			String reasone, String comments, long employeeId) {
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.reasone = reasone;
		this.comments = comments;
		this.employeeId = employeeId;
	}
	
	public long leaveInDays() {
		return ChronoUnit.DAYS.between(fromDate, toDate);
	}
	
	public void checkLeaveApplicationAndUpdateStatus(LeaveMaster lm) {
		if (leaveType == LeaveType.CASUAL) {
			if (lm.getCasualLeaves() == 0) {
				rejectLeave("Casual Leaves Exhausated");
			} else {
				long diff = ChronoUnit.DAYS.between(fromDate, toDate);
				if (diff > lm.getCasualLeaves()) {
					comments = "Available Leaves is " + lm.getCasualLeaves() + " Applied is " + diff + ".";
				} else {
					comments = "Good to go..";
				}
//				SimpleDateFormat ft 
//	            = new SimpleDateFormat("dd-MM-yyyy"); 
//	  
//	        String currentDate = ft.format(new Date()); 
//	        String leaveFromDate = ft.format(fromDate);
//	      ChronoLocalDate date = new ;
//
//				if(fromDate.isBefore(date)) {
//					
//				}
				// check if fromdate is before today and reject it
			}
		}
		if (leaveType == LeaveType.SICK) {
			if (lm.getSickLeaves() == 0) {
				rejectLeave("Casual Leaves Exhausated");
			} else {
				long diff = ChronoUnit.DAYS.between(fromDate, toDate);
				if (diff > lm.getSickLeaves()) {
					comments = "Available Leaves is " + lm.getSickLeaves() + " Applied is " + diff + ".";
				} else {
					comments = "Good to go..";
				}
			}
		}
		if (leaveType == LeaveType.OTHERS) {
			if (lm.getOtherLeaves() == 0) {
				rejectLeave("Casual Leaves Exhausated");
			} else {
				long diff = ChronoUnit.DAYS.between(fromDate, toDate);
				if (diff > lm.getOtherLeaves()) {
					comments = "Available Leaves is " + lm.getOtherLeaves() + " Applied is " + diff + ".";
				} else {
					comments = "Good to go..";
				}
			}
		}
		
	}
	
	public void approveLeave(LeaveMaster leaveMaster, long manager) {
		leaveStatus = LeaveStatus.APPROVED;
		if(comments == null) comments = "";
		comments += "Your Leave has been approved";
		
	}

	public void rejectLeave(String comment) {
		leaveStatus = LeaveStatus.REJECTED;
		comments = comment;
	}

	public void updateLeave(String comment) {
	
		comments += comment;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getReasone() {
		return reasone;
	}
	public void setReasone(String reasone) {
		this.reasone = reasone;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	
	

	

	
	

}
