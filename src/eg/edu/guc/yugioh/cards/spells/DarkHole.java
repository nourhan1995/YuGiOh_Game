package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {

	public DarkHole(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	
	public void action(MonsterCard monster){
		
		Board B = Card.getBoard();
		super.action();
		B.getActivePlayer().getField().removeMonsterToGraveyard(B.getActivePlayer().getField().getMonstersArea());
	}
	
	public void helper(Player p){
		
		p.getField().removeMonsterToGraveyard(p.getField().getMonstersArea());
		
	}
	
	

}
