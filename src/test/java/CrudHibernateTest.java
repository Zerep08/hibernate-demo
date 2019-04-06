import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.hibernate.entity.Student;

class CrudHibernateTest {
	static Session session;

	@ParameterizedTest
	@CsvFileSource(resources = "/Data.csv", numLinesToSkip = 1)
	void test(String name, String lastName, String email) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();
	
		session.beginTransaction();

		session.save(new Student(name, lastName, email));

		session.getTransaction().commit();

		// session.close();

	}

}
