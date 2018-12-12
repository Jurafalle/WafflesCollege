package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.services.EnrollmentService;
import sg.iss.wafflescollege.validator.StudentValidator;


@RequestMapping(value = "/admin/managenewenrollment")
@Controller
public class ManageNewEnrollmentController {
	
	@Autowired
	private EnrollmentService eService;


	@RequestMapping(value = "/new", method=RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Enrollment> enrollment = eService.findAllNewEnrollments();
		ModelAndView mav = new ModelAndView("ManageNewEnrollment");
		mav.addObject("enrollment", enrollment);
		return mav;
		}
}
