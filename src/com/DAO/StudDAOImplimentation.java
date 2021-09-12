package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Configuration.DBconnect;
import com.Model.Student;

public class StudDAOImplimentation implements studDAO {

	@Override
	public boolean add(Student e) {
		
		try (Connection con = DBconnect.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"insert into student(Studentid, name, mobile, batchid) values(?,?,?,?)")) {

			pst.setInt(1, e.getStudid());
			pst.setString(2, e.getName());
			pst.setLong(3, e.getMobile());
			pst.setInt(4, e.getBatchid());
			
			
			int c = pst.executeUpdate();

			if (c > 0)
				return true;

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		return false;
	
	}

	@Override
	public int delete(int sid) {
	
		int status = 0;
		PreparedStatement pst = null;
		Connection con = null;

		try {
			con = DBconnect.getConnection();

			pst = con.prepareStatement("delete from student where Studentid=?");
			pst.setInt(1, sid);

			status = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return status;
	}

	@Override
	public List<Student> getAllStudent() {
		ArrayList<Student> emplist = new ArrayList<>();
		try (Connection con = DBconnect.getConnection(); Statement st = con.createStatement()) {

			ResultSet rs = st.executeQuery("select * from student");

			while (rs.next()) {
				Student s2 = new Student();
				s2.setStudid(rs.getInt(1));
				s2.setName(rs.getString(2));
				s2.setMobile(rs.getLong(3));
				s2.setBatchid(rs.getInt(4));
				
				emplist.add(s2);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return emplist;
	}

	@Override
	public int updateById(int id) {
		
		int status = 0;
		PreparedStatement pst = null;
		Connection con = null;

		try {
			con = DBconnect.getConnection();
			
			pst = con.prepareStatement("UPDATE student SET name = ?, mobile = ? WHERE  Studentid=?");
			pst.setString(1, "Arjun");
			pst.setLong(2, 123456);			
			pst.setInt(3, id);

			status = pst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return status;
		
	}

	@Override
	public Student getStudentEmpById(int id) {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Student eobj = null; 

		try (Connection con = DBconnect.getConnection())
		{
			pst = con.prepareStatement("select * from student where Studentid = ?");
			pst.setInt(1, id);

			rs = pst.executeQuery();
			rs.next();

			eobj = new Student();
			eobj.setStudid(rs.getInt(1));
			eobj.setName(rs.getString(2));
			eobj.setMobile(rs.getLong(3));
			eobj.setBatchid(rs.getInt(4));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return eobj;
	}

	
}
