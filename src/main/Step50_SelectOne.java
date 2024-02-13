package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step50_SelectOne {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit


      String memberid = "duly";
      MemberDTO m = sqlSession.selectOne("member.getOne",memberid);

      if(m != null) {
        System.out.println(m.toString());      
      }else {
        System.out.println("해당아이디로 조회된 데이터가 없습니다.");
      }
      
      sqlSession.close();      
  }
}
