package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {
	public List<Student> selectAll(){
		//데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);	
		List<Student> list= session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
		return list;
		
	
	}
	public Student selectOne(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne",studentNo);
		session.close();
		return student;
		}
	
	public List<Student> searchList(String name){
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.searchList", name);
		session.close();
		return list;
	}
	public int insertStudent(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insertStudent",param);
		session.close();
		return result;
	}
	
	//Service한데 Student 전달 받음
	//	전달받은 정보 update
	public int updateStudent(Student student) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.update("com.gn.mapper.StudentMapper.updateStudent", student);
		session.close();
		return result;
		
	}
	public int deleteStudent(int no) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.delete("com.gn.mapper.StudentMapper.deleteStudent", no);
		session.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
