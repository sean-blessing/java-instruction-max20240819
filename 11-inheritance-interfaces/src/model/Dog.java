package model;

public class Dog extends Animal {
	private boolean docked;
	private boolean pottyTrained;
	
	public Dog(String name, int birthYear, char gender, boolean docked, boolean pottyTrained) {
		super(name, birthYear, gender);
		this.docked = docked;
		this.pottyTrained = pottyTrained;
	}

	public boolean isDocked() {
		return docked;
	}

	public void setDocked(boolean docked) {
		this.docked = docked;
	}

	public boolean isPottyTrained() {
		return pottyTrained;
	}

	public void setPottyTrained(boolean pottyTrained) {
		this.pottyTrained = pottyTrained;
	}

	@Override
	public String toString() {
		return "Dog [docked=" + docked + ", pottyTrained=" + pottyTrained + ", speak()=" + speak() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public String speak() {
		return "Woof";
	}

	@Override
	public String whatICanDo() {
		return "speak on command, play dead";
	}

}
