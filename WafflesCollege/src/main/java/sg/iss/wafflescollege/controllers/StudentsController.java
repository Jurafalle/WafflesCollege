package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.wafflescollege.services.StudentService;
import sg.iss.wafflescollege.model.Student;

@RequestMapping(value = "/student")
@Controller
public class StudentsController {

	@Autowired
	StudentService sService;

	@RequestMapping(value = "/gpa", method = RequestMethod.GET)
	public ModelAndView viewGrades(HttpSession session, ) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");

		ModelAndView mav = new ModelAndView("StudentViewGrades");
		Double cGPA = sService.CalculateCGPA();
		mav.addObject("cGPA", cGPA);
		return mav;
	}
}
