package sg.iss.wafflescollege.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.wafflescollege.model.Course;

@Component
public class CourseValidator implements Validator {
	
	public CourseValidator() {
	
	}
	
	public boolean supports(Class<?> arg0) {
		return Course.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Course course = (Course) arg0;	
	
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "courseName", "error.courseName", "Course name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "StartDate", "error.fromDate", "From Date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "toDate", "error.toDate", "To Date is required.");
	}


}
