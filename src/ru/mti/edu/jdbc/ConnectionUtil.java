package ru.mti.edu.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnection(String url, String user, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// загрузка драйвера СУБД
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection() {
		DbInfo info = getInfo();
		return getConnection(info.url, info.user, info.password);
	}
	
	public static DbInfo getInfo(){
		Properties data = new Properties();
		try {
			data.load(Files.newInputStream(Paths.get(System.getProperty("user.dir"), "src\\ru\\mti\\edu\\jdbc\\database.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DbInfo result = new DbInfo();
		result.url = data.getProperty("connection.url");
		result.user = data.getProperty("connection.user");
		result.password = data.getProperty("connection.password");
		
		return result;
	}
}
