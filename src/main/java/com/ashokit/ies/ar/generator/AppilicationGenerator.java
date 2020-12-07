package com.ashokit.ies.ar.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;
@Component
public class AppilicationGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="A0";
		String suffix = "";
		
		Connection con = session.connection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select app_master_seq.nextval from dual";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				suffix = String.valueOf(rs.getInt(1));
			}
			System.out.println("No issue found");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Issue with this block");
		}
		return prefix+suffix;
	}

}
