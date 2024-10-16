package model;

public abstract class Animal implements Trainable {
	
	private String name;
	private int birthYear;
	private char gender;
	
	public Animal(String name, int birthYear, char gender) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public abstract String speak();

	@Override
	public String toString() {
		return "Animal [name=" + name + ", birthYear=" + birthYear + ", gender=" + gender + "]";
	}
	
}
