package jmp.spring.ojdbc;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
	public SqlSessionFactory sqlSessionFactory() {
		/* SqlSessionFactory factoryBean = new sqlSessionFactoryBean(); */
		return null;
		
	}
}
