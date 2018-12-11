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
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.services.StudentService;
import sg.iss.wafflescollege.validator.StudentValidator;

@RequestMapping(value = "admin/managestudents")
@Controller
public class ManageStudentsController {

	@Autowired
	StudentService sService;
	@Autowired
	private StudentValidator sValidator;
	@InitBinder("admin/managestudents")
	private void initManageStudentBinder(WebDataBinder binder) {
		
		binder.addValidators(sValidator);
	}


	/**
	 * ManageStudent CRUD OPERATIONS
	 * 
	 * @return
	 */

	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView listAllStudents() {
		ModelAndView mav = new ModelAndView("ManageStudents");
		ArrayList<Student> students = sService.findAllStudents();
		mav.addObject("students", students);
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		return new ModelAndView();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		return new ModelAndView();
	}

	@RequestMapping(value = "/edit/{nric}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String nric) {
		return new ModelAndView();
	}

	@RequestMapping(value = "/edit/{nric}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, @PathVariable String nric,
			BindingResult result, final RedirectAttributes redirectAttributes) throws StudentNotFound {
		return new ModelAndView();
	}

	@RequestMapping(value = "/delete/{nric}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable String nric, final RedirectAttributes redirectAttributes)
			throws StudentNotFound {
		
		return new ModelAndView();
	}

}
