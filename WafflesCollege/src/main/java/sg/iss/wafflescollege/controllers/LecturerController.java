package sg.iss.wafflescollege.controllers;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.wafflescollege.services.LecturerService;

@RequestMapping(value = "/lecturer")
@Controller
public class LecturerController {
	
	@Autowired 
	private LecturerService lService;
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ModelAndView viewCoursePage() {
		ModelAndView mav=new ModelAndView("ViewCoursesTaught");
		mav.addObject("courseTaughtList", lService.findCourseTaught());
		return mav;
	}
	
	@
	

}
