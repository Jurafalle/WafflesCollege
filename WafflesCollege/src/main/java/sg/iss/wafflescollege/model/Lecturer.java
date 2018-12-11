package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lecturer database table.
 * 
 */
@Entity
@Table(name="lecturer")
public class Lecturer{
	
	@Id
	@Column(name="LEC_ID")
	private String lecId;

	@Column(name="LEC_FIRSTMIDNAME")
	private String lecFirstmidname;

	@Column(name="LEC_LASTNAME")
	private String lecLastname;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="lecturer")
	private List<Course> courses;

	public Lecturer() {
	}

	public String getLecId() {
		return this.lecId;
	}

	public void setLecId(String lecId) {
		this.lecId = lecId;
	}

	public String getLecFirstmidname() {
		return this.lecFirstmidname;
	}

	public void setLecFirstmidname(String lecFirstmidname) {
		this.lecFirstmidname = lecFirstmidname;
	}

	public String getLecLastname() {
		return this.lecLastname;
	}

	public void setLecLastname(String lecLastname) {
		this.lecLastname = lecLastname;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((lecFirstmidname == null) ? 0 : lecFirstmidname.hashCode());
		result = prime * result + ((lecId == null) ? 0 : lecId.hashCode());
		result = prime * result + ((lecLastname == null) ? 0 : lecLastname.hashCode());
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
		Lecturer other = (Lecturer) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (lecFirstmidname == null) {
			if (other.lecFirstmidname != null)
				return false;
		} else if (!lecFirstmidname.equals(other.lecFirstmidname))
			return false;
		if (lecId == null) {
			if (other.lecId != null)
				return false;
		} else if (!lecId.equals(other.lecId))
			return false;
		if (lecLastname == null) {
			if (other.lecLastname != null)
				return false;
		} else if (!lecLastname.equals(other.lecLastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lecturer [lecId=" + lecId + ", lecFirstmidname=" + lecFirstmidname + ", lecLastname=" + lecLastname
				+ ", courses=" + courses + "]";
	}

	/*public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setLecturer(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setLecturer(null);

		return cours;
	}*/

	
}
