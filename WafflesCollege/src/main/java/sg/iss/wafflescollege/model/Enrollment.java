package sg.iss.wafflescollege.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

 
/**
 * The persistent class for the enrollment database table.
 * 
 */
@Entity
@NamedQuery(name="Enrollment.findAll", query="SELECT e FROM Enrollment e")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String APPROVED ="Äpproved";
	public static final String REJECTED ="Rejected";
	@Id
	@Column(name="ENR_ID")
	private int enrId;

	@Temporal(TemporalType.DATE)
	@Column(name="ENR_DATE")
	@DateTimeFormat(pattern="dd/MM/yyyy")
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
	
    public void setStatus(String enrStatus) {
      	 this.enrStatus = enrStatus;
       }


}