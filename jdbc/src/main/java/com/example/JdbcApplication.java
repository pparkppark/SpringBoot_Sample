package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@EnableAutoConfiguration
@ComponentScan
public class JdbcApplication implements CommandLineRunner {
	
//	@Autowired
//	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", "1");
		
		//Anonymous class
//		Customer result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Customer>() {
//			@Override
//			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//				// TODO Auto-generated method stub
//				return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
//			}
//		});
		
		//lambda expression
//		Customer result = jdbcTemplate.queryForObject(sql, param, 
//				(rs, rowNum)->new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
//		
//		System.out.println("result = " + result);
		
		Customer created = customerRepository.save(new Customer(null, "hideyosi", "deki"));
		System.out.println(created + " is created");
		
		customerRepository.findAll().forEach(System.out::println);
	}



	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}
}
