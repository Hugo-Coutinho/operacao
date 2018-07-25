package persistence;

import java.sql.CallableStatement; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	PreparedStatement stmt;
	ResultSet rs;
	Connection con;
	CallableStatement call;

	public void open() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system01", "root", "coti");

	}

	public void close() throws Exception {
		con.close();
	}

}
