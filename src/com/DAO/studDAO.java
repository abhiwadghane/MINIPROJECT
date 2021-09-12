package com.DAO;

import java.util.List;

import com.Model.Student;

public interface studDAO {

	public boolean add(Student e);

	public int delete(int sid);

	public List<Student> getAllStudent();

	public int updateById(int id);

	public Student getStudentEmpById(int id);

}
