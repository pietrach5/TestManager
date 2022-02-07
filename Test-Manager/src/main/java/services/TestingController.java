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
		model.addAttribute("counter", new Counter());
		List<TestEntity> sometests = null;
		sometests = service.displayTest();
		model.addAttribute("sometests", sometests);
		return "TestManager";
	}
	
	@RequestMapping(value ="/addTest")
	public String addTest(Model model) {
		model.addAttribute("counter", new Counter());
		service.addTest();
		List<TestEntity> sometests = null;
		sometests = service.displayTest();
		model.addAttribute("sometests", sometests);
		return "TestManager";
	}
	
	@RequestMapping(value ="/changeTest")
	public String changeTestStatus(@RequestParam("newStatus") String newStatus, @RequestParam("number") String number, Model model) {
		model.addAttribute("counter", new Counter());
		service.changeTestStatus(Integer.valueOf(number), newStatus);
		List<TestEntity> sometests = null;
		sometests = service.displayTest();
		model.addAttribute("sometests", sometests);
		return "TestManager";
	}
}
