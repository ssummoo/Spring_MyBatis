package kr.co.softsoldesk.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.co.softsoldesk.mapper.MapperInterface;

@Configuration
@ComponentScan(basePackages = {"kr.co.softsoldesk.beans"})
public class BeanConfigClass {
	
	//DataSource
	@Bean
	public BasicDataSource source() {
		BasicDataSource source= new BasicDataSource();
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		source.setUsername("system");
		source.setPassword("12345");
		
		return source;
		
	}
	//ibatis lib => SqlSessionFactory : jdbc를 처리하는 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{ 
		//SqlSessionFactory에 대한 객체를 만들기 위해서 SqlSessionFactoryBean
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory=factoryBean.getObject();
		
		return factory;
	}
	//Mapper
	@Bean
	public MapperFactoryBean<MapperInterface> test_mapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
}
