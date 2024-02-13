package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisManager;

public class Step10_SqlSessionFactoryTest {

  public static void main(String[] args) {
    
    //마이바티즈 설정정보를 가진 객체변수 
    SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
    
    //SQL작업을 담당한 sqlSession 객체 생성
    SqlSession sqlSession = sqlSessionFactory.openSession(true); //기본값 false = Not autoCommit
    
    //처음할때는 매퍼파일이 없으므로 mybatis-config.xml에서 매퍼파일 설정을 주석처리후 테스트 권장
    System.out.println("sqlSession = "+sqlSession);

  }

}
