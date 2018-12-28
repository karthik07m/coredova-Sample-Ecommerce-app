
package com.hexaware.ftp93.persistence;

import com.hexaware.ftp93.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empId")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empId") int empId);

  /**
   * return all the details of the selected employee.
   * @param empID        the id of the employee
   * @param reaminingBal id of the employee.
   */
  @SqlUpdate("Update employee set EMP_LEAVE_BALANCE_EL = :remainingBal where EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  void updateBalEL(@Bind("empID") int empID, @Bind("remainingBal") int reaminingBal);

  /**
   * return all the details of the selected employee.
   * @param empID        the id of the employee
   * @param reaminingBal id of the employee.
   */
  @SqlUpdate("Update employee set EMP_LEAVE_BALANCE_SL = :remainingBal where EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  void updateBalSL(@Bind("empID") int empID, @Bind("remainingBal") int reaminingBal);

  /**
   * return all the details of the selected employee.
   * @param empID        the id of the employee
   * @param reaminingBal id of the employee.
   */
  @SqlUpdate("Update employee set EMP_LEAVE_BALANCE_ML = :remainingBal where EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  void updateBalML(@Bind("empID") int empID, @Bind("remainingBal") int reaminingBal);

/**
   * close with no args is used to close the connection.
   */
  void close();
}
