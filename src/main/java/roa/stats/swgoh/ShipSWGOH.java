package roa.stats.swgoh;

public class ShipSWGOH {
	private String name;
	private String base_id;
	private String url;
	private String image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase_id() {
		return base_id;
	}

	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCombat_type() {
		return combat_type;
	}

	public void setCombat_type(int combat_type) {
		this.combat_type = combat_type;
	}

	private int power;
	private String description;
	private int combat_type;
}