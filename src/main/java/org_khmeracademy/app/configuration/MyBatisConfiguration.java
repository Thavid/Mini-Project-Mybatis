package org_khmeracademy.app.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("org_khmeracademy.app.repository")
public class MyBatisConfiguration {
	private DataSource datasource;
	@Autowired
	public MyBatisConfiguration(DataSource dataSource){
		this.datasource=dataSource;
	}
	@Bean
	public DataSourceTransactionManager transactionmanger(){
		return new DataSourceTransactionManager(datasource);
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(datasource);
		return sessionFactoryBean;
	}
	
	
	

}
