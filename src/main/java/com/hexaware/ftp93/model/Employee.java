package com.hexaware.ftp93.model;

import com.hexaware.ftp93.persistence.DbConnection;
import com.hexaware.ftp93.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.Date;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {
  /**
   * empId to store employee id.
   */
  private int empId;
  private String empName;
  private String empEmail;
  private long empMobileNo;
  private Date empDoj;
  private String empDept;
  private int empLeaveBalanceEL;
  private int empLeaveBalanceSL;
  private int empLeaveBalanceML;
  private int empManagerId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empMobileNo, emp.empMobileNo)
        && Objects.equals(empDoj, emp.empDoj)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empLeaveBalanceEL, emp.empLeaveBalanceEL)
        && Objects.equals(empLeaveBalanceSL, emp.empLeaveBalanceSL)
        && Objects.equals(empLeaveBalanceML, emp.empLeaveBalanceML)
        && Objects.equals(empManagerId, emp.empManagerId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empEmail, empMobileNo, empDoj, empDept, empLeaveBalanceEL, empLeaveBalanceSL,
        empLeaveBalanceML, empManagerId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argEmpId             to initialize employee id.
   * @param argEmpDept           to initialize employee department
   * @param argEmpLeaveBalanceEL to initialize employee leave balance
   * @param argEmpLeaveBalanceSL to initialize employee leave balance
   * @param argEmpLeaveBalanceML to initialize employee leave balance
   * @param argManagerId         to initialize employee manager
   * @param argEmpName           to initialize employee name
   * @param argEmpEmail          to initialize employee email
   * @param argMobileNo          to initialize employee mobile number
   * @param argEmpDoj            to initialize employee id.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail,
      final long argMobileNo, final Date argEmpDoj, final String argEmpDept, final int argEmpLeaveBalanceEL,
      final int argEmpLeaveBalanceSL, final int argEmpLeaveBalanceML, final int argManagerId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empMobileNo = argMobileNo;
    this.empDoj = argEmpDoj;
    this.empDept = argEmpDept;
    this.empLeaveBalanceEL = argEmpLeaveBalanceEL;
    this.empLeaveBalanceSL = argEmpLeaveBalanceSL;
    this.empLeaveBalanceML = argEmpLeaveBalanceML;
    this.empManagerId = argManagerId;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee id.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }
  /**
   * @param argEmpEmail to set employee id.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
  /**
   * Gets the EmployeeMobile number.
   * @return this Employee's Mobile number.
   */
  public final long getEmpMobileNo() {
    return empMobileNo;
  }
  /**
   *
   * @param argEmpMobileNo to set employee id.
   */
  public final void setEmpMobileNo(final long argEmpMobileNo) {
    this.empMobileNo = argEmpMobileNo;
  }
  /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }
   /**
   *
   * @param argEmpDoj to set employee id.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }
  /**
   * Gets the Employee Department.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }
  /**
   *
   * @param argEmpDept to set employee id.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
  /**
   * Gets the EmployeeLeaveBalanceEL.
   * @return this Employee's leave balanceEL.
   */
  public final int getEmpLeaveBalanceEL() {
    return empLeaveBalanceEL;
  }
  /**
   *
   * @param argEmpLeaveBalanceEL to set employee id.
   */
  public final void setEmpLeaveBalanceEL(final int argEmpLeaveBalanceEL) {
    this.empLeaveBalanceEL = argEmpLeaveBalanceEL;
  }
  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's leave balanceSL.
   */
  public final int getEmpLeaveBalanceSL() {
    return empLeaveBalanceSL;
  }
  /**
   *
   * @param argEmpLeaveBalanceSL to set employee id.
   */
  public final void setEmpLeaveBalanceSL(final int argEmpLeaveBalanceSL) {
    this.empLeaveBalanceSL = argEmpLeaveBalanceSL;
  }
  /**
   * Gets the EmployeeLeaveBalanceML.
   * @return this Employee's leave balanceML.
   */
  public final int getEmpLeaveBalanceML() {
    return empLeaveBalanceML;
  }
  /**
   *
   * @param argEmpLeaveBalanceML to set employee id.
   */
  public final void setEmpLeaveBalanceML(final int argEmpLeaveBalanceML) {
    this.empLeaveBalanceML = argEmpLeaveBalanceML;
  }
  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's ManagerId.
   */
  public final int getEmpManagerId() {
    return empManagerId;
  }
  /**
   *
   * @param argEmpManagerId to set employee id.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.empManagerId = argEmpManagerId;
  }
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
  @Override
  public final String toString() {
    return "empId" + empId + "empName" + empName + "empMail" + empEmail + "empMobileNo" + empMobileNo + "empDoj"
           + empDoj + "empdept" + empDept + "empleavebalanceEL" + empLeaveBalanceEL + "empleavebalanceSL"
        + empLeaveBalanceSL + "empleavebalanceML" + empLeaveBalanceML + "empmgrid" + empManagerId;

  }
}

