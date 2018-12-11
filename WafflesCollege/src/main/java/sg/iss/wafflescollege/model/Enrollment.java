package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the enrollment database table.
 * 
 */
@Entity
@Table(name="enrollment")
@NamedQuery(name="Enrollment.findAll", query="SELECT e FROM Enrollment e")
public class Enrollment{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENR_ID")
	private int enrId;

	@Temporal(TemporalType.DATE)
	@Column(name="ENR_DATE")
	private Date enrDate;

	@Column(name="ENR_STATUS")
	private String enrStatus;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="CSE_ID")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="STU_ID")
	private Student student;

	public Enrollment() {
	}

	public int getEnrId() {
		return this.enrId;
	}

	public void setEnrId(int enrId) {
		this.enrId = enrId;
	}

	public Date getEnrDate() {
		return this.enrDate;
	}

	public void setEnrDate(Date enrDate) {
		this.enrDate = enrDate;
	}

	public String getEnrStatus() {
		return this.enrStatus;
	}

	public void setEnrStatus(String enrStatus) {
		this.enrStatus = enrStatus;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((enrDate == null) ? 0 : enrDate.hashCode());
		result = prime * result + enrId;
		result = prime * result + ((enrStatus == null) ? 0 : enrStatus.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Enrollment other = (Enrollment) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (enrDate == null) {
			if (other.enrDate != null)
				return false;
		} else if (!enrDate.equals(other.enrDate))
			return false;
		if (enrId != other.enrId)
			return false;
		if (enrStatus == null) {
			if (other.enrStatus != null)
				return false;
		} else if (!enrStatus.equals(other.enrStatus))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enrollment [enrId=" + enrId + ", enrDate=" + enrDate + ", enrStatus=" + enrStatus + ", course=" + course
				+ ", student=" + student + "]";
	}

	
}
