package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User{
	
	@Id
	@Column(name="USE_ID")
	private String useId;

	@Column(name="USE_PASSWORD")
	private String usePassword;

	@Column(name="USE_ROLE")
	private String useRole;

	public User() {
	}

	public String getUseId() {
		return this.useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getUsePassword() {
		return this.usePassword;
	}

	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}

	public String getUseRole() {
		return this.useRole;
	}

	public void setUseRole(String useRole) {
		this.useRole = useRole;
	}

	@Override
	public String toString() {
		return "User [useId=" + useId + ", usePassword=" + usePassword + ", useRole=" + useRole + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((useId == null) ? 0 : useId.hashCode());
		result = prime * result + ((usePassword == null) ? 0 : usePassword.hashCode());
		result = prime * result + ((useRole == null) ? 0 : useRole.hashCode());
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
		User other = (User) obj;
		if (useId == null) {
			if (other.useId != null)
				return false;
		} else if (!useId.equals(other.useId))
			return false;
		if (usePassword == null) {
			if (other.usePassword != null)
				return false;
		} else if (!usePassword.equals(other.usePassword))
			return false;
		if (useRole == null) {
			if (other.useRole != null)
				return false;
		} else if (!useRole.equals(other.useRole))
			return false;
		return true;
	}
	
	

}