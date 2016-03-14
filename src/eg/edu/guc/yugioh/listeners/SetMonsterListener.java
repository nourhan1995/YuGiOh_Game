package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.gui.CardButton;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.MonsterCardButton;

public class SetMonsterListener implements ActionListener{
	
	GUI gui;
	JButton firstClick;
	JButton secondClick;
	JButton thirdClick;
	
	public SetMonsterListener(GUI gui) {
		// TODO Auto-generated constructor stub
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
					try{
						int handMonsterButtonIndex = gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(secondClick);
						Card c = B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex);
						if(c instanceof MonsterCard){
							int level = ((MonsterCard) c).getLevel();
							if(level >= 1 && level <= 4){
								B.getActivePlayer().setMonster((MonsterCard) B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex));
								for (int i = 0; i < B.getActivePlayer().getField().getMonstersArea().size(); i++) {
									if(B.getActivePlayer().getField().getMonstersArea().get(i).getMode() == Mode.ATTACK)
										gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName() + " A");
									else
										gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("D");
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
							}
							if(!B.getActivePlayer().getField().getMonstersArea().isEmpty()){
								if(level >= 5 && level <= 6){
									if(e.getSource() instanceof MonsterCardButton){
										secondClick = (MonsterCardButton) e.getSource();
										int sacrificeIndex = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(thirdClick);
										ArrayList<MonsterCard> sacrifices = new ArrayList<MonsterCard>();
										sacrifices.add(B.getActivePlayer().getField().getMonstersArea().get(sacrificeIndex));
										B.getActivePlayer().setMonster((MonsterCard) B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex), sacrifices);
									}
									for (int i = 0; i < B.getActivePlayer().getField().getMonstersArea().size(); i++) {
										gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName());
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
								}
								if(level >= 7 && level <= 8){
									if(e.getSource() instanceof MonsterCardButton){
										thirdClick = (MonsterCardButton) e.getSource();
										if(e.getSource() instanceof MonsterCardButton){
											thirdClick = (MonsterCardButton) e.getSource();
											int sacrificeIndex1 = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(thirdClick);
											int sacrificeIndex2 = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(thirdClick);
											ArrayList<MonsterCard> sacrifices =new ArrayList<MonsterCard>();
											sacrifices.add(B.getActivePlayer().getField().getMonstersArea().get(sacrificeIndex1));
											sacrifices.add(B.getActivePlayer().getField().getMonstersArea().get(sacrificeIndex2));
											B.getActivePlayer().setMonster((MonsterCard) B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex), sacrifices);
										}
									}
									for (int i = 0; i < B.getActivePlayer().getField().getMonstersArea().size(); i++) {
										if(B.getActivePlayer().getField().getMonstersArea().get(i).getMode() == Mode.ATTACK)
											gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName() + " A");
										else
											gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("D");
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
								}
							}else{
								throw new Exception();
							}
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "The monster you tried to add needs sacrifices and you have none. ");
					}finally{
						firstClick = null;
						secondClick = null;
						thirdClick = null;
					}
				}else{
					try{
						int handMonsterButtonIndex = gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().indexOf(secondClick);
						Card c = B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex);
						if(c instanceof MonsterCard){
							int level = ((MonsterCard) c).getLevel();
							if(level >= 1 && level <= 4){
								B.getActivePlayer().setMonster((MonsterCard) B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex));
								for (int i = 0; i < B.getActivePlayer().getField().getMonstersArea().size(); i++) {
									gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName());
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
							}if(!B.getActivePlayer().getField().getMonstersArea().isEmpty()){
								if(level >= 5 && level <= 6){
									if(e.getSource() instanceof MonsterCardButton){
										secondClick = (MonsterCardButton) e.getSource();
										int sacrificeIndex = gui.getP2().getCardPanel().getM().getMonsterAreaButtons().indexOf(thirdClick);
										ArrayList<MonsterCard> sacrifices = new ArrayList<MonsterCard>();
										sacrifices.add(B.getActivePlayer().getField().getMonstersArea().get(sacrificeIndex));
										B.getActivePlayer().setMonster((MonsterCard) B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex), sacrifices);
									}
									for (int i = 0; i < B.getActivePlayer().getField().getMonstersArea().size(); i++) {
										if(B.getActivePlayer().getField().getMonstersArea().get(i).getMode() == Mode.ATTACK)
											gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName() + " A");
										else
											gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("D");
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

								}
								if(level >= 7 && level <= 8){
									if(e.getSource() instanceof MonsterCardButton){
										secondClick = (MonsterCardButton) e.getSource();
										if(e.getSource() instanceof MonsterCardButton){
											thirdClick = (MonsterCardButton) e.getSource();
											int sacrificeIndex1 = gui.getP2().getCardPanel().getM().getMonsterAreaButtons().indexOf(thirdClick);
											int sacrificeIndex2 = gui.getP2().getCardPanel().getM().getMonsterAreaButtons().indexOf(thirdClick);
											ArrayList<MonsterCard> sacrifices =new ArrayList<MonsterCard>();
											sacrifices.add(B.getActivePlayer().getField().getMonstersArea().get(sacrificeIndex1));
											sacrifices.add(B.getActivePlayer().getField().getMonstersArea().get(sacrificeIndex2));
											B.getActivePlayer().setMonster((MonsterCard) B.getActivePlayer().getField().getHand().get(handMonsterButtonIndex), sacrifices);
										}
									}	
									for (int i = 0; i < B.getActivePlayer().getField().getMonstersArea().size(); i++) {
										if(B.getActivePlayer().getField().getMonstersArea().get(i).getMode() == Mode.ATTACK)
											gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName() + " A");
										else
											gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("D");
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

								}
							}else{
								throw new Exception();
							}
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "The monster you tried to add needs sacrifices and you have none. ");
					}finally{
						firstClick = null;
						secondClick = null;
						thirdClick = null;
					}
				}
			}
		}
	}


}
