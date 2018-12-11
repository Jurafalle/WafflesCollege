package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.services.EnrollmentService;



@RequestMapping(value = "/admin/managenewenrollment")
@Controller
public class ManageNewEnrolmentController {
	@Autowired
	private EnrollmentService cService;

	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
	}
	@RequestMapping(value = "/new")
	public ModelAndView pendingApprovals(HttpSession session) {
		HashMap<Student, ArrayList<Enrollment>> hm = new HashMap<Student, ArrayList<Enrollment>>();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		System.out.println(us.toString());
		ModelAndView mav = new ModelAndView("MainPage");
		if (us.getSessionId() != null) {
			for (Student student : us.getStudent()) {
				ArrayList<Enrollment> clist = cService.findNewEnrollmentById(student.getStuId());
				hm.put(student, clist);
		}
			mav = new ModelAndView("ManageNewEnrollment");
			mav.addObject("pendinghistory", hm);
			return mav;
		}
		return mav;
	}
}