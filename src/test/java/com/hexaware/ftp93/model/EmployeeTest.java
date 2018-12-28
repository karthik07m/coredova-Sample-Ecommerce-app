package com.hexaware.ftp93.model;

import com.hexaware.ftp93.persistence.EmployeeDAO;

//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
  }


  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testGettersSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj = new Employee(3002, "Pratyusha", "pratyusha423@hexaware.com", 9874563214L, sdf.parse("2018-10-11"),
        "Trainee", 6, 12, 15, 2000);
    obj.setEmpId(3002);
    obj.setEmpName("Pratyusha");
    obj.setEmpEmail("pratyusha423@hexaware.com");
    obj.setEmpMobileNo(9874563214L);
    obj.setEmpDoj(sdf.parse("2018-10-11"));
    obj.setEmpDept("Trainee");
    obj.setEmpLeaveBalanceEL(6);
    obj.setEmpLeaveBalanceSL(12);
    obj.setEmpLeaveBalanceML(15);
    obj.setEmpManagerId(2000);
    assertEquals(3002, obj.getEmpId());
    assertEquals("Pratyusha", obj.getEmpName());
    assertEquals("pratyusha423@hexaware.com", obj.getEmpEmail());
    assertEquals(9874563214L, obj.getEmpMobileNo());
    assertEquals(sdf.parse("2018-10-11"), obj.getEmpDoj());
    assertEquals("Trainee", obj.getEmpDept());
    assertEquals(6, obj.getEmpLeaveBalanceEL());
    assertEquals(12, obj.getEmpLeaveBalanceSL());
    assertEquals(15, obj.getEmpLeaveBalanceML());
    assertEquals(2000, obj.getEmpManagerId());
    Employee ee1 = null;
    //assertFalse(obj.equals(ee1));
   // LeaveDetails l1 = new LeaveDetails();
    //assertFalse(obj.equals(l1));
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }

  /**
   * Test Method for Employee.
   * @throws ParseException parse exception
   */
  @Test
  public final void testEqualsHashCode() throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    String doj = "2018-10-11";
    Date dateOfJoin = sf.parse(doj);
    Employee e = new Employee(3001, "Mani Karthik", "Karthik453@hexaware.com", 9956382741L, dateOfJoin, "Trainee", 2,
        13, 15, 2001);
    assertEquals(new Employee(3001, "Mani Karthik", "Karthik453@hexaware.com", 9956382741L, dateOfJoin, "Trainee", 2,
        13, 15, 2001), e);
    assertEquals(new Employee(3001, "Mani Karthik", "Karthik453@hexaware.com", 9956382741L, dateOfJoin, "Trainee", 2,
        13, 15, 2001)
            .hashCode(),
        e.hashCode());
  }

  /**
   * Test Method for Employee.
   * @throws ParseException parse exception
   */
  @Test
  public final void testTOString() throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    String doj = "2018-10-11";
    Date dateOfJoin = sf.parse(doj);
    Employee e = new Employee(3001, "Mani Karthik", "Karthik453@hexaware.com", 9956382741L, dateOfJoin, "Trainee", 2,
        13, 15, 2001);
    String exp = "empId" + e.getEmpId() + "empName" + e.getEmpName() + "empMail" + e.getEmpEmail() + "empMobileNo"
        + e.getEmpMobileNo() + "empDoj" + e.getEmpDoj() + "empdept" + e.getEmpDept() + "empleavebalanceEL"
        + e.getEmpLeaveBalanceEL() + "empleavebalanceSL" + e.getEmpLeaveBalanceSL() + "empleavebalanceML"
        + e.getEmpLeaveBalanceML() + "empmgrid" + e.getEmpManagerId();
    assertEquals(exp, e.toString());
  }
}
