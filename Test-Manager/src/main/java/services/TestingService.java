package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistenceLayer.TestEntity;
import persistenceLayer.TestingRepository;

@Service
public class TestingService {

	TestingRepository testingRepository;

	public TestingService() {
	}

	@Autowired
	public TestingService(TestingRepository testingRepository) {
		this.testingRepository = testingRepository;
	}

	public int loadNewTestNumber() {
		return testingRepository.loadNewTestNumber();
	}

	public void addTest() {
		String testName = "My test "+loadNewTestNumber();
		testingRepository.addTest(testName);
	}

	public TestEntity changeTestStatus(int number, String newStatus) {
	    switch (newStatus) {
        case "failed":
        	return testingRepository.changeTestStatus(number, ExecutionStatus.FAILED);
        case "passed":
        	return testingRepository.changeTestStatus(number, ExecutionStatus.PASSED);
        default:
        	return testingRepository.changeTestStatus(number, ExecutionStatus.UNDEFINED);
	    }
	}

	public List<TestEntity> displayTest() {
		List<TestEntity> result = new ArrayList<TestEntity>();
		List<TestEntity> entities;
		entities = testingRepository.findTests();
		for (TestEntity entity : entities) {
			result.add(entity);
		}
		return result;
	}
	
	public List<String> displayTestStatuses() {
		List<String> result = new ArrayList<String>();
		List<TestEntity> entities;
		entities = testingRepository.findTests();
		for (TestEntity entity : entities) {
			result.add(entity.getTestStatus());
		}
		return result;
	}
}
