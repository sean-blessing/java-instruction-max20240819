package model;

public class Cat extends Animal {
	private boolean declawed;
	private char indoorOutdoor;
	
	public Cat(String name, int birthYear, char gender, boolean declawed, char indoorOutdoor) {
		super(name, birthYear, gender);
		this.declawed = declawed;
		this.indoorOutdoor = indoorOutdoor;
	}

	public boolean isDeclawed() {
		return declawed;
	}

	public void setDeclawed(boolean declawed) {
		this.declawed = declawed;
	}

	public char getIndoorOutdoor() {
		return indoorOutdoor;
	}

	public void setIndoorOutdoor(char indoorOutdoor) {
		this.indoorOutdoor = indoorOutdoor;
	}

	@Override
	public String speak() {
		return "Meow";
	}

	@Override
	public String toString() {
		return "Cat [declawed=" + declawed + ", indoorOutdoor=" + indoorOutdoor + ", speak()=" + speak()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public String whatICanDo() {
		return "boopidasnoot, potty outside";
	}
	
	
}
