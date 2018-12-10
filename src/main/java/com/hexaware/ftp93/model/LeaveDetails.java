package com.hexaware.ftp93.model;

import java.util.Objects;

import com.hexaware.ftp93.persistence.DbConnection;
import com.hexaware.ftp93.persistence.LeaveDetailsDAO;



import com.hexaware.ftp93.persistence.EmployeeDAO;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * LeaveDetails class to store leave manager details.
 * @author hexware
 */
public class LeaveDetails {

  /**
   * lvdId to store leave id. lvdNoOfDays to store no of days of leave.
   * lvdStarDate to store start date of leave. lvdEndDate to store end date of
   * date. lvdLeaveType to store leave type. lvdStatus to store the leave status.
   * lvdReason to store the leave reason. lvdAppliedOn to store the applied date.
   * lvdManagerComments to store manager comments.
   */
  private static int empId;
  private int lvdId;
  private static int lvdNoOfDays;
  private Date lvdStartDate;
  private Date lvdEndDate;
  private LeaveType lvdLeaveType;
  private LeaveStatus lvdLeaveStatus;
  private String lvdReason;
  private Date lvdAppliedOn;
  private String lvdManagerComments;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lvd = (LeaveDetails) obj;
    if (Objects.equals(empId, lvd.empId) && Objects.equals(lvdId, lvd.lvdId)
        && Objects.equals(lvdNoOfDays, lvd.lvdNoOfDays) && Objects.equals(lvdStartDate, lvd.lvdStartDate)
        && Objects.equals(lvdEndDate, lvd.lvdEndDate) && Objects.equals(lvdLeaveType, lvd.lvdLeaveType)
        && Objects.equals(lvdLeaveStatus, lvd.lvdLeaveStatus) && Objects.equals(lvdReason, lvd.lvdReason)
        && Objects.equals(lvdAppliedOn, lvd.lvdAppliedOn)
        && Objects.equals(lvdManagerComments, lvd.lvdManagerComments)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, lvdId, lvdNoOfDays, lvdStartDate, lvdEndDate, lvdLeaveType, lvdLeaveStatus, lvdReason,
        lvdAppliedOn, lvdManagerComments);
  }

  /**
   * @param argEmpId              to initialize employee id.
   * @param argLvdId              to initialize leave id.
   * @param arglvdNoOfDays        to initialize lvdNoOfDays.
   * @param arglvdStartDate       to initialize lvdStartDate.
   * @param arglvdEndDate         to initialize lvdEndDate.
   * @param arglvdLeaveType       to initialize lvdLeaveType
   * @param arglvdLeaveStatus     to initialize lvdLeaveStatus
   * @param arglvdReason          to initialize lvdReason.
   * @param arglvdAppliedOn       to initialize lvdAppliedOn.
   * @param arglvdManagerComments to initialize lvdManagerComments.
   */

  public LeaveDetails(final int argEmpId, final int argLvdId, final int arglvdNoOfDays, final Date arglvdStartDate,
      final Date arglvdEndDate, final LeaveType arglvdLeaveType, final LeaveStatus arglvdLeaveStatus,
      final String arglvdReason, final Date arglvdAppliedOn, final String arglvdManagerComments) {
    this.empId = argEmpId;
    this.lvdId = argLvdId;
    this.lvdNoOfDays = arglvdNoOfDays;
    this.lvdStartDate = arglvdStartDate;
    this.lvdEndDate = arglvdEndDate;
    this.lvdLeaveType = arglvdLeaveType;
    this.lvdLeaveStatus = arglvdLeaveStatus;
    this.lvdReason = arglvdReason;
    this.lvdAppliedOn = arglvdAppliedOn;
    this.lvdManagerComments = arglvdManagerComments;
  }

  /**
   * Gets the EmployeId.
   * @return this Employee ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the LeaveId.
   * @return this Leave ID.
   */
  public final int getLvdId() {
    return lvdId;
  }

  /**
   * Gets the LeavesNoOfDays.
   * @return this Leaves No Of Days.
   */
  public static int getLvdNoOfDays() {
    return lvdNoOfDays;
  }

  /**
   * Gets the LeaveStartDate.
   * @return this Leave Start Date.
   */
  public final Date getLvdStartDate() {
    return lvdStartDate;
  }

  /**
   * Gets the LeaveEndDate.
   * @return this Leave End Date.
   */
  public final Date getLvdEndDate() {
    return lvdEndDate;
  }

  /**
   * Gets the LeaveType.
   * @return this Leave Type.
   */
  public final LeaveType getLvdLeaveType() {
    return lvdLeaveType;
  }

  /**
   * Gets the LeaveStatus.
   * @return this Leave Status.
   */
  public final LeaveStatus getLvdLeaveStatus() {
    return lvdLeaveStatus;
  }

  /**
   * Gets the LeaveReason.
   * @return this Leave Reason.
   */
  public final String getLvdReason() {
    return lvdReason;
  }

  /**
   * Gets the LeaveAppliedOn.
   * @return this Leave Applied On.
   */
  public final Date getLvdAppliedOn() {
    return lvdAppliedOn;
  }

  /**
   * Gets the ManagerComments.
   * @return this Leave Manager Comments.
   */
  public final String getManagerComments() {
    return lvdManagerComments;
  }

  /**
   * @param argEmpId to set leave id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argLvdId to set leave id.
   */
  public final void setLvdId(final int argLvdId) {
    this.lvdId = argLvdId;
  }

  /**
   * @param argLvdNoOfDays to set leave No Of Days.
   */
  public final void setLvdNoOfDays(final int argLvdNoOfDays) {
    this.lvdNoOfDays = argLvdNoOfDays;
  }

  /**
   * @param argStartDate to set Leave Start Date.
   */
  public final void setStartDate(final Date argStartDate) {
    this.lvdStartDate = argStartDate;
  }

  /**
   * @param argLvdEndDate to set Leave End Date.
   */
  public final void setEndDate(final Date argLvdEndDate) {
    this.lvdEndDate = argLvdEndDate;
  }

  /**
   * @param argLvdLeaveType to set Leave Type.
   */
  public final void setLvdLeaveType(final LeaveType argLvdLeaveType) {
    this.lvdLeaveType = argLvdLeaveType;
  }

  /**
   * @param argLvdLeaveStatus to set Leave Status.
   */
  public final void setLvdLeaveStatus(final LeaveStatus argLvdLeaveStatus) {
    this.lvdLeaveStatus = argLvdLeaveStatus;
  }

  /**
   * @param argLvdReason to set Leave Reason.
   */
  public final void setLvdReason(final String argLvdReason) {
    this.lvdReason = argLvdReason;
  }

  /**
   * @param argLvdAppliedOn to set Leave Applied On.
   */
  public final void setLvdAppliedOn(final Date argLvdAppliedOn) {
    this.lvdAppliedOn = argLvdAppliedOn;
  }

  /**
   * @param argLvdManagerComments to set Leave Manager Comments.
   */
  public final void setLvdManagerComments(final String argLvdManagerComments) {
    this.lvdManagerComments = argLvdManagerComments;
  }

  @Override
  public final String toString() {
    return "EmployeeID:" + empId + "LeaveId:" + lvdId + "NoOfDays:" + lvdNoOfDays + "StartDate:" + lvdStartDate
        + "EndDate:" + lvdEndDate + "lvdleavetype:" + lvdLeaveType + "lvdstatus:" + lvdLeaveStatus + "lvdReason:"
        + lvdReason + "lvdAppliedOn:" + lvdAppliedOn + "lvdmanagercomments:" + lvdManagerComments;
  }

  /**
   * Method for Approve or Deny the Leave.
   * @param leaveId     to enter LeaveId to approve/deny.
   * @param status      to enter status to approve/deny.
   * @param mgrComments to get manager comments.
   * @return String.
   */
  public static String managerAction(final int leaveId, final String status, final String mgrComments) {
    int noOfDays = getLvdNoOfDays();
    LeaveDetails ld = dao().findLeave(leaveId);
    int empID = ld.getEmpId();
    Employee employee = edao().find(empID);
    String dbstatus = null;
    String result = "";
    String status1 = status.toLowerCase();
    if (status1.equals("approved")) {
      dbstatus = "APPROVED";
      dao().mgrcommnets(mgrComments, dbstatus, leaveId);
      result = "Approved Successfully";
      if (ld.getLvdLeaveType().toString().equals("EL")) {
        int remainingBal = employee.getEmpLeaveBalanceEL() - noOfDays;
        edao().updateBalEL(empID, remainingBal);
      } else if (ld.getLvdLeaveType().toString().equals("SL")) {
        int remainingBal = employee.getEmpLeaveBalanceSL() - noOfDays;
        edao().updateBalSL(empID, remainingBal);
      } else {
        int remainingBal = employee.getEmpLeaveBalanceML() - noOfDays;
        edao().updateBalML(empID, remainingBal);
      }
    } else if (status1.equals("denied")) {
      if (ld.getLvdLeaveStatus().toString().equals("APPROVED")) {
        dbstatus = "DENIED";
        if (ld.getLvdLeaveType().toString().equals("EL")) {
          int remainingBal = employee.getEmpLeaveBalanceEL() + noOfDays;
          edao().updateBalEL(empID, remainingBal);
        } else if (ld.getLvdLeaveType().toString().equals("SL")) {
          int remainingBal = employee.getEmpLeaveBalanceSL() + noOfDays;
          edao().updateBalSL(empID, remainingBal);
        } else {
          int remainingBal = employee.getEmpLeaveBalanceML() + noOfDays;
          edao().updateBalML(empID, remainingBal);
        }
        dao().mgrcommnets(mgrComments, dbstatus, leaveId);
        result = "Denied Permission";
      } else {
        dbstatus = "DENIED";
        dao().mgrcommnets(mgrComments, dbstatus, leaveId);
        result = "Denied Permission";
      }
    } else {
      result = "Please enter valid String";
    }

    return result;
  }

  /**
   * The dao for EmployeeDetails.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * /** The dao for LeaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * list all employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listAll() {
    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list all employee leave details.
   * @param mgrId id to get employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listPending(final int mgrId) {
    List<LeaveDetails> es = dao().pending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list leave details by id.
   * @param leaveId id to get leave details.
   * @return LeaveDetails
   */
  public static LeaveDetails listById(final int leaveId) {
    return dao().findLeave(leaveId);
  }

  /**
   * list leave details by id.
   * @param empID id to get leave details.
   * @return LeaveDetail
   */
  public static LeaveDetails[] leaveHis(final int empID) {
    List<LeaveDetails> es = dao().empHistory(empID);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * Applyy Leave for employee.
   * @param empid       id to set employee id.
   * @param startDate   id to set employee startDate.
   * @param endDate     id to set employee endDate.
   * @param leaveType   id to set employee leaveType.
   * @param leaveReason id to set employee leaveReason.
   * @throws ParseException throws parse exception.
   * @return error messages
   */
  public static String applyProcess(final int empid, final String startDate, final String endDate,
      final String leaveType, final String leaveReason) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    Employee emp = Employee.listById(empid);
    String msg = "";
    int mgrId = emp.getEmpManagerId();
    Date today = new Date();
    Date strDate = sf.parse(startDate);
    Date enDate = sf.parse(endDate);
    long diff = enDate.getTime() - strDate.getTime();
    long leavedays = diff / (1000 * 60 * 60 * 24);
    leavedays = leavedays + 1;
    int availableBalanceEL = 0;
    int availableBalanceML = 0;
    int availableBalanceSL = 0;
    int overLap = countNo(empid, startDate, endDate);
    String el = LeaveType.valueOf("EL").toString();
    String sl = LeaveType.valueOf("SL").toString();
    String ml = LeaveType.valueOf("ML").toString();
    if (leaveType.toUpperCase().equals(el)) {
      availableBalanceEL = emp.getEmpLeaveBalanceEL() - (int) leavedays;
    } else if (leaveType.toUpperCase().equals(sl)) {
      availableBalanceSL = emp.getEmpLeaveBalanceSL() - (int) leavedays;
    } else if (leaveType.toUpperCase().equals(ml)) {
      availableBalanceML = emp.getEmpLeaveBalanceML() - (int) leavedays;
    }
    if (!(leaveType.toUpperCase().equals(el) || leaveType.toUpperCase().equals(sl)
        || leaveType.toUpperCase().equals(ml))) {
      msg = "***** Please enter valid leave type(EL/SL/ML) *****";
    } else if (availableBalanceEL < 0 || availableBalanceSL < 0 || availableBalanceML < 0) {
      msg = "*****Insufficient Leave Balance(EL/SL/ML) *****";
    } else if (overLap > 0) {
      msg = "***** You have already applied for the leave. ****";
    } else if (strDate.compareTo(today) == -1) {
      msg = "**** Invalid start date. Start date cann't be past ****";
    } else if (leavedays <= 0) {
      System.out.println("**** End date is greater than start date. Please enter a valid End date. ****");
    } else {
      dao().insert(empid, leavedays, startDate, endDate, leaveType, leaveReason, sf.format(today));
      msg = "**** Your leave request succcessfully recored " + "form :" + startDate + " - " + endDate + " for: "
          + leavedays + "days" + " ****";
      if (mgrId == 0) {
        dao().updateCEO(empid);
        //edao().updateBal(empid, availableBalEL);
      }
    }
    return msg;
  }
  /**
   * No overlapping Leaves.
   * @param empid     id to get employee details.
   * @param startDate start date.
   * @param endDate   end date.
   * @return count of no of employee.
   */
  public static int countNo(final int empid, final String startDate, final String endDate) {
    int count = dao().count(empid, startDate, endDate);
    return count;
  }
}
