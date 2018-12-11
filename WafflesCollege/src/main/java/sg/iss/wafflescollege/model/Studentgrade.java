package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the studentgrade database table.
 * 
 */
@Entity
@Table(name="studentgrade")
@NamedQuery(name="Studentgrade.findAll", query="SELECT s FROM Studentgrade s")
public class Studentgrade{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STG_ID")
	private int stgId;

	@Column(name="STG_GRADE")
	private String stgGrade;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="CSE_ID")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="STU_ID")
	private Student student;

	public Studentgrade() {
	}

	public int getStgId() {
		return this.stgId;
	}

	public void setStgId(int stgId) {
		this.stgId = stgId;
	}

	public String getStgGrade() {
		return this.stgGrade;
	}

	public void setStgGrade(String stgGrade) {
		this.stgGrade = stgGrade;
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
	public String toString() {
		return "Studentgrade [stgId=" + stgId + ", stgGrade=" + stgGrade + ", course=" + course + ", student=" + student
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((stgGrade == null) ? 0 : stgGrade.hashCode());
		result = prime * result + stgId;
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
		Studentgrade other = (Studentgrade) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (stgGrade == null) {
			if (other.stgGrade != null)
				return false;
		} else if (!stgGrade.equals(other.stgGrade))
			return false;
		if (stgId != other.stgId)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}
