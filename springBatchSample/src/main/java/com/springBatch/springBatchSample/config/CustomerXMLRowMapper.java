package com.springBatch.springBatchSample.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springBatch.springBatchSample.entity.Customer;

public class CustomerXMLRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("customer_id"));
		customer.setContactNo(rs.getString("contact"));
		customer.setCountry(rs.getString("country"));
		customer.setDob(rs.getString("Dob"));
		customer.setEmail(rs.getString("email"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setGender(rs.getString("gender"));
		customer.setLastName(rs.getString("last_name"));
		return customer;
	}
}
