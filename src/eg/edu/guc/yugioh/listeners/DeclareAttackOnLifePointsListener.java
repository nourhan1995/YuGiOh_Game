package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.MonsterCardButton;

public class DeclareAttackOnLifePointsListener implements ActionListener {

	GUI gui;
	JButton click;

	public DeclareAttackOnLifePointsListener(GUI gui) {
		// TODO Auto-generated constructor stub
		super();
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Board B = Card.getBoard();
		try{
		if(B.getActivePlayer().getField().getMonstersArea().isEmpty()){
			if(click == null){
				if(e.getSource() instanceof MonsterCardButton){
					click = (MonsterCardButton) e.getSource();
					if(B.getActivePlayer().getName().equals(gui.getP1().getPlayerStatusPanel().getNameOfPlayer().getText())){
						int Index = gui.getP1().getCardPanel().getM().getMonsterAreaButtons().indexOf(click);
						MonsterCard m = B.getActivePlayer().getField().getMonstersArea().get(Index);
						B.getActivePlayer().declareAttack(m);
						for (int i = 0; i < gui.getP1().getCardPanel().getM().getMonsterAreaButtons().size(); i++) {
							gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("");
							if(B.getActivePlayer().getField().getMonstersArea().get(i) != null)
								gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName());
						}
						for (int i = 0; i < gui.getP2().getCardPanel().getM().getMonsterAreaButtons().size(); i++) {
							gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("");
							if(B.getOpponentPlayer().getField().getMonstersArea().get(i) != null)
								gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getOpponentPlayer().getField().getMonstersArea().get(i).getName());
						}
						gui.getP1().getDeckAndGraveYardPanel().getGraveYard().setText(B.getActivePlayer().getField().getGraveyard().get(B.getActivePlayer().getField().getGraveyard().size() - 1).getName());
						gui.getP2().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());
					}else{
						int Index = gui.getP2().getCardPanel().getM().getMonsterAreaButtons().indexOf(click);
						MonsterCard m = B.getActivePlayer().getField().getMonstersArea().get(Index);
						B.getActivePlayer().declareAttack(m);
						for (int i = 0; i < gui.getP1().getCardPanel().getM().getMonsterAreaButtons().size(); i++) {
							gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("");
							if(B.getActivePlayer().getField().getMonstersArea().get(i) != null)
								gui.getP1().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getOpponentPlayer().getField().getMonstersArea().get(i).getName());
						}
						for (int i = 0; i < gui.getP2().getCardPanel().getM().getMonsterAreaButtons().size(); i++) {
							gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText("");
							if(B.getActivePlayer().getField().getMonstersArea().get(i) != null)
								gui.getP2().getCardPanel().getM().getMonsterAreaButtons().get(i).setText(B.getActivePlayer().getField().getMonstersArea().get(i).getName());
						}
						gui.getP1().getDeckAndGraveYardPanel().getGraveYard().setText(B.getActivePlayer().getField().getGraveyard().get(B.getActivePlayer().getField().getGraveyard().size() - 1).getName());
						gui.getP2().getDeckAndGraveYardPanel().getGraveYard().setText(B.getOpponentPlayer().getField().getGraveyard().get(B.getOpponentPlayer().getField().getGraveyard().size() - 1).getName());

					}
				}
			}
		}else
			throw new Exception();
		}catch(Exception e1 ){
			JOptionPane.showMessageDialog(null,"You can not attack life points when there are monsters in the fiels");
		}
	}


}
