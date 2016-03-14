package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.Board;

abstract public class Card {
	
	private String name;
	private String description;
	private boolean isHidden = true;
	private Location location = Location.DECK;
	private static Board board;
	
	public Card(String name, String description){
		this.name = name;
		this.description = description;
	}	
	
	abstract public void action(MonsterCard opponentMonster);
	abstract public void action();

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static Board getBoard() {
		return board;
	}

	public static void setBoard(Board board) {
		Card.board = board;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	

}
