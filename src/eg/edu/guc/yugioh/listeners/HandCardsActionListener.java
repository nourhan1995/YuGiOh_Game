package eg.edu.guc.yugioh.listeners;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.gui.CardButton;
import eg.edu.guc.yugioh.gui.GUI;

public class HandCardsActionListener implements ActionListener{
	
	GUI gui;
	JButton click;
	
	public HandCardsActionListener(GUI gui) {
		// TODO Auto-generated constructor stub
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Board B = Card.getBoard();
		if(click == null){
			if(e.getSource() instanceof CardButton){
				click = (CardButton) e.getSource();
				if(B.getActivePlayer().getName().equals(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText())){
					int CardIndex = gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(click);
					if(B.getActivePlayer().getField().getHand().get(CardIndex) instanceof MonsterCard){
						String monsterName = B.getActivePlayer().getField().getHand().get(CardIndex).getName();
						Icon icon = null;
						for (int i = 0; i < GUI.getMonsterNames().length; i++) {
							if(GUI.getMonsterNames()[i].equals(monsterName)){
								icon = new ImageIcon(GUI.getMonsterPaths()[i]);
								break;
							}
						}
						Image img = ((ImageIcon) icon).getImage();
						Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
						Icon newIcon = new ImageIcon(newImage);
						gui.getCardDisplay().setIcon(newIcon);
					}else{
						String spellName = B.getActivePlayer().getField().getHand().get(CardIndex).getName();
						Icon icon = null;
						for (int i = 0; i < GUI.getSpellNames().length; i++) {
							if(GUI.getMonsterNames()[i].equals(spellName)){
								icon = new ImageIcon(GUI.getSpellPaths()[i]);
								break;
							}
						}
						Image img = ((ImageIcon) icon).getImage();
						Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
						Icon newIcon = new ImageIcon(newImage);
						gui.getCardDisplay().setIcon(newIcon);
					}
				}else{
					int CardIndex = gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(click);
					if(B.getActivePlayer().getField().getHand().get(CardIndex) instanceof MonsterCard){
						String monsterName = B.getActivePlayer().getField().getHand().get(CardIndex).getName();
						Icon icon = null;
						for (int i = 0; i < GUI.getMonsterNames().length; i++) {
							if(GUI.getMonsterNames()[i].equals(monsterName)){
								icon = new ImageIcon(GUI.getMonsterPaths()[i]);
								break;
							}
						}
						Image img = ((ImageIcon) icon).getImage();
						Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
						Icon newIcon = new ImageIcon(newImage);
						gui.getCardDisplay().setIcon(newIcon);
					}else{
						String spellName = B.getActivePlayer().getField().getHand().get(CardIndex).getName();
						Icon icon = null;
						for (int i = 0; i < GUI.getSpellNames().length; i++) {
							if(GUI.getSpellNames()[i].equals(spellName)){
								icon = new ImageIcon(GUI.getSpellPaths()[i]);
								break;
							}
						}
						Image img = ((ImageIcon) icon).getImage();
						Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
						Icon newIcon = new ImageIcon(newImage);
						gui.getCardDisplay().setIcon(newIcon);
					}
				}
			}
			click = null;
		}
	}
	

}
