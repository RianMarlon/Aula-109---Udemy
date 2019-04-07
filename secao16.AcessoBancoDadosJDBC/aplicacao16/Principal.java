package aplicacao16;

import java.sql.Connection;

import db16.DB;

public class Principal {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		DB.closeConnection();

	}

}
