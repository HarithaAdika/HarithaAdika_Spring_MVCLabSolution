package com.greatlearning.studentmanagement.service;

import java.util.List;


import com.greatlearning.studentmanagement.model.StudentDetails;

public interface StudentService {
	public List<StudentDetails> getAllStudents();
	public void saveStudent(StudentDetails student);
	public StudentDetails deleteStudent(int student_Id);
	public StudentDetails getStudentDetailsById(int student_Id);
	
	

}
