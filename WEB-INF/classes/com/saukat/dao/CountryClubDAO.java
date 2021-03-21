package com.saukat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.saukat.bo.CountryClubBO;

public class CountryClubDAO {

	private static final String INSERT_QUERY = "INSERT INTO COUNTRY_CLUB(SNAME,ADDR,COUNTRY,PACKAGE_PRICE,PACKAGE_DISCOUNT,TOTAL_AMOUNT,HOLIDAY_PACKAGE)VALUES(?,?,?,?,?,?,?)";
	public int insert(CountryClubBO bo) {
		int result=0;
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			
			/*con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"postgres");*/
			con = DriverManager.getConnection("jdbc:postgresql://192.168.101.18/postgres", "webadmin",
					"CtD5mcb1Dt");
			
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, bo.getName());
			ps.setString(2, bo.getAddr());
			ps.setString(3, bo.getCountry());
			ps.setInt(4, bo.getPackage_price());
			ps.setFloat(5, bo.getPackage_discount());
			ps.setFloat(6, bo.getTotal_amount());
			ps.setString(7, bo.getHoliday_package());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("<h1>error</h1>");
		}
      return result;
	}
}
