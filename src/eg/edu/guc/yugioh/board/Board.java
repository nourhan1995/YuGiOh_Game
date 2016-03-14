package eg.edu.guc.yugioh.board;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {

	private Player activePlayer;
	private Player opponentPlayer;
	private Player winner = null;

	public Board() {
		Card.setBoard(this);
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public Player getOpponentPlayer() {
		return opponentPlayer;
	}

	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public void whoStarts(Player p1, Player p2) {
		if(getWinner() == null){
			double n = Math.random();
			int x = (int) (n * 2) % 2;
			if (x == 0){
				setActivePlayer(p1);
				setOpponentPlayer(p2);		
			}
			else{
				setActivePlayer(p2);
				setOpponentPlayer(p1);
			}
		}

	}

	public void nextPlayer() {
		if(getWinner() == null){
			Board B = Card.getBoard();
			Player tmp = B.getActivePlayer();
			B.setActivePlayer(B.getOpponentPlayer());
			B.setOpponentPlayer(tmp);
			B.getActivePlayer().getField().addCardToHand();
		}
	}

	public void startGame(Player p1, Player p2) {
		whoStarts(p1, p2);
		getActivePlayer().getField().addNCardsToHand(5);
		getOpponentPlayer().getField().addNCardsToHand(5);
		getActivePlayer().getField().addCardToHand();
		winner = null;
	}

	public void endGame(){
		if(getWinner() != null){
			System.out.println("Game ended");
			System.out.println(getWinner().getName());
		}
	}
}
