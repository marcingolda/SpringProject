package pk.ssi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("derby");
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public void create(StudentForm student) {
		entityTransaction.begin();
		if (entityManager.find(StudentForm.class, student.getId()) != null) {
			entityManager.merge(student);
		} else {
			entityManager.persist(student);
		}
		entityTransaction.commit();
		close();
	}

	public StudentForm get(int id) {
		StudentForm student = entityManager.find(StudentForm.class, id);
		close();
		return student;
	}

	public List<StudentForm> getAll() {
		Query query = entityManager.createQuery("from StudentForm");
		List<StudentForm> students = query.getResultList();
		close();
		return students;
	}

	public void delete(int id) {
		entityTransaction.begin();
		Query query = entityManager.createQuery("delete StudentForm where id = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
		entityTransaction.commit();
		close();
	}

	public StudentDao() {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private void close() {
		entityManager.close();
	}

}
