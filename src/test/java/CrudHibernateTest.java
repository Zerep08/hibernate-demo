import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

class CrudHibernateTest {
	static Session session;
	
	@BeforeEach
	void setup() {

		SessionFactory factory = HibernateUtil.getSessionfactory();
		session = factory.getCurrentSession();
	
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/Data.csv", numLinesToSkip = 1)
	void saving_instructors(String name, String lastName, String email, String hobby, String youtube) {

		session.beginTransaction();

		Instructor instructor = new Instructor(name, lastName, email);
		
		InstructorDetail insDetail = new InstructorDetail(hobby, youtube);
		
		instructor.setInsDetail(insDetail);
		
		session.save(instructor);

		session.getTransaction().commit();


	}
	
	@Disabled
	@Test
	void reading_student() {
		
		session.beginTransaction();

		Student student = session.get(Student.class, 5);
		
		session.getTransaction().commit();
		
		System.out.println("The student: " + student);

		
	}
	
	@Disabled
	@Test
	void querying_students() {
		
		session.beginTransaction();

		List<Student> students = session.createQuery("FROM Student s WHERE s.lastName LIKE 'c%' OR s.lastName LIKE 's%'").getResultList();
		
		session.getTransaction().commit();
		
		students.forEach(System.out::println);

		
	}
	
	@Disabled
	@Test
	void update_students() {
		session.beginTransaction();
		
		Student student = session.get(Student.class, 1);
		
		student.setFirstName("Panchin");
		
		session.getTransaction().commit();
	}
	
	@Disabled
	@Test
	void update_students_query() {
		session.beginTransaction();
		
		session.createQuery("update Student s set email='java@gmail.com' where s.lastName like 's%' ").executeUpdate();
		
		session.getTransaction().commit();
	}
	
	@Disabled
	@Test
	void delete_student_query() {
	session.beginTransaction();
		
		session.createQuery("Delete Student s where s.id=1").executeUpdate();
		
		session.getTransaction().commit();
	}
	
	@AfterAll
	static void close_session() {
		session.close();
	}


}
