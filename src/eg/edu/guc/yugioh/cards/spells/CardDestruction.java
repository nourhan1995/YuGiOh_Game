package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard {
	public CardDestruction(String name, String descrption) {
		super(name, descrption);
	}

	// Board B= new Board();
	// Player p1= B.getActivePlayer();
	// Player p2 = B.getOpponentPlayer();
	// Field f1=p1.getField();
	// Field f2=p2.getField();
	public void action(MonsterCard monster) {

		Board B = Card.getBoard();
		int n1 = B.getActivePlayer().getField().getHand().size();
		B.getActivePlayer().getField().removeHandToGraveyard(B.getActivePlayer().getField().getHand());
		B.getActivePlayer().getField().addNCardsToHand(n1);
		int n2 = B.getOpponentPlayer().getField().getHand().size();
		B.getOpponentPlayer().getField().removeHandToGraveyard(B.getOpponentPlayer().getField().getHand());
		B.getOpponentPlayer().getField().addNCardsToHand(n2);
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
