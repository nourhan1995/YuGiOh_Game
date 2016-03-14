package eg.edu.guc.yugioh.gui;

import java.util.ArrayList;

import javax.swing.JPanel;

public class HandButtonsPanel extends JPanel{
	
	private ArrayList<CardButton> hand;
	
	public HandButtonsPanel() {
		// TODO Auto-generated constructor stub
		super();
		hand = new ArrayList<CardButton>();
		for (int i = 0; i < 5; i++) {
			CardButton c = new CardButton();
			hand.add(c);
			this.add(c);
		}
	}

	public ArrayList<CardButton> getHand() {
		return hand;
	}

	public void setHand(ArrayList<CardButton> hand) {
		this.hand = hand;
	}

}
