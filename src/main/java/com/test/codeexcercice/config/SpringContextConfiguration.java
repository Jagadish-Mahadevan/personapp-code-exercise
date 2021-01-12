package com.test.codeexcercice.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.test.codeexcercice.dao.PersonDao;
import com.test.codeexcercice.userinput.UserInteration;
import com.test.codeexcercice.userinput.UserInterationImpl;
import com.test.codeexcercice.userinput.strategy.PersonAddStrategy;
import com.test.codeexcercice.userinput.strategy.PersonCountStrategy;
import com.test.codeexcercice.userinput.strategy.PersonDeleteStrategy;
import com.test.codeexcercice.userinput.strategy.PersonEditStrategy;
import com.test.codeexcercice.userinput.strategy.PersonListStrategy;
import com.test.codeexcercice.userinput.strategy.PersonStrategyFactory;

@Configuration
public class SpringContextConfiguration {

	@Bean
	public UserInteration userInteration() {
		return new UserInterationImpl();
	}

	@Bean
	public PersonDao personDao() {
		return new PersonDao();
	}
	
	@Bean
	public PersonStrategyFactory strategyFactory() {
		return new PersonStrategyFactory();
	}
	
	@Bean
	public PersonAddStrategy addStrategy() {
		return new PersonAddStrategy();
	}
	
	@Bean
	public PersonEditStrategy editStrategy() {
		return new PersonEditStrategy();
	}
	
	@Bean
	public PersonDeleteStrategy deleteStrategy() {
		return new PersonDeleteStrategy();
	}
	
	@Bean
	public PersonListStrategy listStrategy() {
		return new PersonListStrategy();
	}
	
	@Bean
	public PersonCountStrategy countStrategy() {
		return new PersonCountStrategy();
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("schema.sql")
				.build();
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
//		dataSource.setUsername("sa");
//		dataSource.setUrl("jdbc:hsqldb:file:/testdb");
//		Resource initSchema = new ClassPathResource("jdbc/schema.sql");
//		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
//		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
//		return dataSource;
	}
}