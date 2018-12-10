package com.hexaware.ftp93.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp93.model.LeaveDetails;
import com.hexaware.ftp93.model.LeaveStatus;
import com.hexaware.ftp93.model.LeaveType;
/**
 * Mapper class to map from result set to Leavedetails object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
    /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped Leavedetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return Leavedetails
     */
    return new LeaveDetails(rs.getInt("EMP_ID"), rs.getInt("LVD_ID"), rs.getInt("LVD_NO_OF_DAYS"),
        rs.getDate("LVD_START_DATE"), rs.getDate("LVD_END_DATE"), LeaveType.valueOf(rs.getString("LVD_LEAVE_TYPE")),
        LeaveStatus.valueOf(rs.getString("LVD_LEAVE_STATUS")), rs.getString("LVD_REASON"), rs.getDate("LVD_APPLIED_ON"),
        rs.getString("LVD_MANAGER_COMMENTS"));
  }
}
