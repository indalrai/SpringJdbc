package com.Spring.Jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.Spring.Jdbc.dao.StudentDao;
import com.Spring.Jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.Spring.Jdbc.dao"})
public class JdbcConfig {

	@Bean(name={"ds"})
	public DataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Indal@123");
		return ds;

	}

	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;

	}
	
	/*@Bean (name={"studentDao"})
	public StudentDao getStudentDao() {
		
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;*/
		
		
	/* } */
}
