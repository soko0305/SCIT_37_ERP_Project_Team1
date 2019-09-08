package com.project.erp.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {
<<<<<<< HEAD
   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource datasource)throws Exception{
      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
      sqlSessionFactory.setDataSource(datasource);
      sqlSessionFactory.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/*.xml"));
      return (SqlSessionFactory)sqlSessionFactory.getObject();
   }
   
   @Bean
   public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception{
      return new SqlSessionTemplate(sqlSessionFactory);
   }
}
=======
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource)throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(datasource);
		sqlSessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/*.xml"));
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
>>>>>>> b5b77af53318a09b46fb6d2852540d02a47e4821
