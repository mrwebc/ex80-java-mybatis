package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step60_CountMember {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit

      int countMember = sqlSession.selectOne("member.countById");

      if(countMember > 0) {
        System.out.printf("가입된 회원수는 %d명 입니다.",countMember);      
      }else {
        System.out.println("가입된 회원의 데이터가 없습니다.");
      }
      
      sqlSession.close();   
  }
}
