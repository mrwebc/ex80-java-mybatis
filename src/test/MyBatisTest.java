package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import common.MyBatisManager;
import model.MemberDTO;

public class MyBatisTest {
  

  //@Test
  public void testSqlSessionFactory() {    
    //마이바티즈 설정정보를 가진 객체변수 
    SqlSessionFactory sessionFactory = MyBatisManager.getSqlSessionFactory();    
    assertNotNull(sessionFactory);    
    
    //SQL작업을 담당한 sqlSession 객체 생성
    SqlSession sqlSession = sessionFactory.openSession(true);//기본값 false = Not autoCommit    
    assertNotNull(sqlSession);
  }//end of testSqlSessionFactory()
  
  
  @Test
  public void testInsertMember() {
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    
    MemberDTO m = new MemberDTO();
    m.setMemberid("kbs");
    m.setName("김복실");
    m.setPw(9999);
    m.setPhone("1234");
    m.setEmail("kbs@nate.com");
    m.setRegtime(Calendar.getInstance().getTime());
    
    int result = sqlSession.insert("testMember.insertMember", m);
    assertEquals(1, result);
    
    if(result>0) {
      sqlSession.commit();
    }else {
      sqlSession.rollback();
    }
   
    sqlSession.close();
    
  }
  
}





























