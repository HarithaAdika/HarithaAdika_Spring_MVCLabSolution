package com.greatlearning.studentmanagement.service;

import java.util.List;

import com.greatlearning.studentmanagement.model.StudentDetails;

public interface StudentService {
	public List<StudentDetails> getAllStudents();

	public StudentDetails findByStudentId(int id);

	public void save(StudentDetails student);

	public void deleteById(int id);

}
