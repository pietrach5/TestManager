package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import persistenceLayer.TestEntity;

@Controller
public class TestingController {

	public TestingController() {
	}

	private TestingService service;

	@Autowired
	public TestingController(TestingService service) {
		this.service = service;
	}

	@RequestMapping("/test")
	public String display2(Model model) {
		List<TestEntity> sometests = null;
		sometests = service.displayTest();
		model.addAttribute("sometests", sometests);
		return "TestManager";
	}
	
	/*@RequestMapping(value ="/addTest", method=RequestMethod.POST)
	public String addTest() {
		service.addTest();
		return "redirect/:test";
	}*/
	
	@RequestMapping(value ="/addTest")
	public String addTest(Model model) {
		service.addTest();
		List<TestEntity> sometests = null;
		sometests = service.displayTest();
		model.addAttribute("sometests", sometests);
		return "TestManager";
	}
	
	@RequestMapping(value ="/changeTestStatus")
	public String changeTestStatus(@RequestParam("number") String number, @RequestParam("newStatus") String newStatus) {
		service.changeTestStatus(Integer.valueOf(number), newStatus);
		return "TestManager";
	}
}
