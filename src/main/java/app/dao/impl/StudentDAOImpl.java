package app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import app.dao.GenericDAO;
import app.dao.StudentDAO;
import app.model.Student;

public class StudentDAOImpl extends GenericDAO<Integer, Student> implements StudentDAO {
	private static final Logger logger = Logger.getLogger(StudentDAOImpl.class);

	public StudentDAOImpl() {
		super(Student.class);
	}

	public StudentDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> search(String query) {
		String sql = "FROM Student WHERE email LIKE '%:query%' OR name LIKE '%:query%'";
		return getSession().createQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadStudents() {
		return getSession().createQuery("from Student").getResultList();
	}

}
