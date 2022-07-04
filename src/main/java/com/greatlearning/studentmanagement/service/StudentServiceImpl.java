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
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<StudentDetails> getAllStudents() {

		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<StudentDetails> students = session.createQuery("from StudentDetails").list();

		tx.commit();

		return students;
	}

	@Transactional
	public StudentDetails findByStudentId(int id) {

		StudentDetails student = new StudentDetails();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		student = session.get(StudentDetails.class, id);

		tx.commit();

		return student;
	}

	@Transactional
	public void save(StudentDetails student) {

		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(student);
		tx.commit();

	}

	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		StudentDetails student = session.get(StudentDetails.class, id);

		session.delete(student);

		tx.commit();

	}

}