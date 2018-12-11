package sg.iss.wafflescollege.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course{
	
	@Id
	@Column(name="CSE_ID")
	private String cseId;

	@Column(name="CSE_CREDIT")
	private int cseCredit;

	@Column(name="CSE_DESC")
	private String cseDesc;

	@Column(name="CSE_MAX_SIZE")
	private int cseMaxSize;

	@Temporal(TemporalType.DATE)
	@Column(name="CSE_STARTDATE")
	private Date cseStartdate;

	@Column(name="CSE_STATUS")
	private String cseStatus;

	//bi-directional many-to-one association to Lecturer
	@ManyToOne
	@JoinColumn(name="LEC_ID")
	private Lecturer lecturer;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="course")
	private List<Enrollment> enrollments;

	//bi-directional many-to-one association to Studentgrade
	@OneToMany(mappedBy="course")
	private List<Studentgrade> studentgrades;

	public Course() {
	}

	public String getCseId() {
		return this.cseId;
	}

	public void setCseId(String cseId) {
		this.cseId = cseId;
	}

	public int getCseCredit() {
		return this.cseCredit;
	}

	public void setCseCredit(int cseCredit) {
		this.cseCredit = cseCredit;
	}

	public String getCseDesc() {
		return this.cseDesc;
	}

	public void setCseDesc(String cseDesc) {
		this.cseDesc = cseDesc;
	}

	public int getCseMaxSize() {
		return this.cseMaxSize;
	}

	public void setCseMaxSize(int cseMaxSize) {
		this.cseMaxSize = cseMaxSize;
	}

	public Date getCseStartdate() {
		return this.cseStartdate;
	}

	public void setCseStartdate(Date cseStartdate) {
		this.cseStartdate = cseStartdate;
	}

	public String getCseStatus() {
		return this.cseStatus;
	}

	public void setCseStatus(String cseStatus) {
		this.cseStatus = cseStatus;
	}

	public Lecturer getLecturer() {
		return this.lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setCourse(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setCourse(null);

		return enrollment;
	}

	
	public List<Studentgrade> getStudentgrades() {
		return this.studentgrades;
	}

	public void setStudentgrades(List<Studentgrade> studentgrades) {
		this.studentgrades = studentgrades;
	}

	public Studentgrade addStudentgrade(Studentgrade studentgrade) {
		getStudentgrades().add(studentgrade);
		studentgrade.setCourse(this);

		return studentgrade;
	}

	public Studentgrade removeStudentgrade(Studentgrade studentgrade) {
		getStudentgrades().remove(studentgrade);
		studentgrade.setCourse(null);

		return studentgrade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cseCredit;
		result = prime * result + ((cseDesc == null) ? 0 : cseDesc.hashCode());
		result = prime * result + ((cseId == null) ? 0 : cseId.hashCode());
		result = prime * result + cseMaxSize;
		result = prime * result + ((cseStartdate == null) ? 0 : cseStartdate.hashCode());
		result = prime * result + ((cseStatus == null) ? 0 : cseStatus.hashCode());
		result = prime * result + ((enrollments == null) ? 0 : enrollments.hashCode());
		result = prime * result + ((lecturer == null) ? 0 : lecturer.hashCode());
		result = prime * result + ((studentgrades == null) ? 0 : studentgrades.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (cseCredit != other.cseCredit)
			return false;
		if (cseDesc == null) {
			if (other.cseDesc != null)
				return false;
		} else if (!cseDesc.equals(other.cseDesc))
			return false;
		if (cseId == null) {
			if (other.cseId != null)
				return false;
		} else if (!cseId.equals(other.cseId))
			return false;
		if (cseMaxSize != other.cseMaxSize)
			return false;
		if (cseStartdate == null) {
			if (other.cseStartdate != null)
				return false;
		} else if (!cseStartdate.equals(other.cseStartdate))
			return false;
		if (cseStatus == null) {
			if (other.cseStatus != null)
				return false;
		} else if (!cseStatus.equals(other.cseStatus))
			return false;
		if (enrollments == null) {
			if (other.enrollments != null)
				return false;
		} else if (!enrollments.equals(other.enrollments))
			return false;
		if (lecturer == null) {
			if (other.lecturer != null)
				return false;
		} else if (!lecturer.equals(other.lecturer))
			return false;
		if (studentgrades == null) {
			if (other.studentgrades != null)
				return false;
		} else if (!studentgrades.equals(other.studentgrades))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [cseId=" + cseId + ", cseCredit=" + cseCredit + ", cseDesc=" + cseDesc + ", cseMaxSize="
				+ cseMaxSize + ", cseStartdate=" + cseStartdate + ", cseStatus=" + cseStatus + ", lecturer=" + lecturer
				+ ", enrollments=" + enrollments + ", studentgrades=" + studentgrades + "]";
	}
	
	
	
}