package com.valtech.training.leave.services;

import java.util.List;

import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

public interface LeaveService {

	List<LeaveMasterVO> getAllLeaveMasters();

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo);

	LeaveMasterVO getLeaveMaster(long employeeId);

	LeaveVO saveOrUpdateLeave(LeaveVO vo);

	LeaveVO getLeave(long id);

	List<LeaveVO> getAllLeaves();

	List<LeaveVO> getLeavesByEmployee(long empId);

	LeaveVO update(LeaveVO vo, long id);

	LeaveVO applyLeave(LeaveVO vo);

	LeaveVO approveLeave(ApproveLeaveVO vo);

	EmployeeVO getManager(long employeeId);

}