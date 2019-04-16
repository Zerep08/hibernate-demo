
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.Review;

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
		
		Course course = session.get(Course.class, 10);
		Review r1 = new Review("It's an amazing course");
		Review r2 = new Review("Wonderfull I can't believe it");
		course.add(r1);
		course.add(r2);
			
		session.save(r1);
		session.save(r2);
		
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
				
				
				 Course course= session.get(Course.class, 10);
				 
				 session.delete(course);
				  
				  
				 
		
		
		session.getTransaction().commit();
	
		
		
	}
	
	
	
	
	
	


}
