package roa.stats;

public class PlayerZeta {
	private String playerName;
	private String characterName;
	private String zetaName;

	public PlayerZeta(String playerName, String characterName, String zetaName) {
		super();
		this.playerName = playerName;
		this.characterName = characterName;
		this.zetaName = zetaName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getZetaName() {
		return zetaName;
	}

	public void setZetaName(String zetaName) {
		this.zetaName = zetaName;
	}
}
