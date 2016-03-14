package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.gui.CardButton;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.MonsterCardButton;
import eg.edu.guc.yugioh.gui.SpellCardButton;

public class ActivateSpellActionListener implements ActionListener {

	GUI gui;
	JButton firstClick;
	JButton secondClick;

	public ActivateSpellActionListener(GUI gui) {
		// TODO Auto-generated constructor stub
		super();
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Board B = Card.getBoard();
		if(firstClick == null){
			if(e.getSource() instanceof CardButton){
				firstClick = (CardButton) e.getSource();
				if(B.getActivePlayer().getName().equals(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText())){
					int CardIndex = gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(firstClick);
					Card c = B.getActivePlayer().getField().getHand().get(CardIndex);
					if(c instanceof SpellCard){
						if(c.getName().equals("Change Of Heart") || c.getName().equals("Mage Power")){
							if(e.getSource() instanceof MonsterCardButton){
								secondClick = (MonsterCardButton) e.getSource();
								int monsterIndex = gui.getP2().getCardPanel().getM().getMonsterAreaButtons().indexOf(secondClick);
								MonsterCard m = B.getOpponentPlayer().getField().getMonstersArea().get(monsterIndex);
								B.getActivePlayer().activateSpell((SpellCard) c, m);
								for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
									gui.getP1().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
								}
								if(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
									while(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
										gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
									}
									for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
										gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
									}
								}
								gui.getP1().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
								gui.getP2().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
							}
						}else{
							B.getActivePlayer().activateSpell((SpellCard) c, null);
							for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
								gui.getP1().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
							}
							if(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
								while(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
									gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
								}
								for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
									gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
								}
							}
							gui.getP1().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
							gui.getP2().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
						}
					}
				}else{
					int CardIndex = gui.getP2().getCardPanel().getM().getSpellAreaButtons().indexOf(firstClick);
					Card c = B.getActivePlayer().getField().getSpellArea().get(CardIndex);
					if(c instanceof SpellCard){
						if(c.getName().equals("Change Of Heart") || c.getName().equals("Mage Power")){
							if(e.getSource() instanceof MonsterCardButton){
								secondClick = (MonsterCardButton) e.getSource();
								int monsterIndex = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(secondClick);
								MonsterCard m = B.getOpponentPlayer().getField().getMonstersArea().get(monsterIndex);
								B.getActivePlayer().activateSpell((SpellCard) c, m);
								for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
									gui.getP2().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
								}
								if(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
									while(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
										gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
									}
									for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
										gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
									}
								}
								gui.getP2().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
								gui.getP1().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
							}
						}else{
							B.getActivePlayer().activateSpell((SpellCard) c, null);
							for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
								gui.getP2().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
							}
							if(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
								while(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
									gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
								}
								for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
									gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
								}
							}
							gui.getP2().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
							gui.getP1().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
						}
					}
				}
			}
			if(e.getSource() instanceof SpellCardButton){
				firstClick = (SpellCardButton) e.getSource();
				if(B.getActivePlayer().getName().equals(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText())){
					int CardIndex = gui.getP1().getCardPanel().getM().getSpellAreaButtons().indexOf(firstClick);
					SpellCard c = B.getActivePlayer().getField().getSpellArea().get(CardIndex);			
					if(c.getName().equals("Change Of Heart") || c.getName().equals("Mage Power")){
						if(e.getSource() instanceof MonsterCardButton){
							secondClick = (MonsterCardButton) e.getSource();
							int monsterIndex = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(secondClick);
							MonsterCard m = B.getOpponentPlayer().getField().getMonstersArea().get(monsterIndex);
							B.getActivePlayer().activateSpell((SpellCard) c, m);
							for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
								gui.getP1().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
							}
							if(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
								while(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
									gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
								}
								for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
									gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
								}
							}
							gui.getP1().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
							gui.getP2().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
						}
					}else{
						B.getActivePlayer().activateSpell(c, null);
						for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
							gui.getP1().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
						}
						if(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
							while(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
								gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
							}
							for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
								gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
							}
						}
						gui.getP1().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
						gui.getP2().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
					}
				}else{
					int CardIndex = gui.getP2().getCardPanel().getM().getSpellAreaButtons().indexOf(firstClick);
					Card c = B.getActivePlayer().getField().getSpellArea().get(CardIndex);
					if(c instanceof SpellCard){
						if(c.getName().equals("Change Of Heart") || c.getName().equals("Mage Power")){
							if(e.getSource() instanceof MonsterCardButton){
								secondClick = (MonsterCardButton) e.getSource();
								int monsterIndex = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(secondClick);
								MonsterCard m = B.getOpponentPlayer().getField().getMonstersArea().get(monsterIndex);
								B.getActivePlayer().activateSpell((SpellCard) c, m);
								for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
									gui.getP2().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
								}
								if(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
									while(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
										gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
									}
									for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
										gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
									}
								}
								gui.getP2().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
								gui.getP1().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
							}
						}else{
							B.getActivePlayer().activateSpell((SpellCard) c, null);
							for (int i = 0; i < B.getActivePlayer().getField().getSpellArea().size(); i++) {
								gui.getP2().getCardPanel().getM().getSpellAreaButtons().get(i).setText(B.getActivePlayer().getField().getSpellArea().get(i).getName());
							}
							if(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() > B.getActivePlayer().getField().getHand().size()){
								while(gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != B.getActivePlayer().getField().getHand().size()){
									gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().remove(0);
								}
								for (int i = 0; i < B.getActivePlayer().getField().getHand().size(); i++) {
									gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(B.getActivePlayer().getField().getHand().get(i).getName());
								}
							}
							gui.getP2().getDeckAndGraveYardPanel().getDeck().setText("Deck " + B.getActivePlayer().getField().getDeck().getDeck().size());
							gui.getP1().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
						}
					}
				}
			}
			firstClick = null;
		}
	}

}
