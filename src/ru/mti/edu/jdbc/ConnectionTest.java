package ru.mti.edu.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stat = null;
		CallableStatement callableStatement = null;
		try {
			conn = ConnectionUtil.getConnection();
//			Statement stat = conn.createStatement();
			stat = conn.prepareStatement("select * from emp e where e.empno = ?");
			String number = "7369 or 1=1";
			stat.setInt(1, 7369);
//			stat.setString(1, number);
//			ResultSet rs = stat.executeQuery("select * from emp e where e.empno = " + number);
			ResultSet rs = stat.executeQuery();
//			rs.beforeFirst();
			while(rs.next()){
				Object empNo = rs.getInt("empno"); // 0
				if (rs.wasNull()){
					empNo = null;
				}
				String empName = rs.getString("ename");
				System.out.println(empNo + " " + empName);
			}
			ResultSetMetaData rsmd =  rs.getMetaData();
			rs.close();
			stat.close();
//			rsmd.getColumnName(column)
			DatabaseMetaData dbmd = conn.getMetaData();
			
			conn.setAutoCommit(false);
			
			callableStatement = conn.prepareCall("{ call raise_application_error(?, ?) }");
			callableStatement.setInt(1, -20001);
			callableStatement.setString(2, "Вылетела птичка");
			callableStatement.execute();
			
			conn.commit();
			
			
			conn.rollback();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		finally {
			try {
				if (callableStatement != null) callableStatement.close();
				if (stat != null) stat.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
