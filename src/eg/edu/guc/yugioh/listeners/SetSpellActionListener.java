package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.gui.CardButton;
import eg.edu.guc.yugioh.gui.GUI;

public class SetSpellActionListener implements ActionListener{

	GUI gui;
	JButton click;

	public SetSpellActionListener(GUI gui) {
		// TODO Auto-generated constructor stub
		super();
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Board B = Card.getBoard();
		try{
			if(click == null){
				if(e.getSource() instanceof CardButton){
					click = (CardButton) e.getSource();
					if(B.getActivePlayer().getField().getSpellArea().size() <5){
						if(B.getActivePlayer().getName().equals(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText())){
							int CardIndex = gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(click);
							Card c = B.getActivePlayer().getField().getHand().get(CardIndex);
							if(c instanceof SpellCard){
								B.getActivePlayer().setSpell((SpellCard) c);
								while(B.getActivePlayer().getField().getHand().size() != gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size()){
									gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
								}
								for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
									gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
								}
							}
						}else{
							int CardIndex = gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(click);
							Card c = B.getActivePlayer().getField().getHand().get(CardIndex);
							if(c instanceof SpellCard){
								B.getActivePlayer().setSpell((SpellCard) c);
								while(B.getActivePlayer().getField().getHand().size() != gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size()){
									gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
								}
								for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
									gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
								}
							}
						}
					}else
						throw new Exception();

				}
			}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"No space for adding a spell in the field");
		}finally{
			click = null;
		}

	}

}
