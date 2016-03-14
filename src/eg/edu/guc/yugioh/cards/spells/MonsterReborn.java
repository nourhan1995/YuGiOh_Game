package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard {

	public MonsterReborn(String name, String description) {
		super(name, description);
	}

	public void action(MonsterCard monster) {
		Board B = Card.getBoard();
		int max1 = 0;
		MonsterCard highest = null;
		for (int i = 0; i < B.getActivePlayer().getField().getGraveyard()
				.size(); i++) {
			if (B.getActivePlayer().getField().getGraveyard().get(i) instanceof MonsterCard) {
				if (((MonsterCard) (B.getActivePlayer().getField()
						.getGraveyard().get(i))).getAttackPoints() > max1) {
					max1 = ((MonsterCard) (B.getActivePlayer().getField()
							.getGraveyard().get(i))).getAttackPoints();
					highest = ((MonsterCard) (B.getActivePlayer().getField()
							.getGraveyard().get(i)));
				}
			}

		}
		for (int i = 0; i < B.getOpponentPlayer().getField().getGraveyard()
				.size(); i++) {
			if (B.getOpponentPlayer().getField().getGraveyard().get(i) instanceof MonsterCard) {
				if (((MonsterCard) (B.getOpponentPlayer().getField()
						.getGraveyard().get(i))).getAttackPoints() > max1) {
					max1 = ((MonsterCard) (B.getOpponentPlayer().getField()
							.getGraveyard().get(i))).getAttackPoints();
					highest = ((MonsterCard) (B.getOpponentPlayer().getField()
							.getGraveyard().get(i)));
				}
			}
		}
		if (highest == null)
			return;
		else if (B.getActivePlayer().getField().getGraveyard().contains(highest)) {
			B.getActivePlayer().getField().getGraveyard().remove(highest);
		} else {
			B.getOpponentPlayer().getField().getGraveyard().remove(highest);
		}
		B.getActivePlayer().getField().getMonstersArea().add(highest);
		highest.setLocation(Location.FIELD);

	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
}