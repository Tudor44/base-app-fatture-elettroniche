package it.gaetano.fattura.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SqlLiteConfiguration {
	
	@Autowired 
	Environment env;

	@Bean
	public DataSource dataSource() {
	    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));
	    dataSource.setUsername(env.getProperty("sqlite.user"));
	    dataSource.setPassword(env.getProperty("sqlite.password"));
	    return dataSource;
	}

}
