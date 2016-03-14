package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Field;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HarpieFeatherDuster extends SpellCard {
	
	public HarpieFeatherDuster(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster) {
		Board B = Card.getBoard();
		Player p = B.getOpponentPlayer();
		sendSpellsToGraveyard(p);
	}

	public void sendSpellsToGraveyard(Player p) {
		Field f = p.getField();
		f.removeSpellToGraveyard(f.getSpellArea());

	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
