package com.greatlearning.studentmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentmanagement.model.StudentDetails;

@Repository
public class StudentServiceImplementation implements StudentService {
	SessionFactory sessionFactory;
	Session session;

	@Autowired
	public StudentServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<StudentDetails> getAllStudents() {
		return (List<StudentDetails>) session.createQuery("from StudentDetails").list();
	}

	@Override
	public void saveStudent(StudentDetails student) {
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();

	}

	@Override
	@Transactional
	public StudentDetails deleteStudent(int student_Id) {
		StudentDetails student = session.get(StudentDetails.class, student_Id);
		session.delete(student);
		return student;
//		Transaction tx = session.beginTransaction();
//
//		// get transaction
//		//Student student = session.get(Student.class, id);
//		StudentDetails student = session.get(StudentDetails.class, student_Id);
//
//		// delete record
//		session.delete(student);
//
//		tx.commit();
//		return student;

	}

	@Override
	public StudentDetails getStudentDetailsById(int student_Id) {
		return session.get(StudentDetails.class, student_Id);
	}

}
