package persistenceLayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import services.ExecutionStatus;

@Repository
public class TestingRepository {
	
	public TestingRepository() {
		super();
	}

	Transaction transaction = null;
	
	public int loadNewTestNumber() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List < TestEntity > students = session.createQuery("from TestEntity", TestEntity.class).list();
            transaction.commit();
            return students.size()+1;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return 0;
	}
	public void addTest(String testName) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(new TestEntity(testName, ExecutionStatus.UNDEFINED.toString()));
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
	
	public TestEntity changeTestStatus(int number, ExecutionStatus newStatus) {
		TestEntity testEntity = displayTest().get(number);
		testEntity.setTestStatus(newStatus.toString());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(testEntity); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return testEntity;
	}
	
	public List < TestEntity > displayTest() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < TestEntity > students = session.createQuery("from TestEntity", TestEntity.class).list();
            return students;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}
}
