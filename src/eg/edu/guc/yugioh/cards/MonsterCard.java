package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.Board;

public class MonsterCard extends Card {

	private int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode = Mode.DEFENSE;
	private boolean a = false;
	private boolean f=false;

	public MonsterCard(String name, String description, int level, int attackPoints, int defensePoints){
		super(name, description);
		this.level = level;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		if(!f){
			this.defensePoints = defensePoints;
			f=true;
		}
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public boolean isF() {
		return f;
	}

	public void setF(boolean f) {
		this.f = f;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getLevel() {
		return level;
	}

	@Override
	public void action(MonsterCard opponentMonster) {
		Board B = Card.getBoard();
		if(this != opponentMonster){
			if(!a){
				if(opponentMonster.getMode() == Mode.ATTACK){
					if(this.getAttackPoints() > opponentMonster.getAttackPoints()){
						B.getOpponentPlayer().setLifePoints(B.getOpponentPlayer().getLifePoints() - (this.getAttackPoints() - opponentMonster.getAttackPoints()));
						B.getOpponentPlayer().getField().removeMonsterToGraveyard(opponentMonster);
					}else{
						if(this.getAttackPoints() == opponentMonster.getAttackPoints()){
							B.getActivePlayer().getField().removeMonsterToGraveyard(this);
							B.getOpponentPlayer().getField().removeMonsterToGraveyard(opponentMonster);
						}else{
							B.getActivePlayer().setLifePoints(B.getActivePlayer().getLifePoints() - (opponentMonster.getAttackPoints() - this.getAttackPoints()));
							B.getActivePlayer().getField().removeMonsterToGraveyard(this);
						}
					}
				}else{
					if(this.getAttackPoints() > opponentMonster.getDefensePoints()){
						B.getOpponentPlayer().getField().removeMonsterToGraveyard(opponentMonster);
					}else{
						if(this.getAttackPoints() < opponentMonster.getDefensePoints()){
							B.getActivePlayer().setLifePoints(B.getActivePlayer().getLifePoints() - (opponentMonster.getDefensePoints() - this.getAttackPoints()));
						}
					}
				}
				a = true;
				if (B.getActivePlayer().getLifePoints() <= 0) {
					B.setWinner(B.getOpponentPlayer());
					B.endGame();
				} else {
					if (B.getOpponentPlayer().getLifePoints() <= 0) {
						B.setWinner(B.getActivePlayer());
						B.endGame();
					}
				}
			}
		}
	}

	public void action(){
		if(!a){
			Board B = Card.getBoard();
			if(B.getOpponentPlayer().getField().getMonstersArea().size() == 0){
				B.getOpponentPlayer().setLifePoints(B.getOpponentPlayer().getLifePoints() - this.getAttackPoints());
				a = true;
				if (B.getActivePlayer().getLifePoints() == 0) {
					B.setWinner(B.getOpponentPlayer());
					B.endGame();
				} else {
					if (B.getOpponentPlayer().getLifePoints() == 0) {
						B.setWinner(B.getActivePlayer());
						B.endGame();
					}
				}
			}
		}
	}

	public boolean getA(){
		return a;
	}

	public void setA(boolean a ){
		this.a = a;
	}



}
