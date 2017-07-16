package com.hfh9527.demo.core_jobtop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqlInitService {

	void initJobAndCondationsBySql(List<BatJob> batJobsBegin, List<BatJobCond> batJobConds) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		String dbUrl = "jdbc:oracle:thin:@10.130.128.54:1521:server4";
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, "cztesti", "czcb7753");
			Statement stat = conn.createStatement();

			ResultSet rs = stat
					.executeQuery("select cbc.project_code , cbc.batch_no, cbc.job_no, cbc.job_name from comc_bat_ctrl cbc");
			while (rs.next()) {
				BatJob bj = new BatJob();
				bj.setBatchNo(rs.getInt("batch_no"));
				bj.setJobName(rs.getString("job_name"));
				bj.setJobNo(rs.getInt("job_no"));
				bj.setProjectCode(rs.getInt("project_code"));
				batJobsBegin.add(bj);
			}

			rs = stat
					.executeQuery("select cbd.project_code , cbd.batch_no, cbd.job_no, cbd.prev_batch_no, cbd.prev_job_no  from comc_bat_cond cbd");
			while (rs.next()) {
				BatJobCond bjc = new BatJobCond();
				bjc.setBatchNo(rs.getInt("batch_no"));
				bjc.setJobNo(rs.getInt("job_no"));
				bjc.setProjectCode(rs.getInt("project_code"));
				bjc.setPreBatchNo(rs.getInt("prev_batch_no"));
				bjc.setPreJobNo(rs.getInt("prev_job_no"));
				batJobConds.add(bjc);
			}

			System.out.println(batJobsBegin.size() + " " + batJobConds.size());
		} catch (SQLException e) {
			throw e;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw e;
				}
			}
		}
	}
}
