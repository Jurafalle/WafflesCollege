package sg.iss.wafflescollege.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
public class Student{
	

	@Id
	@Column(name="STU_ID")
	private String stuId;

	@Column(name="STU_ADDRESS")
	private String stuAddress;

	@Column(name="STU_EMAIL")
	private String stuEmail;

	@Column(name="STU_FIRSTMIDNAME")
	private String stuFirstmidname;

	@Column(name="STU_LASTNAME")
	private String stuLastname;

	@Column(name="STU_PHONE_NO")
	private String stuPhoneNo;

	@Column(name="STU_STATUS")
	private String stuStatus;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="student")
	private List<Enrollment> enrollments;

	//bi-directional many-to-one association to Studentgrade
	@OneToMany(mappedBy="student")
	private List<Studentgrade> studentgrades;

	public Student() {
	}

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuAddress() {
		return this.stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuEmail() {
		return this.stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getStuFirstmidname() {
		return this.stuFirstmidname;
	}

	public void setStuFirstmidname(String stuFirstmidname) {
		this.stuFirstmidname = stuFirstmidname;
	}

	public String getStuLastname() {
		return this.stuLastname;
	}

	public void setStuLastname(String stuLastname) {
		this.stuLastname = stuLastname;
	}

	public String getStuPhoneNo() {
		return this.stuPhoneNo;
	}

	public void setStuPhoneNo(String stuPhoneNo) {
		this.stuPhoneNo = stuPhoneNo;
	}

	public String getStuStatus() {
		return this.stuStatus;
	}

	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setStudent(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setStudent(null);

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
		studentgrade.setStudent(this);

		return studentgrade;
	}

	public Studentgrade removeStudentgrade(Studentgrade studentgrade) {
		getStudentgrades().remove(studentgrade);
		studentgrade.setStudent(null);

		return studentgrade;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuAddress=" + stuAddress + ", stuEmail=" + stuEmail
				+ ", stuFirstmidname=" + stuFirstmidname + ", stuLastname=" + stuLastname + ", stuPhoneNo=" + stuPhoneNo
				+ ", stuStatus=" + stuStatus + ", enrollments=" + enrollments + ", studentgrades=" + studentgrades
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enrollments == null) ? 0 : enrollments.hashCode());
		result = prime * result + ((stuAddress == null) ? 0 : stuAddress.hashCode());
		result = prime * result + ((stuEmail == null) ? 0 : stuEmail.hashCode());
		result = prime * result + ((stuFirstmidname == null) ? 0 : stuFirstmidname.hashCode());
		result = prime * result + ((stuId == null) ? 0 : stuId.hashCode());
		result = prime * result + ((stuLastname == null) ? 0 : stuLastname.hashCode());
		result = prime * result + ((stuPhoneNo == null) ? 0 : stuPhoneNo.hashCode());
		result = prime * result + ((stuStatus == null) ? 0 : stuStatus.hashCode());
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
		Student other = (Student) obj;
		if (enrollments == null) {
			if (other.enrollments != null)
				return false;
		} else if (!enrollments.equals(other.enrollments))
			return false;
		if (stuAddress == null) {
			if (other.stuAddress != null)
				return false;
		} else if (!stuAddress.equals(other.stuAddress))
			return false;
		if (stuEmail == null) {
			if (other.stuEmail != null)
				return false;
		} else if (!stuEmail.equals(other.stuEmail))
			return false;
		if (stuFirstmidname == null) {
			if (other.stuFirstmidname != null)
				return false;
		} else if (!stuFirstmidname.equals(other.stuFirstmidname))
			return false;
		if (stuId == null) {
			if (other.stuId != null)
				return false;
		} else if (!stuId.equals(other.stuId))
			return false;
		if (stuLastname == null) {
			if (other.stuLastname != null)
				return false;
		} else if (!stuLastname.equals(other.stuLastname))
			return false;
		if (stuPhoneNo == null) {
			if (other.stuPhoneNo != null)
				return false;
		} else if (!stuPhoneNo.equals(other.stuPhoneNo))
			return false;
		if (stuStatus == null) {
			if (other.stuStatus != null)
				return false;
		} else if (!stuStatus.equals(other.stuStatus))
			return false;
		if (studentgrades == null) {
			if (other.studentgrades != null)
				return false;
		} else if (!studentgrades.equals(other.studentgrades))
			return false;
		return true;
	}
	
	

}