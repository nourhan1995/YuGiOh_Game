package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

abstract public class SpellCard extends Card {

	public SpellCard(String name, String description) {
		super(name, description);
	}

	// to be implemented
	@Override
	abstract public void action(MonsterCard monster) ;

}
