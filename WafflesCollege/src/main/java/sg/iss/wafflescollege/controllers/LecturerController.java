package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.services.LecturerService;

@RequestMapping(value = "/lecturer")
@Controller
public class LecturerController {

	@Autowired
	private LecturerService lService;

	@RequestMapping(value = "/courses")
	public ModelAndView viewCoursePage() {
		ArrayList<Course> courses = lService.findCourseTaught(lecId);
		ModelAndView mav = new ModelAndView("ViewCoursesTaught", "courses", courses);
		return mav;
	}

	@RequestMapping(value = "/enrollmentsofspecificcourse/{cseId}", method = RequestMethod.GET)
	public ModelAndView viewEnrollmentsPage(@PathVariable String cseId) {
		ModelAndView mav = new ModelAndView("ViewCourseEnrolment");
		ArrayList<Enrollment> enrollments = lService.findSpecificCourseEnrollment(cseId);
		mav.addObject("enrollments", enrollments);
		return mav;
	}

	@RequestMapping(value = "/studentgradesofspecificcourse/{cseId}", method = RequestMethod.GET)
	public ModelAndView studentGradePage(@PathVariable String cseId) {
		ModelAndView mav = new ModelAndView("StudentGradePage");
		ArrayList<Studentgrade> studentgrades = lService.findSpecificCourseStudentgrade(cseId);
		mav.addObject("studentgrades", studentgrades);
		return mav;
	}

	@RequestMapping(value = "/studentgradesofspecificcourse/{cseId}/grading/{stgId}", method = RequestMethod.GET)
	public ModelAndView gradeStudentPage(@PathVariable String cseId, @PathVariable String stgId) {
		Studentgrade studentgrade = new Studentgrade();
		ModelAndView mav = new ModelAndView("GradeACourse", "studentgrade", studentgrade);
		return mav;
	}

	@RequestMapping(value = "/studentgradesofspecificcourse/{cseId}/grading/{stgId}", method = RequestMethod.POST)
	public ModelAndView gradeStudentPage(@PathVariable String cseId, @PathVariable String stgId, 
			@ModelAttribute Studentgrade studentgrade) {
		studentgrade = lService.updateStudentgrade(studentgrade);
		ArrayList<Studentgrade> studentgrades=lService.findSpecificCourseStudentgrade(cseId);
		ModelAndView mav = new ModelAndView("StudentGradePage", "studentgrades", studentgrades);
		return mav;
	}
	
	@RequestMapping(value = "/studentsofspecificcourse/{cseId}")
	public ModelAndView studentPerformancePage(@PathVariable String cseId) {
		ArrayList<Enrollment> enrollments =lService.findSpecificCourseEnrollment(cseId);
		ArrayList<Student> students=new ArrayList<Student>();
		for (Enrollment enrollment : enrollments) {
			String cid = enrollment.getCourse().getCseId();
			
		}
	}

}
