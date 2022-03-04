package com.zensar.thymeleafdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.thymeleafdemo.entity.Student;

@Controller
public class HelloController {

		@GetMapping("/hello")
		public String sayHello() {
			return "hello";
		}
		
		@GetMapping("/sendData")
		public ModelAndView sendData() {
			ModelAndView mv = new ModelAndView("getData");
			//mv.addObject("name", "Gaurav Jethawa");
			Student student = new Student();
			student.setStudentId(515554);
			student.setStudentName("Rudransh Jethawa");
			mv.addObject("student", student);
			return mv;
		}
}
