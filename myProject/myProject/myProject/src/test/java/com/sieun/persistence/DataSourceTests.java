package com.sieun.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //?Öå?ä§?ä∏ ÏΩîÎìúÍ∞? ?ä§?îÑÎßÅÏùÑ ?ã§?ñâ
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//Ïß??†ï?êú ?Å¥?ûò?ä§?Çò Î¨∏Ïûê?ó¥?ùÑ ?ù¥?ö©?ï¥?Ñú ?ïÑ?öî?ïú Í∞ùÏ≤¥?ì§?ùÑ ?ä§?îÑÎß? ?Ç¥?óê Í∞ùÏ≤¥Î°? ?ì±Î°?
@Log4j
public class DataSourceTests {
	@Setter (onMethod_=@Autowired)
	private DataSource dataSource;
	
	@Setter (onMethod_=@Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true);
				Connection conn = sqlSession.getConnection()) {
				log.info("sqlSession : "+sqlSession);
				log.info("connection : "+conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
/*	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			log.info(conn);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}*/
}
