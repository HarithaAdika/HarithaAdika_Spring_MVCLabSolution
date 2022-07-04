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
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String studentsList(Model theModel) {
		System.out.println("Request to Fetch student details");
		// get Students from db table
		List<StudentDetails> students = studentService.getAllStudents();
		theModel.addAttribute("Students", students);

		return "studentList";
	}

	@RequestMapping("/studentFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		StudentDetails student = new StudentDetails();

		theModel.addAttribute("Student", student);

		return "saveStudentForm";
	}

	@RequestMapping("/studentFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model theModel) {

		// get the Student Details from the service
		StudentDetails student = studentService.findByStudentId(id);
		theModel.addAttribute("Student", student);

		return "saveStudentForm";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("department") String department,
			@RequestParam("country") String country) {

		System.out.println("Saving Student" + id);
		StudentDetails student;
		
		if (id != 0) {
			student = studentService.findByStudentId(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			student = new StudentDetails(firstName, lastName, department, country);
		// save the Student Details
		studentService.save(student);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {

		// delete the Student by ID
		studentService.deleteById(id);

		// redirect to /student/list
		return "redirect:/student/list";

	}

}
