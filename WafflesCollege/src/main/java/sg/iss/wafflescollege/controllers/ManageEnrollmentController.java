package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sg.iss.wafflescollege.exception.StudentNotFound;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.services.EnrollmentService;


@Controller
@RequestMapping(value = "/admin/manageenrolment")

public class ManageEnrollmentController {
	
	@Autowired 
	EnrollmentService eService;
	//@Autowired
	//private StudentValidator sValidator;
	
	//@InitBinder("student")
	//private void initDepartmentBinder(WebDataBinder binder) {
	//	binder.addValidators(sValidator);
	//}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("ManageEnrolment");
		ArrayList<Enrollment> enrollments = eService.findAllEnrollments();
		mav.addObject("enrollments", enrollments);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		ModelAndView mav = new ModelAndView("EnrollmentFormNew", "enrollment", new Enrollment());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView newUserPage(@ModelAttribute Enrollment enrollment) {
		eService.createEnrollment(enrollment);
		ArrayList<Enrollment> elist = eService.findAllEnrollments();
		ModelAndView mav = new ModelAndView("ManageEnrolment");
		
		mav.addObject("enrollment", elist);
		return mav;
		
	}

	@RequestMapping(value = "/edit/{enrollmentId}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable Integer enrollmentId) {
		ModelAndView mav = new ModelAndView("EnrollmentFormEdit");
		mav.addObject("enrollment", eService.findEnrollmentById(enrollmentId));
		return mav;
	}

	@RequestMapping(value = "/edit/{enrollmentId}", method = RequestMethod.POST)
	public ModelAndView editUserPage(@PathVariable Integer enrollmentId, @ModelAttribute Enrollment enrollment) {
		eService.updateEnrollment(enrollment);
		ArrayList<Enrollment> elist = eService.findAllEnrollments();
		ModelAndView mav = new ModelAndView("ManageEnrolment");
		mav.addObject("enrollment", elist);
		return mav;
	}

}
