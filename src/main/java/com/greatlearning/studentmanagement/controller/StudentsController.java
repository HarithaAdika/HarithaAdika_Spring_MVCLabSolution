package com.greatlearning.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentmanagement.model.StudentDetails;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String getAllStudents(Model theModel) {
		List<StudentDetails> student = studentService.getAllStudents();
		theModel.addAttribute("studentModel", student);
		return "studentslist";

	}

	@RequestMapping("/add")
	public String addStudents(Model theModel) {
		StudentDetails student = new StudentDetails();
		theModel.addAttribute("student", student);
		return "savestudentdetailsform";

	}

	@RequestMapping("/update")
	public String updateStudent(@RequestParam("student_Id") int student_Id, Model theModel) {
		StudentDetails student = studentService.getStudentDetailsById(student_Id);
		theModel.addAttribute("student", student);
		return "savestudentdetailsform";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("student_Id") int student_Id, Model theModel) {
		StudentDetails student = studentService.deleteStudent(student_Id);
		System.out.println("Deleted Student id is:" + student.getStudent_Id());
		return "redirect:/students/list";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("student_Id") int student_Id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("department") String department,
			@RequestParam("country") String country) {
		StudentDetails student;
		if (student_Id != 0) {
			student = studentService.getStudentDetailsById(student_Id);
		} else {
			student = new StudentDetails();

		}
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setDepartment(department);
		student.setCountry(country);
		studentService.saveStudent(student);
		System.out.println(student_Id + "" + firstName + "" + lastName + "" + department + "" + country);
		return "redirect:/students/list";
	}

}
