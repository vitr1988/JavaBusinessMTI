package ru.mti.edu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection();
//			Statement stat = conn.createStatement();
			PreparedStatement stat = conn.prepareStatement("select * from emp e where e.empno = ?");
			String number = "7369 or 1=1";
			stat.setInt(1, 7369);
//			stat.setString(1, number);
			ResultSet rs = stat.executeQuery(/*"select * from emp e where e.empno = " + number*/);
			
//			rs.beforeFirst();
			while(rs.next()){
				Integer empNo = rs.getInt("empno");
				String empName = rs.getString("ename");
				System.out.println(empNo + " " + empName);
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
