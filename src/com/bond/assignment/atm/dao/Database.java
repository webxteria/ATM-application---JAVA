package com.bond.assignment.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection conn;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet rs;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection connectDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/atm", "root", "");
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
		return this.conn;
	}

	public PreparedStatement query(Connection connection, String query) throws SQLException {
		return connection.prepareStatement(query);

	}

	public void disconnectDatabase(Connection conn) throws SQLException {
		conn.close();
	}

	public ResultSet retriveData(String query) throws SQLException {
		conn = connectDatabase();
		statement = this.conn.createStatement();
		rs = statement.executeQuery(query);
		return rs;
	}

	public boolean updateData(String query) throws SQLException {
		conn = connectDatabase();
		preparedStatement = query(this.conn, query);
		preparedStatement.executeUpdate();
		return false;
	}

}
