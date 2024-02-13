package main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step91_SQL_Include {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit
    

    
      MemberDTO mDTO = new MemberDTO();
      mDTO.setMemberid("duly");
      
      //자주 사용하는 구문을 부품으로 등록하여 활용
      List<MemberDTO> list = sqlSession.selectList("member.sql_include",mDTO);

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
