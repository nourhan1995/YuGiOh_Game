package eg.edu.guc.yugioh.listeners;

import java.io.IOException;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.gui.StartWindow;
import eg.edu.guc.yugioh.listeners.StartController;

public class Main {

	StartController s;

	public Main() throws IOException, UnexpectedFormatException{
		Board B = new Board();
		StartWindow start = new StartWindow();
		s = new StartController(start);
		new EndTurnActionListener(s.gui);
		new EndPhaseActionListener(s.gui);
		new SummonActionListener(s.gui);
		new MonsterAreaActionListener(s.gui);
		new HandCardsActionListener(s.gui);
		new SetMonsterListener(s.gui);
		new ActivateSpellActionListener(s.gui);
		new SetSpellActionListener(s.gui);
		new DeclareAttackOnLifePointsListener(s.gui);
	}

	public static void main(String[] args) throws IOException, UnexpectedFormatException {
		Main m = new Main();
	}


}
