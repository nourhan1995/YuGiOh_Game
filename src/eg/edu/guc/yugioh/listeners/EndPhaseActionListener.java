package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.ActionButtons;
import eg.edu.guc.yugioh.gui.GUI;

public class EndPhaseActionListener implements ActionListener {

	GUI gui;
	JButton click;

	public EndPhaseActionListener(GUI gui) {
		// TODO Auto-generated constructor stub
		super();
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Board B = Card.getBoard();
		if(click == null){
			if(e.getSource() instanceof ActionButtons){
				click = (ActionButtons) e.getSource();
				B.getActivePlayer().endPhase();
				if(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText().equals(B.getActivePlayer().getName())){
					gui.getP1().getCardPanel().getHand().setVisible(true);
					gui.getP1().getPlayerStatusPanel().getStatus().setText("Active Player");
					gui.getP1().getPlayerStatusPanel().getPhase().setText("" + B.getActivePlayer().getField().getPhase());
					gui.getP2().getCardPanel().getHand().setVisible(false);
					gui.getP2().getPlayerStatusPanel().getStatus().setText("Opponent Player");
					gui.getP2().getPlayerStatusPanel().getPhase().setText("--");
				}
				if(gui.getP2().getPlayerStatusPanel().getNameOfPlayer().getText().equals(B.getActivePlayer().getName())){
					gui.getP2().getCardPanel().getHand().setVisible(true);
					gui.getP2().getPlayerStatusPanel().getStatus().setText("Active Player");
					gui.getP2().getPlayerStatusPanel().getPhase().setText("" + B.getActivePlayer().getField().getPhase());
					gui.getP1().getCardPanel().getHand().setVisible(false);
					gui.getP1().getPlayerStatusPanel().getStatus().setText("Opponent Player");
					gui.getP1().getPlayerStatusPanel().getPhase().setText("--");
				}
			}
			click = null;
		}
	}

}
