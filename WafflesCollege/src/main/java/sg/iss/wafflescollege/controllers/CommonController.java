package sg.iss.wafflescollege.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.wafflescollege.model.User;
import sg.iss.wafflescollege.services.UserService;

@Controller
@RequestMapping(value = "/MainPage")
public class CommonController {

	@Autowired
	private UserService uService;

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "Login";
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("/Login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		
		if (user.getUseId() != null && user.getUsePassword() != null) {
			User u = uService.authenticate(user.getUseId(), user.getUsePassword());
			us.setUser(u);
						
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			us.setUser(uService.findUserById(us.getUser().getUseId()));			
			System.out.println(uService.findUserById(us.getUser().getUseId()));
		
			String resultL = us.getUser().getUseRole();
								
			if(resultL=="Admin") {
			mav = new ModelAndView("/admin/ManageStudents/load");}	
			if(resultL=="Student") {
			mav = new ModelAndView("/student/GradesGPA/load");}	
			if(resultL=="Lecturer") {
			mav = new ModelAndView("/lecturer/ViewCoursesTaught/load");}	
		}
      
			session.setAttribute("USERSESSION", us);
			return mav;
	}
}