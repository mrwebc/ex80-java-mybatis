package main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step70_SelectList {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit
    
    
      List<MemberDTO> list = sqlSession.selectList("member.findAll");

      if(list.size() > 0) {
        for(MemberDTO m : list) {
          System.out.println(m.toString());
        }
      }else {
        System.out.println("조회된 데이터가 없습니다.");
      }
      
      sqlSession.close();    
    
  }//end of main

}
