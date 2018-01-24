package roa.stats;

public class Ship {
	private String name;
	private int level;
	private int stars;

	public Ship(String name, int level, int stars) {
		super();
		this.name = name;
		this.level = level;
		this.stars = stars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
}
