package sg.iss.wafflescollege.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.services.CourseService;
import sg.iss.wafflescollege.validator.CourseValidator;

@RequestMapping(value = "/admin/managecourses")
@Controller
public class ManageCoursesController {

	@Autowired
	private CourseService cService;
	@Autowired
	private CourseValidator cValidator;

	@InitBinder("courses")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(cValidator);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView createCourse() {
		ModelAndView mav = new ModelAndView("AddCourses", "course", new Course());
		mav.addObject("cidlist", cService.findAllCourses());
		return mav;
	}
}
