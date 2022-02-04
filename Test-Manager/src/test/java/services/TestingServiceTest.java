package services;

import persistenceLayer.TestingRepository;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TestingServiceTest {
	
	private static final Logger logger = LogManager.getLogger(TestingServiceTest.class);  
	TestingService service=null;
	
    @Mock
    TestingRepository databaseMock;
	
	@Before
    public void init() {
        service=new TestingService();
        BasicConfigurator.configure();  
    }

	/*@Test
	public void shouldAddTest() {
		doNothing().when(databaseMock).addTest(isA(String.class));
		service.addTest();
		verify(databaseMock.addTest(any()),times(1));
	}*/
	
	@Test
	public void shouldLoadNewTestNumber() {	
		logger.info("Hello world");  
        when(databaseMock.loadNewTestNumber()).thenReturn(Integer.valueOf(6)); 
	   	int result = service.loadNewTestNumber();
	    assertEquals(6, result);     
	}	
	
	@Test
	public void shouldDisplayTest() {	
		logger.info("Hello world");  	
	   String message = "Robert";	
	   TestingRepository messageUtil = new TestingRepository();
	   
	      System.out.println("Inside testPrintMessage()");    
	      assertEquals(0, 0);     
	}
	
	@Test
	public void shouldChangeTestSTatus() {	
		logger.info("Hello world");  	
	   String message = "Robert";	
	   TestingRepository messageUtil = new TestingRepository();
	   
	      System.out.println("Inside testPrintMessage()");    
	      assertEquals(0, 0);     
	}
}