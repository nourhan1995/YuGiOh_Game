package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;



public class ChangeOfHeart extends SpellCard {
	// Board B= new Board();
	// Player p1 = B.getActivePlayer();//active player
	// Player p2 =B.getOpponentPlayer();
	public ChangeOfHeart(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster) {
		Board B = Card.getBoard();
		Player p1 = B.getActivePlayer();// active player
		Player p2 = B.getOpponentPlayer();
		p1.getField().addMonsterToField(monster, monster.getMode(), false);
		p2.getField().getMonstersArea().remove(monster);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
