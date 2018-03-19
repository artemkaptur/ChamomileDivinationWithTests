package by.htp.divination.bean;

import java.util.LinkedList;

public class Chamomile {
	private LinkedList<Petal> petals;
	private int petalsCount;

	public Chamomile() {
		super();
		createPetals();
	}

	private void createPetals() {
		petalsCount = (int) (Math.random() * 12 + 1);
		petals = new LinkedList<>();
		for (int i = 1; i <= petalsCount; i++) {
			petals.add(new Petal(i));
		}
	}

	public LinkedList<Petal> getPetals() {
		return petals;
	}

	public void setPetals(LinkedList<Petal> petals) {
		this.petals = petals;
	}

	public int getPetalsCount() {
		return petalsCount;
	}

	public void setPetalsCount(int petalsCount) {
		this.petalsCount = petalsCount;
	}

	@Override
	public String toString() {
		return "Chamomile [petals=" + petals + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((petals == null) ? 0 : petals.hashCode());
		result = prime * result + petalsCount;
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
		Chamomile other = (Chamomile) obj;
		if (petals == null) {
			if (other.petals != null)
				return false;
		} else if (!petals.equals(other.petals))
			return false;
		if (petalsCount != other.petalsCount)
			return false;
		return true;
	}

}
