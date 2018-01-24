package roa.stats;

public class Character {

	private String name;
	private int level;
	private int stars;
	private int gear;
	private String type;

	public Character(String name, int level, int stars, int gear, String type) {
		super();
		this.name = name;
		this.level = level;
		this.stars = stars;
		this.gear = gear;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}
}
