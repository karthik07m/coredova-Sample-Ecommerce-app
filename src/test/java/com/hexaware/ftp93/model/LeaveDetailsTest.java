package com.hexaware.ftp93.model;

//import com.hexaware.ftp93.persistence.LeaveDetailsDAO;
//import com.hexaware.ftp93.persistence.LeaveDetails;
import com.hexaware.ftp93.persistence.LeaveDetailsDAO;

import org.junit.Test;


//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNull;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
* Test class for Employee.
 */
public class LeaveDetailsTest {

  /**
   * leavemanagercomm to store manager comments.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testLeaveDetailsGetter() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-13");
    Date date2 = sdf.parse("2018-11-15");
    Date date3 = sdf.parse("2018-11-10");
    LeaveDetails ld = new LeaveDetails(3000, 1230, 3, date1, date2, LeaveType.EL, LeaveStatus.APPROVED, "fever", date3,
         "Always taking leaves");
    assertEquals(1230, ld.getLvdId());
    assertEquals(3000, ld.getEmpId());
    assertEquals(sdf.parse("2018-11-13"), ld.getLvdStartDate());
    assertEquals(sdf.parse("2018-11-15"), ld.getLvdEndDate());
    assertEquals(3, ld.getLvdNoOfDays());
    assertEquals(LeaveType.EL, ld.getLvdLeaveType());
    assertEquals(LeaveStatus.APPROVED, ld.getLvdLeaveStatus());
    assertEquals("fever", ld.getLvdReason());
    assertEquals(sdf.parse("2018-11-10"), ld.getLvdAppliedOn());
    assertEquals("Always taking leaves", ld.getManagerComments());
    LeaveDetails ld1 = null;
  }

  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testLeaveDetailsSetters() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = (Date) sdf.parse("2018-11-13");
    Date date2 = (Date) sdf.parse("2018-11-15");
    Date date3 = (Date) sdf.parse("2018-11-10");
    LeaveDetails ld = new LeaveDetails(3000, 1230, 3, date1, date2, LeaveType.EL, LeaveStatus.APPROVED, "fever", date3,
        "Always taking leaves");
    ld.setLvdId(1230);
    ld.setEmpId(3000);
    ld.setStartDate(sdf.parse("2018-11-13"));
    ld.setEndDate(sdf.parse("2018-11-15"));
    ld.setLvdNoOfDays(3);
    ld.setLvdLeaveType(LeaveType.EL);
    ld.setLvdLeaveStatus(LeaveStatus.PENDING);
    ld.setLvdReason("fever");
    ld.setLvdAppliedOn(sdf.parse("2018-11-10"));
    ld.setLvdManagerComments("Always taking leaves");

    assertEquals(1230, ld.getLvdId());
    assertEquals(3000, ld.getEmpId());
    assertEquals(sdf.parse("2018-11-13"), ld.getLvdStartDate());
    assertEquals(sdf.parse("2018-11-15"), ld.getLvdEndDate());
    assertEquals(3, ld.getLvdNoOfDays());
    assertEquals(LeaveType.EL, ld.getLvdLeaveType());
    assertEquals(LeaveStatus.PENDING, ld.getLvdLeaveStatus());
    assertEquals("fever", ld.getLvdReason());
    assertEquals(sdf.parse("2018-11-10"), ld.getLvdAppliedOn());
    assertEquals("Always taking leaves", ((LeaveDetails) ld).getManagerComments());
  }

  /**
   * Tests the testToString methods of the LeaveDetails class.
   * @throws ParseException throws parse exception.
   */
  @Test
  public final void testToString() throws ParseException {
    DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    Date d1 = df.parse("2018-12-20");
    Date d2 = df.parse("2018-12-23");
    Date d3 = df.parse("2018-12-19");
    LeaveDetails ld1 = new LeaveDetails(3000, 1230, 3, d1, d2, LeaveType.EL, LeaveStatus.DENIED, "Fever", d3, "Denied");
    String exp = "EmployeeID:" + ld1.getEmpId() + "LeaveId:" + ld1.getLvdId() + "NoOfDays:" + ld1.getLvdNoOfDays()
        + "StartDate:" + ld1.getLvdStartDate() + "EndDate:" + ld1.getLvdEndDate() + "lvdleavetype:"
        + ld1.getLvdLeaveType() + "lvdstatus:" + ld1.getLvdLeaveStatus() + "lvdReason:" + ld1.getLvdReason()
        + "lvdAppliedOn:" + ld1.getLvdAppliedOn() + "lvdmanagercomments:" + ld1.getManagerComments();
    String act = ld1.toString();
    assertEquals(exp, act);
  }

  /**
   * Tests the testEqualsHashCode methods of the LeaveDetails class.
   * @throws ParseException throws parse exception.
   */
  @Test
  public final void testEqualsHashCode() throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    Date d1 = df.parse("2018-12-20");
    Date d2 = df.parse("2018-12-23");
    Date d3 = df.parse("2018-12-19");
    LeaveDetails ld2 = new LeaveDetails(3000, 1230, 3, d1, d2, LeaveType.EL, LeaveStatus.DENIED, "Fever", d3, "Denied");
    assertEquals(new LeaveDetails(3000, 1230, 3, d1, d2, LeaveType.EL, LeaveStatus.DENIED, "Fever", d3, "Denied"), ld2);
    assertEquals(
        new LeaveDetails(3000, 1230, 3, d1, d2, LeaveType.EL, LeaveStatus.DENIED, "Fever", d3, "Denied").hashCode(),
        ld2.hashCode());
  }
/**
 * Tests that a list with some employee pending is handled correctly.
 * @param dao mocking the dao class
 * @throws ParseException mocking the dao class
 */
  @Test
  public final void testLeavePending(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    new Expectations() {
      {
        final ArrayList<LeaveDetails> emp1 = new ArrayList<LeaveDetails>();
        emp1.add(new LeaveDetails(3000, 1230, 3, sdf.parse("2018-12-20"), sdf.parse("2018-12-23"), LeaveType.EL,
            LeaveStatus.PENDING, "Fever", sdf.parse("2018-12-19"), null));
        emp1.add(new LeaveDetails(3001, 1231, 2, sdf.parse("2018-12-18"), sdf.parse("2018-12-20"), LeaveType.EL,
            LeaveStatus.PENDING, "function", sdf.parse("2018-12-12"), null));
        emp1.add(new LeaveDetails(3002, 1232, 1, sdf.parse("2018-12-21"), sdf.parse("2018-12-24"), LeaveType.EL,
            LeaveStatus.PENDING, "function", sdf.parse("2018-12-26"), null));
        dao.pending(3000);
        result = emp1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] pending = new LeaveDetails[3];
    pending[0] = new LeaveDetails(3000, 1230, 3, sdf.parse("2018-12-20"), sdf.parse("2018-12-23"), LeaveType.EL,
    LeaveStatus.PENDING, "Fever", sdf.parse("2018-12-19"), null);
    pending[1] = new LeaveDetails(3001, 1231, 2, sdf.parse("2018-12-18"), sdf.parse("2018-12-20"), LeaveType.EL,
            LeaveStatus.PENDING, "function", sdf.parse("2018-12-12"), null);
    pending[2] = new LeaveDetails(3002, 1232, 1, sdf.parse("2018-12-21"), sdf.parse("2018-12-24"), LeaveType.EL,
    LeaveStatus.PENDING, "function", sdf.parse("2018-12-26"), null);
    LeaveDetails[] ld1 = LeaveDetails.listPending(3000);
    assertArrayEquals(pending, ld1);
  }

 /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
    public final void testEmployeeHistory(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        final ArrayList<LeaveDetails> em = new ArrayList<LeaveDetails>();
        em.add(new LeaveDetails(3003, 1275, 2, sdf.parse("2018-11-19"), sdf.parse("2018-11-21"), LeaveType.EL,
            LeaveStatus.PENDING, "Health problem", sdf.parse("2018-11-19"), "NULL"));
        em.add(new LeaveDetails(3001, 1231, 2, sdf.parse("2018-12-18"), sdf.parse("2018-12-20"), LeaveType.EL,
            LeaveStatus.DENIED, "function", sdf.parse("2018-12-12"), "Always taking leaves"));
        em.add(new LeaveDetails(3004, 2548, 2, sdf.parse("2018-11-19"), sdf.parse("2018-11-21"), LeaveType.EL,
            LeaveStatus.APPROVED, "Health problem", sdf.parse("2018-11-19"), "Granted"));
        dao.empHistory(3003);
        result = em;
        }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
        }
    };
    LeaveDetails[] leave = new LeaveDetails[3];
    leave[0] = new LeaveDetails(3003, 1275, 2, sdf.parse("2018-11-19"), sdf.parse("2018-11-21"), LeaveType.EL,
            LeaveStatus.PENDING, "Health problem", sdf.parse("2018-11-19"), "NULL");
    leave[1] = new LeaveDetails(3001, 1231, 2, sdf.parse("2018-12-18"), sdf.parse("2018-12-20"), LeaveType.EL,
            LeaveStatus.DENIED, "function", sdf.parse("2018-12-12"), "Always taking leaves");
    leave[2] = new LeaveDetails(3004, 2548, 2, sdf.parse("2018-11-19"), sdf.parse("2018-11-21"), LeaveType.EL,
            LeaveStatus.APPROVED, "Health problem", sdf.parse("2018-11-19"), "Granted");
    LeaveDetails[] emp =  LeaveDetails.leaveHis(3003);
    assertArrayEquals(leave, emp);
  }
  /**
   * Test to check the functionalty of approveDeny.
   * @param dao to mock the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
  public final void testapplyProcess(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    //Date today = new Date();
    new Expectations()
    {
      {
        dao.insert(3001, 2, "2018-12-29", "2018-12-30", "SL", "function", "2018-12-28");
      }
    };
    new MockUp<LeaveDetails>()
    {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    new Expectations() {
      {
        dao.updateCEO(1000);
      }
    };
    new Expectations() {
      {
        dao.count(3001, "2018-12-29", "2018-12-30");
      }
    };
    // new Expectations() {
    //   {
    //     edao.updateBal(3001, 2);
    //   }
    // };
    // new MockUp<Employee>()
    // {
    //   @Mock
    //   EmployeeDAO edao() {
    //     return edao;
    //   }
    // };

    String act = LeaveDetails.applyProcess(3001, "2018-12-29", "2018-12-30", "SL", "function");
    String exp =  "**** Your leave request succcessfully recored " + "form :" + "2018-12-29"
                + " - " + "2018-12-30" + " for: " + 2 + "days" + " ****";
    assertEquals(exp, act);
    String actual = LeaveDetails.applyProcess(2000, "2018-12-31", "2019-01-01", "ML", "function");
    String expec =  "**** Your leave request succcessfully recored " + "form :" + "2018-12-31"
                + " - " + "2019-01-01" + " for: " + 2 + "days" + " ****";
    assertEquals(expec, actual);
    int ac = LeaveDetails.countNo(3001, "2018-12-28", "2018-12-29");
    int ex = 0;
    assertEquals(ex, ac);
    /*String ac = edao.updateBal(3001, 3);
    String ex = "**** Your leave request succcessfully recored " + "form :" + "2018-12-22"
                + " - " + "2018-12-23" + " for: " + 2 + "days" + " ****";
    assertEquals(ex, ac);*/
  }
 /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException mocking the dao class
   */
  @Test
  public final void testMgrComments(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yy");
    final LeaveDetails ld = new LeaveDetails(3000, 100, 2, sd.parse("2018-12-08"), sd.parse("2018-12-09"), LeaveType.EL,
        LeaveStatus.APPROVED, "fever", sd.parse("2018-12-05"), "approve");
    final LeaveDetails ld2 = new LeaveDetails(3001, 100, 2, sd.parse("2018-12-08"), sd.parse("2018-12-09"),
        LeaveType.EL, LeaveStatus.DENIED, "fever", sd.parse("2018-12-05"), "approve");
    new Expectations() {
      {
        dao.findLeave(100);
        result = ld;
        result = ld2;
      }
    };
    new Expectations() {
      {
        dao.mgrcommnets("approve", "APPROVED", 100);
        dao.mgrcommnets("approve", "DENIED", 100);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
        }
    };
    String act = LeaveDetails.managerAction(2000, 1, "APPROVED", "approve");
    String exc = "Approved Successfully";
    assertEquals(exc, act);
    // String act1 = LeaveDetails.managerAction(2000, 1, "DENIED", "approve");
    // String exc1 = "Denied Permission";
    // assertEquals(exc1, act1);
    // String act2 = LeaveDetails.managerAction(3000, 5, "DENIED", "approve");
    // String exc2 = "You are not authorized!!";
    // assertEquals(exc2, act2);
    // String act3 = LeaveDetails.managerAction(2000, 1, "APPROVED", "approve");
    // String exc3 = "**** You have already aprroved ****";
    // assertEquals(exc3, act3);
  }
}
