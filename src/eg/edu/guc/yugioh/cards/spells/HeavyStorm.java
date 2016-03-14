package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HeavyStorm extends HarpieFeatherDuster{
	public HeavyStorm(String name ,String description){
		super(name,description);
	}
	public void action (MonsterCard monster){
		Board B = getBoard();
		Player p1 =B.getActivePlayer();
		Player p2 =B.getOpponentPlayer();
		super.sendSpellsToGraveyard(p1);
		super.sendSpellsToGraveyard(p2);
		monster=null;
		
	}

}
