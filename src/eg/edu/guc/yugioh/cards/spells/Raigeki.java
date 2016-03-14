package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class Raigeki extends SpellCard{

	public Raigeki(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	
	public void action(MonsterCard monster){
		Board B = Card.getBoard();
		B.getOpponentPlayer().getField().removeMonsterToGraveyard(B.getOpponentPlayer().getField().getMonstersArea());
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
