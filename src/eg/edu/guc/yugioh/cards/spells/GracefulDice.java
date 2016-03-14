package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard {
	public GracefulDice(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster) {
		double x = Math.random() * 10.0;
		int y = (int) x + 1;
		int z = y * 100;
		Board B = Card.getBoard();
		Player p1 = B.getActivePlayer();
		ArrayList<MonsterCard> monsters = p1.getField().getMonstersArea();
		for (int s = 0; s < monsters.size(); s++) {
			MonsterCard f = monsters.get(s);
			f.setAttackPoints(f.getAttackPoints() + z);
			f.setDefensePoints(f.getDefensePoints() + z);

		}
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}
