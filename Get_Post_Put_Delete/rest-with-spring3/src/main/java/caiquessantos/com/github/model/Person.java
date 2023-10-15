package caiquessantos.com.github.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String FirstName;
	private String LastName;
	private String Adress;
	private String Gernder;
	
	public Person() {}

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

	public String getGernder() {
		return Gernder;
	}

	public void setGernder(String gernder) {
		Gernder = gernder;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Adress, FirstName, Gernder, LastName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(Adress, other.Adress) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(Gernder, other.Gernder) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(id, other.id);
	}

}
