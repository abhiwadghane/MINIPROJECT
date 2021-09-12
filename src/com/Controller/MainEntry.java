package com.Controller;

import java.util.List;

import com.Configuration.DBconnect;
import com.DAO.StudDAOImplimentation;
import com.Model.Student;

public class MainEntry {
	public static void main(String[] args) {

		DBconnect.getConnection();
		
		StudDAOImplimentation sobj = new StudDAOImplimentation();
		
		Student s = new Student();
		s.setStudid(101);
		s.setName("priya");
		s.setMobile(7720819485l);
		s.setBatchid(201);
		
//		boolean added = sobj.add(s);		
//		System.out.println("data added = "+added);
		
//		int del = sobj.delete(80);		
//		System.out.println("data deleted = "+del);
		
		List<Student> studData = sobj.getAllStudent();
		
		for(Student x:studData)
		{
			System.out.println(x);
		}
		
//		int upd = sobj.updateById(101);		
//		System.out.println("data updated = "+upd);
		
		
		Student stu = sobj.getStudentEmpById(101);		
		System.out.println("search data = "+stu);
		
		
		
		
		
	}

}
