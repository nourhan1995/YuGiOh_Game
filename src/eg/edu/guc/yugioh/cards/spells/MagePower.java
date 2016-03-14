package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MagePower extends SpellCard {
	
	public MagePower(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster) {
		Board B = Card.getBoard();
		int s = B.getActivePlayer().getField().getSpellArea().size();
		monster.setAttackPoints(monster.getAttackPoints() + s * 500);
		monster.setDefensePoints(monster.getDefensePoints() + s * 500);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
