package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel{

	private DeckAndGraveYardPanel deckAndGraveYardPanel;
	private CardPanel cardPanel;
	private PlayerStatusPanel playerStatusPanel;
	
	public PlayerPanel(){
		super();
//		this.setPreferredSize(new Dimension(400, 400));
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		cardPanel = new CardPanel();
		deckAndGraveYardPanel = new DeckAndGraveYardPanel();
		playerStatusPanel = new PlayerStatusPanel();
		this.add(cardPanel);
		this.add(deckAndGraveYardPanel);
		this.add(playerStatusPanel);
	}

	public CardPanel getCardPanel() {
		return cardPanel;
	}

	public void setCardPanel(CardPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public PlayerStatusPanel getPlayerStatusPanel() {
		return playerStatusPanel;
	}

	public void setPlayerStatusPanel(PlayerStatusPanel playerStatusPanel) {
		this.playerStatusPanel = playerStatusPanel;
	}

	public DeckAndGraveYardPanel getDeckAndGraveYardPanel() {
		return deckAndGraveYardPanel;
	}

	public void setDeckAndGraveYardPanel(DeckAndGraveYardPanel deckAndGraveYardPanel) {
		this.deckAndGraveYardPanel = deckAndGraveYardPanel;
	}

}
