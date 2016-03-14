package eg.edu.guc.yugioh.listeners;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.MonsterCardButton;

public class MonsterAreaActionListener implements ActionListener {
	
	GUI gui;
	JButton click;
	
	public MonsterAreaActionListener(GUI gui) {
		// TODO Auto-generated constructor stub
		super();
		this.gui = gui;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Board B = Card.getBoard();
		if(click == null){
			if(e.getSource() instanceof MonsterCardButton){
				click = (MonsterCardButton) e.getSource();
				if(B.getActivePlayer().getName().equals(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText())){
					int monsterIndex = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(click);
					String monsterName = B.getActivePlayer().getField().getMonstersArea().get(monsterIndex).getName();
					Icon icon = null;
					for (int i = 0; i < GUI.getMonsterNames().length; i++) {
						if(monsterName.equals(GUI.getMonsterNames()[i])){
							icon = new ImageIcon(GUI.getMonsterPaths()[i]);
							break;
						}
					}
//					Icon icon = new ImageIcon("Card Back.png");
					Image img = ((ImageIcon) icon).getImage();
					Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
					Icon newIcon = new ImageIcon(newImage);
					gui.getCardDisplay().setIcon(newIcon);
				}else{	
					int monsterIndex = gui.getP2().getCardPanel().getM().getMonsterAreaButtons().indexOf(click);
					String monsterName = B.getActivePlayer().getField().getMonstersArea().get(monsterIndex).getName();
					Icon icon = null;
					for (int i = 0; i < GUI.getMonsterNames().length; i++) {
						if(monsterName.equals(GUI.getMonsterNames()[i])){
							icon = new ImageIcon(GUI.getMonsterPaths()[i]);
							break;
						}
					}
//					Icon icon = new ImageIcon("Card Back.png");
					Image img = ((ImageIcon) icon).getImage();
					Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
					Icon newIcon = new ImageIcon(newImage);
					gui.getCardDisplay().setIcon(newIcon);
				}
			}
			click = null;
		}
	}

}
