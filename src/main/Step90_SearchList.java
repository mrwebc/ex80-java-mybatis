package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step90_SearchList {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit
    
      
      //1. 직접 테이블의 필드명과 값을 저장한 Map 객체를 통해 검색하기
      //Map<String,String> map = new HashMap<String,String>();
      //map.put("field", "name");
      //map.put("value", "하니");      
      //List<MemberDTO> list = sqlSession.selectList("member.searchMap", map);
    
    
      //2. DTO 객체를 이용해 검색하기
      MemberDTO mDTO = new MemberDTO();
//      mDTO.setMemberid("duly");  
//      mDTO.setEmail("hani@naver.com");
//      mDTO.setPhone("010-8888-1234");
      mDTO.setName("하니");
      List<MemberDTO> list = sqlSession.selectList("member.searchDTO", mDTO);

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
