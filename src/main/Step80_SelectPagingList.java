package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.MemberDTO;

public class Step80_SelectPagingList {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit
    
    
      //참고 : https://java119.tistory.com/85
    
      //1. 리스트 파라미터를 직접 넘기는 경우
//      List<Integer> listLimit = new ArrayList<Integer>();
//      listLimit.add(0);
//      listLimit.add(3);      
//      List<MemberDTO> list = sqlSession.selectList("member.pagingList_list",listLimit);
//    
    
      //2. 리스트 파라미터를 Map을 통해 넘기는 경우
//        List<Integer> listLimit = new ArrayList<Integer>();
//        listLimit.add(0);
//        listLimit.add(4);      
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("listLimit",listLimit);      
//        List<MemberDTO> list = sqlSession.selectList("member.pagingList_mapList",map);
        

      //3. 배열 파라미터를 직접 넘기는 경우
//      int[] arrLimit = {0,5};      
//      List<MemberDTO> list = sqlSession.selectList("member.pagingList_array",arrLimit);
    
    
      //4. 배열 파라미터를 Map을 통해 넘기는 경우
//        int[] arrLimit = {0,2};
//        Map<String,int[]> map = new HashMap<String, int[]>();
//        map.put("arrLimit",arrLimit);
//        List<MemberDTO> list = sqlSession.selectList("member.pagingList_mapArray",map);


      //5. 배열 파라미터를 이용한 in() 조회 활용
      String[] arrId = {"duly", "ID1", "ID4"};      
      List<MemberDTO> list = sqlSession.selectList("member.selectMulty",arrId);
    
    
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
