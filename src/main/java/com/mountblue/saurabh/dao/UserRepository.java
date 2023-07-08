package com.mountblue.saurabh.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mountblue.saurabh.model.User;

public class UserRepository {

	public static Boolean isValidUser(User user) {

		String userId = user.getUserId();
		String password = user.getPassword();

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contact_us",
					"postgres", "S@0916");

			Statement statement = connection.createStatement();

			String users = "SELECT * FROM users where userid = 'Admin@12'";
			ResultSet resultSet = statement.executeQuery(users);

			while (resultSet.next()) {
				String userid = resultSet.getString("userid");
				String pass = resultSet.getString("password");

				if (userid.equals(userId) && pass.equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
