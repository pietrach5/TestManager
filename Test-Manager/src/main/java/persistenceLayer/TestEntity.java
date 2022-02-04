package persistenceLayer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "TESTS")
public class TestEntity {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    
		private String testName;
	    private String testStatus;
	    
	    public TestEntity() {
	    	super();
	    }
	    
		public TestEntity(String testName, String testStatus) {
			super();
			this.testName = testName;
			this.testStatus = testStatus;
		}

		public String getTestName() {
			return testName;
		}
		public void setTestName(String testName) {
			this.testName = testName;
		}
		public String getTestStatus() {
			return testStatus;
		}
		public void setTestStatus(String testStatus) {
			this.testStatus = testStatus;
		}
}
