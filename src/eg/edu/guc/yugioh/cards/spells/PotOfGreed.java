package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class PotOfGreed extends SpellCard{

	public PotOfGreed(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster){

		Board B = Card.getBoard();
		B.getActivePlayer().getField().addNCardsToHand(2);

	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

}
