package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.gui.CardButton;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.StartWindow;

public class StartController implements ActionListener{

	StartWindow s;
	private Player p1;
	private Player p2;
	GUI gui;

	public StartController(StartWindow s) {
		// TODO Auto-generated constructor stub
		super();
		this.s = s;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		s.setVisible(false);
		try {
			p1 = new Player(s.getField1().getText());
			p2 = new Player(s.getField2().getText());
			Board B = new Board();
			B.startGame(p1, p2);
			gui = new GUI();
			gui.getP1().getPlayerStatusPanel().getNameTitle().setText("Player 1: ");
			gui.getP2().getPlayerStatusPanel().getNameTitle().setText("Player 2: ");
			if(p1.getName().equals(B.getActivePlayer().getName())){
				gui.getP1().getPlayerStatusPanel().getNameOfPlayer().setText(p1.getName());
				gui.getP1().getPlayerStatusPanel().getStatus().setText("Active Player");
				gui.getP1().getPlayerStatusPanel().getLifePoints().setText("" + p1.getLifePoints());
				gui.getP1().getPlayerStatusPanel().getPhase().setText("" + p1.getField().getPhase());
				gui.getP1().getDeckAndGraveYardPanel().getDeck().setText("Deck \n" +  p1.getField().getDeck().getDeck().size());
				if(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != p1.getField().getHand().size()){
					while(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != p1.getField().getHand().size()){
						CardButton c = new CardButton();
						gui.getP1().getCardPanel().getHand().add(c);
						gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().add(c);
					}
				}
				for (int i = 0; i < p1.getField().getHand().size(); i++) {
					gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(p1.getField().getHand().get(i).getName());
				}
				gui.getP2().getPlayerStatusPanel().getNameOfPlayer().setText(p2.getName());
				gui.getP2().getPlayerStatusPanel().getStatus().setText("Opponent Player");
				gui.getP2().getPlayerStatusPanel().getLifePoints().setText("" + p2.getLifePoints());
				gui.getP2().getPlayerStatusPanel().getPhase().setText("--");
				gui.getP2().getDeckAndGraveYardPanel().getDeck().setText("Deck \n" +  p2.getField().getDeck().getDeck().size());
				gui.getP2().getCardPanel().getHand().setVisible(false);
				for (int i = 0; i < p2.getField().getHand().size(); i++) {
					gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(p2.getField().getHand().get(i).getName());
				}
			}else{
				gui.getP1().getPlayerStatusPanel().getNameOfPlayer().setText(p2.getName());
				gui.getP1().getPlayerStatusPanel().getStatus().setText("Active Player");
				gui.getP1().getPlayerStatusPanel().getLifePoints().setText("" + p2.getLifePoints());
				gui.getP1().getPlayerStatusPanel().getPhase().setText("" + p2.getField().getPhase());
				gui.getP1().getDeckAndGraveYardPanel().getDeck().setText("Deck \n" +  p2.getField().getDeck().getDeck().size());
				if(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != p2.getField().getHand().size()){
					while(gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().size() != p2.getField().getHand().size()){
						CardButton c = new CardButton();
						gui.getP1().getCardPanel().getHand().add(c);
						gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().add(c);					}
				}
				for (int i = 0; i < p2.getField().getHand().size(); i++) {
					gui.getP1().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(p2.getField().getHand().get(i).getName());
				}
				gui.getP2().getPlayerStatusPanel().getNameOfPlayer().setText(p1.getName());
				gui.getP2().getPlayerStatusPanel().getStatus().setText("Opponent Player");
				gui.getP2().getPlayerStatusPanel().getLifePoints().setText("" + p1.getLifePoints());
				gui.getP2().getPlayerStatusPanel().getPhase().setText("--");
				gui.getP2().getDeckAndGraveYardPanel().getDeck().setText("Deck \n" +  p1.getField().getDeck().getDeck().size());
				gui.getP2().getCardPanel().getHand().setVisible(false);
				for (int i = 0; i < p1.getField().getHand().size(); i++) {
					gui.getP2().getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).setText(p1.getField().getHand().get(i).getName());
				}
			}
		} catch (IOException | UnexpectedFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}

	public StartWindow getS() {
		return s;
	}

	public void setS(StartWindow s) {
		this.s = s;
	}

}
