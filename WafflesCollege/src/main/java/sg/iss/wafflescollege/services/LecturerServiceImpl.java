package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.repo.CourseRepository;
import sg.iss.wafflescollege.repo.EnrollmentRepository;
import sg.iss.wafflescollege.repo.LecturerRepository;
import sg.iss.wafflescollege.repo.StudentRepository;
import sg.iss.wafflescollege.repo.StudentgradeRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepo;

	@Resource
	CourseRepository crepo;

	@Resource
	EnrollmentRepository erepo;

	@Resource
	StudentgradeRepository sgrepo;

	@Resource
	StudentRepository srepo;

	@Override
	@Transactional
	public ArrayList<Course> findCourseTaught(String lecId) {
		return (ArrayList<Course>) crepo.findCourseByLecId(lecId);
	}

	@Override
	@Transactional

	public ArrayList<Course> findAllCourse() {
		return (ArrayList<Course>) crepo.findAll();

	}

	@Override
	@Transactional

	public ArrayList<Enrollment> findSpecificCourseEnrollment(String cseId) {
		return (ArrayList<Enrollment>) erepo.findEnrollmentByCseId(cseId);
	}

	@Override
	@Transactional
	public Course findCourse(String cseId) {
		return crepo.findCourseByCseId(cseId);
	}

	@Override
	@Transactional
	public ArrayList<Studentgrade> findSpecificCourseStudentgrade(String cseId) {
		ArrayList<Enrollment> enlist1=(ArrayList<Enrollment>) erepo.findApprovedEnrollmentByCseId(cseId);
		ArrayList<Enrollment> enlist2=(ArrayList<Enrollment>) erepo.findCompletedEnrollmentByCseId(cseId);
		for (Enrollment enrollment : enlist2) {
			enlist1.add(enrollment);
		}
		ArrayList<Studentgrade> result=new ArrayList<Studentgrade>();
		for (Enrollment enrollment : enlist1) {
			int sgId=enrollment.getEnrId();
			result.add(sgrepo.findStudentgradeByStgId(sgId));
		}
		return result;
	}

	@Override
	@Transactional
	public Studentgrade updateStudentgrade(Studentgrade studentgrade) {
		sgrepo.saveAndFlush(studentgrade);
		return studentgrade;
	}

	@Override
	@Transactional
	public ArrayList<Student> findSpecificCourseStudents(String cseId) {
		ArrayList<Enrollment> enrollments = erepo.findEnrollmentByCseId(cseId);
		ArrayList<Student> students = new ArrayList<Student>();
		for (Enrollment enrollment : enrollments) {
			String stuId = enrollment.getStudent().getStuId();
			Student newstu = srepo.findStudentByStuId(stuId);
			students.add(newstu);
		}
		return students;

	}
}
