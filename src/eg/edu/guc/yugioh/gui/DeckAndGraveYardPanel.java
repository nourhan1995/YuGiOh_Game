package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeckAndGraveYardPanel extends JPanel{
	
	private CardButton graveYard;
	private CardButton deck;

	public DeckAndGraveYardPanel(){
		super();
		graveYard = new CardButton();
		deck = new CardButton();
		graveYard.setText("GraveYard");
		deck.setText("Deck " + "size to be added");
		this.setLayout(new GridLayout(2, 2));
		add(graveYard);
		add(deck);
	}

	public CardButton getGraveYard() {
		return graveYard;
	}

	public void setGraveYard(CardButton graveYard) {
		this.graveYard = graveYard;
	}

	public CardButton getDeck() {
		return deck;
	}

	public void setDeck(CardButton deck) {
		this.deck = deck;
	}

}
