package com.hexaware.ftp93.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.hexaware.ftp93.model.LeaveDetails;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;


/**
 * The DAO class for leave details.
 */
public interface LeaveDetailsDAO  {
  /**
   * return all the details of all the Leavedetails.
   * @return the Leavedetails array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();


  /**
   * return all the details of the selected employee.
   * @param lvdId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LVD_ID = :lvdId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails find(@Bind("lvdId") int lvdId);

  /**
   * return all the details of the selected employee.
   * @param leaveId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LVD_ID = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails findLeave(@Bind("leaveId") int leaveId);

 /**
  *
  * @param lvdManagerComments of the manager
  * @param lvdLeaveStatus of the employee
  * @param lvdId of the employee
  */

  @SqlUpdate("UPDATE LEAVE_DETAILS SET LVD_MANAGER_COMMENTS = :managerComments, LVD_LEAVE_STATUS=:leaveStatus where "
      + "LVD_ID =:lvdId")
  void mgrcommnets(@Bind("managerComments") String lvdManagerComments, @Bind("leaveStatus") String lvdLeaveStatus,
      @Bind("lvdId") int lvdId);

    /**
     * return all the details of the selected employee.
     * @param empId the id of the employee
     * @return the employee object
     */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> empHistory(@Bind("empId") int empId);

  /**
   * return all the details of the selected Leavedetails.
   * @param empId the id of the Leavedetails
   * @return the Leavedetails object
   */

  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE "
      + " EMP_ID IN "
      + " (SELECT E2.EMP_ID FROM "
      + " EMPLOYEE E1 INNER JOIN "
      + " EMPLOYEE E2 ON E1.EMP_ID = E2.EMP_MANAGER_ID "
      + " WHERE E1.EMP_ID = :empId)  AND "
      + " LVD_LEAVE_STATUS ='PENDING' ")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> pending(@Bind("empId") int empId);

    /**
     * insert all the details of the employee leave.
     * @param empId       the employee id of the employee.
     * @param sDate       the start date of the employee.
     * @param eDate       the end date of the employee.
     * @param days        the number of days of the employee.
     * @param ltype       the leaveType details of employee.
     * @param reason      the reason for applying.
     * @param appliedDate the applied date of the employee.
     */
  @SqlUpdate("insert into LEAVE_DETAILS  " + "  (EMP_ID, "
            + "  LVD_NO_OF_DAYS, " + "   LVD_START_DATE, " + " LVD_END_DATE, "
            + "  LVD_LEAVE_TYPE, " + "LVD_REASON, "
            + "  LVD_APPLIED_ON) " + "values ( " + " :empId, "
            + "  :nodays, " + " :startDate, " + " :endDate, "
            + "  :leavetype, " + ":leavereason, "
            + "  :appliedOn)")

  void insert(@Bind("empId") int empId, @Bind("nodays") long days,
            @Bind("startDate") String sDate, @Bind("endDate") String eDate, @Bind("leavetype") String ltype,
            @Bind("leavereason") String reason, @Bind("appliedOn") String appliedDate);

    /**
     * return all the details of the selected employee.
     * @param empID     the id of the employee.
     * @param startDate leaveStartDate of employee.
     * @param endDate   leaveEndDate of employee.
     * @return the total record count.
     */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS " + " WHERE EMP_ID = :empID"
      + " AND (LVD_START_DATE BETWEEN :startDate AND :endDate " + " OR LVD_END_DATE BETWEEN :startDate AND :endDate )")
  int count(@Bind("empID") int empID, @Bind("startDate") String startDate, @Bind("endDate") String endDate);

    /**
     * insert all the details of the employee leave.
     * @param empId the employee id of the employee.
     */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LVD_LEAVE_STATUS = 'APPROVED' WHERE EMP_ID = :empId")
  void updateCEO(@Bind("empId") int empId);

    /**
    * close with no args is used to close the connection.
    */
  void close();

}
