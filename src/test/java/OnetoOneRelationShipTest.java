import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

class OnetoOneRelationShipTest {
	
static Session session;
	
	@BeforeEach
	void setup() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();
	
	}

	@Disabled
	@Test
	void delete_instructor() {
		
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 1);
		
		assertEquals(1, instructor.getId());
		
		session.delete(instructor);
		
		session.getTransaction().commit();
		
	}
	
	
	@Test
	void test_oneToOne_biderectional() {
		
		session.beginTransaction();
		
		Instructor ins = session.get(Instructor.class, 4);
		InstructorDetail detailIns = session.get(InstructorDetail.class, 4);
		
		
		
		System.out.println("Instructor Detail: " + ins.getInsDetail());
		
		System.out.println("Instructor : " + detailIns.getInstructor());
		
		session.getTransaction().commit();
		
		
	}
	
	@AfterAll
	static void close_session() {
		session.close();
	}


}
