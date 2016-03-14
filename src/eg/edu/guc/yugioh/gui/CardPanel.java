package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CardPanel extends JPanel{
	
	private MonstersAndSpellsPanel m;
	private HandPanel hand;
	
	public CardPanel(){
		super();
		this.setSize(300, 150);
		m = new MonstersAndSpellsPanel();
		hand = new HandPanel();
		this.setLayout(new BorderLayout());
		this.add(m, BorderLayout.NORTH);
		this.add(hand, BorderLayout.SOUTH);
	}

	public MonstersAndSpellsPanel getM() {
		return m;
	}

	public void setM(MonstersAndSpellsPanel m) {
		this.m = m;
	}

	public HandPanel getHand() {
		return hand;
	}

	public void setHand(HandPanel h) {
		this.hand = h;
	}

}
