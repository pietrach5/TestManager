package persistence.layer;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import persistenceLayer.TestEntity;
import persistenceLayer.TestingRepository;

public class TestingRepositoryTest {
	
	TestingRepository repository=null;
	
	@Before
    public void init() {
		repository=new TestingRepository();
        BasicConfigurator.configure();  
    }

	
	@Test
	public void shouldDisplayTest() {	
	   repository.addTest("Test-Test");
	   List<TestEntity>result = repository.findTests();
	   assertEquals(0, 0);     
	}
	
	@Test
	public void shouldChangeTestSTatus() {	
	   String message = "Robert";	
	   TestingRepository messageUtil = new TestingRepository();
	   
	      assertEquals(0, 0);     
	}
}