package services;

import persistenceLayer.TestingRepository;
import org.junit.Test;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;

public class TestingControllerTest {
	
	private static final Logger logger = LogManager.getLogger(TestingControllerTest.class);  
	TestingRepository service=null;
	
	@Before
    public void init() {
        service=new TestingRepository();
        BasicConfigurator.configure();  
    }

	@Test
	public void ifTestStatusChanged() {	
		logger.info("Hello world");  	
	   String message = "Robert";	
	   TestingRepository messageUtil = new TestingRepository();
	   
	      System.out.println("Inside testPrintMessage()");    
	      assertEquals(0, 0);     
	   }
}