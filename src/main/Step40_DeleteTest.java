package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step40_DeleteTest {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit
    
    /*
    트랜잭션 처리란?
    
    예) 1개의 서비스 처리실패 = insert(ok-취소) + delete(ok-취소) + update(실패) -> rollback 되돌림처리
    예) 1개의 서비스 처리성공 = insert(ok) + delete(ok) + update(ok) -> commit 반영처리
    
    insert, delete, update 문장 - DB에 바로 반영하지 말고 commit()/rollback()으로 최종 결정
    sqlSession이 제공하는 commit() 또는 rollback() 메소드를 호출하는 것과 동시에 트랜잭션이 종료된다.
    트랜잭션에 대한 제어를 마이바티즈가 담당한다. (스프링 사용시 스프링에 위임)
  */

      String memberid = "duly";
      int result = sqlSession.delete("member.deleteById",memberid);
      
      if(result>0) {
        sqlSession.commit();
        System.out.println("result = "+result);
      }else {
        sqlSession.rollback();
      }
      
      sqlSession.close();      

  }

}
