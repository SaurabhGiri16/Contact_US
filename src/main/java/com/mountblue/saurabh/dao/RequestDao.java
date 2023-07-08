package com.mountblue.saurabh.dao;

import java.sql.Statement;
import com.mountblue.saurabh.model.Request;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class RequestDao {
	public static void saveRequest(Request request) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contact_us",
					"postgres", "S@0916");

			Statement statement = connection.createStatement();

			String insertQuery = "insert into contact_us(name, email, message,status) values('" + request.getFullName()
					+ "'," + "'" + request.getEmail() + "','" + request.getMessage() + "','Active')";

			statement.executeUpdate(insertQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Request> fetchAllRequests(boolean status_) {
		List<Request> listOfRequests = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contact_us",
					"postgres", "S@0916");

			Statement statement = connection.createStatement();
			String fetchingQuery;
			if (status_) {
				fetchingQuery = "SELECT * from contact_us where status = 'Active' order by name";
			} else {
				fetchingQuery = "SELECT * from contact_us where status != 'Active' order by name";
			}

			ResultSet resultSet = statement.executeQuery(fetchingQuery);

			while (resultSet.next()) {
				Request request = new Request();
				int userId = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String message = resultSet.getString("message");
				String name = resultSet.getString("name");
				String status = resultSet.getString("status");
				String timestamp = resultSet.getString("timestamp");

				request.setFullName(name);
				request.setId(userId);
				request.setEmail(email);
				request.setMessage(message);
				request.setStatus(status);
				request.setTimestamp(timestamp);

				listOfRequests.add(request);
			}

			return (ArrayList<Request>) listOfRequests;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void changeStatus(int requestId, boolean status) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contact_us",
					"postgres", "S@0916");

			Statement statement = connection.createStatement();
			String updateQuery;

			if (status) {
				updateQuery = "UPDATE contact_us SET status = 'Archived' WHERE id = " + requestId;
			} else {
				updateQuery = "UPDATE contact_us SET status = 'Active' WHERE id = " + requestId;
			}

			statement.executeUpdate(updateQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
