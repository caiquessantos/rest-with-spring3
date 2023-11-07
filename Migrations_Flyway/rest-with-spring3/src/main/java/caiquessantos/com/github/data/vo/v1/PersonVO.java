package caiquessantos.com.github.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String FirstName;	
	private String LastName;
	private String Gender;
	private String Adress;
	
	public PersonVO() {}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}


	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Adress, FirstName, Gender, LastName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(Adress, other.Adress) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(Gender, other.Gender) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(id, other.id);
	}

}
