import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;

class OneToManyRelationShipTest {
	
static Session session;
	
	@BeforeEach
	void setup() {

		SessionFactory factory = HibernateUtil.getSessionfactory();
		session = factory.getCurrentSession();
	
	}

	@Test
	void add_courses_test() {
		session.beginTransaction();
		
		Instructor ins = session.get(Instructor.class, 4);
		
		Course c1 = new Course("Java course");
		
		Course c2 = new Course("Chemestry");
		
		ins.add(c1);
		ins.add(c2);
		
		session.save(c1);
		session.save(c2);
		
		session.getTransaction().commit();
		
		
	}
	
	@AfterAll
	static void close_session() {
		session.close();
	}

}
