package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import entity.Student;
import jakarta.servlet.http.HttpServlet;

public class StudentDao extends HttpServlet {

	public Connection conn = null;

	public boolean insertInDatabase(Student stu) {
		boolean resp = false;
		try {
			conn = DBConnection.getConnection();
			String query = "insert into student(name, email, password, gender) values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getEmail());
			pstmt.setString(3, stu.getPassword());
			pstmt.setString(4, stu.getGender());
			int data = pstmt.executeUpdate();
			if(data==1) {
				resp= true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resp;
	}
	
//	fetch all student record
	public List<Student> getAllData(){
		List<Student> stu = new ArrayList<Student>();
		Student s;
		try {
			conn = DBConnection.getConnection();
			String query = "select * from student";
			PreparedStatement psmt = conn.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setGender(rs.getString(5));
				stu.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stu;
	}
	
	//fetch single student details
	
	public List<Student> getSingleData(int id){
		List<Student> stu = new ArrayList<Student>();
		Student s;
		try {
			conn = DBConnection.getConnection();
			String query = "select * from student where id = ?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setGender(rs.getString(5));
				stu.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return stu;
	}
	
//	update single record
	public boolean updateRecord(Student stu) {
		boolean resp = false;
		try {
			conn = DBConnection.getConnection();
			String query = "update student set name=?, email=?, password=?, gender=? where id=? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getEmail());
			pstmt.setString(3, stu.getPassword());
			pstmt.setString(4, stu.getGender());
			pstmt.setInt(5, stu.getId());
			int data = pstmt.executeUpdate();
			if(data==1) {
				resp= true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resp;
	}
	
//	delete user data
	public boolean deleteRecord(int id) {
		boolean resp = false;
		try {
			conn = DBConnection.getConnection();
			String query = "delete from student where id=? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			int data = pstmt.executeUpdate();
			if(data==1) {
				resp= true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resp;
	}
	
}
