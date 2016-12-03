package pk.ssi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
	private EntityManagerFactory entityManagerFactory; 
	private EntityManager entityManager;                             
	private EntityTransaction entityTransaction;     
	
	public void create(StudentForm student){
		entityTransaction.begin();                                                               
		entityManager.persist(student);                                                         
		entityTransaction.commit();  
		close();
	}
	public StudentForm get(int id){
		StudentForm student = entityManager.find(StudentForm.class, id);
		close();
		return student;
	}
	public List<StudentForm> getAll(){
	    Query query = entityManager.createQuery("Select s from StudentForm s");
	    List<StudentForm> students = query.getResultList();
	    close();
	    return students;
	}
	
	public void edit (StudentForm student){
		//ToDo
	}
	
	public void delete (int id){
		Query query = entityManager.createQuery("Delete from StudentForm where id=:ID");
		query.setParameter("ID", id);
		query.executeUpdate();
		close();
	}
	
	public StudentDao(){
		entityManagerFactory = Persistence.createEntityManagerFactory("derby");  
		entityManager = entityManagerFactory.createEntityManager();                               
	}
	
	private void close(){
		entityManager.close();                                                                 
		entityManagerFactory.close();
	}

}
