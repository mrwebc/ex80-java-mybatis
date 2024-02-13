package main;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;
import model.Employee;
import model.MemberDTO;


public class Step95_join_resuiltMap {

  public static void main(String[] args) {
    
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession(false); //기본값 false = Not autoCommit
    /*
     * 조인으로 나오는 결과 컬럼명은 기존의 자바모델클래스의 필드명과 대게 다르므로
     * 별도로 클래스를 정의해 줘야 한다. 
     * 
      #두개의 employees, departments 테이블을 department_id 컬럼으로 join 하여 
      #급여가 5000 이상인 사원의 정보를 조회하시오.
      
      select e.first_name, e.department_id, d.department_name
      from employees e inner join departments d 
      on e.department_id = d.department_id 
      where e.salary >= 5000;
    */
    
      int salary = 5000;
      
      List<Employee> list = sqlSession.selectList("member.sql_join",salary);

      if(list.size() > 0) {
        for(Employee em : list) {
          System.out.println(em.toString());
        }
      }else {
        System.out.println("조회된 데이터가 없습니다.");
      }
      
      sqlSession.close();    
    
  }//end of main

}
