
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

class OneToManyRelationShipTest {
	
static Session session;
	
	@BeforeEach
	void setup() {

		SessionFactory factory = HibernateUtil.getSessionfactory();
		session = factory.getCurrentSession();
	
	}

	@Disabled
	@Test
	void add_courses_test() {
		session.beginTransaction();
		
		Course course = session.get(Course.class, 15);
		Student s1 = session.get(Student.class, 1);
		Student s2 = session.get(Student.class, 2);
		Student s3 = session.get(Student.class, 3);
		Student s4 = session.get(Student.class, 4);
		Student s5 = session.get(Student.class, 5);
		Student s6 = session.get(Student.class, 6);
		Student s7 = session.get(Student.class, 7);
		Student s8 = session.get(Student.class, 8);
		course.addStudents(s1);
		course.addStudents(s2);
		course.addStudents(s3);
		course.addStudents(s4);
		course.addStudents(s5);
		course.addStudents(s6);
		course.addStudents(s7);
		course.addStudents(s8);
			
		session.save(course);
		
		
		
		session.getTransaction().commit();
		
		
	}
	
	
	
	@Test
	void eager_and_lazy_test() {
		session.beginTransaction();
		
		
		/*
		 * Query<Instructor> query =session.createQuery("select i from Instructor i " +
		 * "JOIN FETCH i.courses " + "where i.id=4", Instructor.class); Instructor
		 * instructor = query.getSingleResult();
		 */
				
				
				 Student student= session.get(Student.class, 2);
				 
				 session.delete(student);
				 
				 
		
		
		session.getTransaction().commit();
	
		
		
	}
	
	
	
	
	
	


}
