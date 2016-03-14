package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class Player implements Duelist {

	private String name;
	private int lifePoints;
	private Field field;
	boolean f = false;
	boolean s = false;
	int x = 0;

	public Player(String name) throws IOException, UnexpectedFormatException{
		this.name = name;
		field = new Field();
		lifePoints = 8000;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	public Field getField() {
		return field;
	}

	@Override
	public boolean summonMonster(MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if(!s){
				if (Card.getBoard().getWinner() == null) {
					if (this.equals(Card.getBoard().getActivePlayer())) {
						if (Card.getBoard().getActivePlayer().getField().getPhase() != Phase.BATTLE) {
							if (Card.getBoard().getActivePlayer().getField().getHand().contains(monster)) {
								if (this.getField().getMonstersArea().size() < 5) {
									Card.getBoard().getActivePlayer().getField().addMonsterToField(monster,Mode.ATTACK, false);
									s = true;
									return true;
								}else
									throw new NoMonsterSpaceException("There isn't enough space in the field to add a monster");
							}
						}else
							throw new WrongPhaseException("You can't summon a monster in the battle phase");
					}
				}
			}else
				throw new MultipleMonsterAdditionException("Only one monster could be summoned per turn");
		}
		return false;
	}

	@Override
	public boolean summonMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getWinner() == null){
			if(!s){
				if (this.equals(Card.getBoard().getActivePlayer())) {
					if (Card.getBoard().getActivePlayer().getField().getPhase() != Phase.BATTLE) {
						if (Card.getBoard().getActivePlayer().getField().getHand().contains(monster)) {
							if (this.getField().getMonstersArea().size() < 5) {
								Card.getBoard().getActivePlayer().getField().addMonsterToField(monster,	Mode.ATTACK, sacrifices);
								s = true;
								if(monster.getLocation() == Location.FIELD)
									return true;
							}else
								throw new NoMonsterSpaceException("There isn't enough space in the field to add a monster");
						}
					}else
						throw new WrongPhaseException("You can't summon a monster in the battle phase");
				}
			}else 
				throw new MultipleMonsterAdditionException("Only one monster could be summoned per turn");
		}
		return false;
	}

	@Override
	public boolean setMonster(MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if(!s){
				if (Card.getBoard().getWinner() == null) {
					if(Card.getBoard().getActivePlayer().getField().getPhase() != Phase.BATTLE){
						if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size() <5){
							Card.getBoard().getActivePlayer().field.addMonsterToField(monster, Mode.DEFENSE, true);
							s = true;
							return true;
						}else
							throw new NoMonsterSpaceException("There isn't enough space in the field to add a monster");
					}else
						throw new WrongPhaseException("You can't set a monster in the battle phase");
				}
			}else
				throw new MultipleMonsterAdditionException("Only one monster could be set per turn");
		}
		return false;
	}

	@Override
	public boolean setMonster(MonsterCard monster,	ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getWinner() == null){
			if(!s){
				if (Card.getBoard().getWinner() == null) {
					if (Card.getBoard().getActivePlayer().field.getPhase() != Phase.BATTLE) {
						if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size() < 5){
							Card.getBoard().getActivePlayer().field.addMonsterToField(monster, Mode.DEFENSE, sacrifices);
							if(monster.getLocation() == Location.FIELD){
								s = true;
								return true;
							}
						}else
							throw new NoMonsterSpaceException("There isn't enough space in the field to add a monster");

					}else
						throw new WrongPhaseException("You can't set a monster in the battle phase");
				}
			}else
				throw new MultipleMonsterAdditionException("Only one monster could be set per turn");
		}
		return false;
	}

	@Override
	public boolean setSpell(SpellCard spell) {
		if(Card.getBoard().getWinner() == null){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(this.getField().getPhase() != Phase.BATTLE){
					if(this.getField().getSpellArea().size() < 5){
						if(spell.getLocation() == Location.HAND){
							this.getField().getSpellArea().add(spell);
							spell.setLocation(Location.FIELD);
							return true;
						}
					}else
						throw new NoSpellSpaceException("There is not enough space to add a spell in the field");
				}else
					throw new WrongPhaseException("You can't set a spell in the battle phase");
			}
		}
		return false;
	}

	@Override
	public boolean activateSpell(SpellCard spell, MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(Card.getBoard().getActivePlayer().getField().getPhase() != Phase.BATTLE ){
					if(spell.getLocation() == Location.FIELD){
						this.getField().activateSetSpell(spell, monster);
					}else{
						if(this.getField().getSpellArea().size() < 5){
							this.getField().addSpellToField(spell, monster, false);
							this.getField().activateSetSpell(spell, monster);
						}
						else
							throw new NoSpellSpaceException("There is not enough space on the field to add a spell and activate it");
					}
					return true;
				}else
					throw new WrongPhaseException("You can't activate a spell in the battle phase");
			}
		}
		return false;
	}

	@Override
	public boolean declareAttack(MonsterCard activeMonster,	MonsterCard opponentMonster) {
		Board B = Card.getBoard();
		if(B.getWinner() == null){
			if(this.equals(B.getActivePlayer())){
				if(B.getActivePlayer().getField().getPhase() == Phase.BATTLE){
					if(!B.getOpponentPlayer().getField().getMonstersArea().isEmpty()){
						if(activeMonster.getMode() == Mode.ATTACK){
							if(!activeMonster.getA()){
								activeMonster.action(opponentMonster);
								activeMonster.setA(true);
								if (B.getActivePlayer().getLifePoints() <= 0) {
									B.setWinner(B.getOpponentPlayer());
									B.endGame();
								} else {
									if (B.getOpponentPlayer().getLifePoints() <= 0) {
										B.setWinner(B.getActivePlayer());
										B.endGame();
									}
								}
								return true;
							}else 
								throw new MonsterMultipleAttackException("You can't attack with the same monster twice");
						}else
							throw new DefenseMonsterAttackException("You can't attack with a defense monster");
					}
				}else
					throw new WrongPhaseException("You can't declare attack in the " + B.getActivePlayer().getField().getPhase() + " phase.");
			}
		}
		return false;
	}

	@Override
	public boolean declareAttack(MonsterCard activeMonster) {
		Board B = Card.getBoard();
		if(B.getWinner() == null){
			if(this.equals(B.getActivePlayer())){
				if(B.getActivePlayer().getField().getPhase() == Phase.BATTLE){
					if(B.getOpponentPlayer().getField().getMonstersArea().isEmpty()){
						if(activeMonster.getMode() == Mode.ATTACK){
							if(!activeMonster.getA()){
								activeMonster.action();
								activeMonster.setA(true);
								if (B.getActivePlayer().getLifePoints() <= 0) {
									B.setWinner(B.getOpponentPlayer());
									B.endGame();
								} else {
									if (B.getOpponentPlayer().getLifePoints() <= 0) {
										B.setWinner(B.getActivePlayer());
										B.endGame();
									}
								}
								return true;
							}else
								throw new MonsterMultipleAttackException("You can't attack with the same monster twice");
						}else
							throw new DefenseMonsterAttackException("You can't attack with a defense monster");
					}
				}else
					throw new WrongPhaseException("You can't declare attack in the " + B.getActivePlayer().getField().getPhase() + " phase.");
			}
		}
		return false;
	}

	@Override
	public void addCardToHand() {
		if(Card.getBoard().getWinner() == null){
			if (this.equals(Card.getBoard().getActivePlayer())) {
				if (getField().getDeck().getDeck().size() == 0) {
					Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
					Card.getBoard().endGame();
				} else
					Card.getBoard().getActivePlayer().getField().addCardToHand();
			}
		}
	}

	@Override
	public void addNCardsToHand(int n) {
		if(Card.getBoard().getWinner() == null){
			if (this.equals(Card.getBoard().getActivePlayer())) {
				if (getField().getDeck().getDeck().size() == 0) {
					Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
					Card.getBoard().endGame();
				} else {
					if (n > getField().getDeck().getDeck().size()) {
						Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
						Card.getBoard().endGame();
					} else 
						if (getField().getDeck().getDeck().size() >= n)
							Card.getBoard().getActivePlayer().getField().addNCardsToHand(n);
				}
			}
		}
	}

	@Override
	public void endPhase() {
		if(Card.getBoard().getWinner() == null){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(getField().getPhase() == Phase.MAIN1)
					getField().setPhase(Phase.BATTLE);	
				else{
					if(getField().getPhase() == Phase.BATTLE)
						getField().setPhase(Phase.MAIN2);
					else{
						if(getField().getPhase() == Phase.MAIN2){
							endTurn();
							Card.getBoard().getActivePlayer().getField().setPhase(Phase.MAIN1);
						}
					}
				}
			}
		}
	}

	@Override
	public boolean endTurn() {
		if (Card.getBoard().getWinner() == null) {
			if (this.equals(Card.getBoard().getActivePlayer())) {
				s = false;
				Card.getBoard().nextPlayer();
				Card.getBoard().getActivePlayer().getField().setPhase(Phase.MAIN1);
				for(int i=0;Card.getBoard().getActivePlayer().getField().getMonstersArea().size()>i;i++){
					Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).setF(false);;
				}
				for(int i=0;Card.getBoard().getActivePlayer().getField().getMonstersArea().size()>i;i++){
					Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).setA(false);
				}
				return true;
			}
		} else{
			Card.getBoard().endGame();
			return false;
		}
		return false;
	}

	@Override
	public boolean switchMonsterMode(MonsterCard monster) {
		if(!monster.isF()){
			if (Card.getBoard().getWinner() == null) {
				if (this.equals(Card.getBoard().getActivePlayer())) {
					if (this.field.getPhase() != Phase.BATTLE) {
						if (this.field.getMonstersArea().contains(monster)) {
							if (monster.getMode() == Mode.ATTACK){
								monster.setMode(Mode.DEFENSE);

							}else {
								if (monster.getMode() == Mode.DEFENSE)
									monster.setMode(Mode.ATTACK);
							}
							monster.setF(true); 
							return true;
						}
					}else
						throw new WrongPhaseException("You can't switch a monster's mode in the battle phase");
				}
			}
		}
		return false;
	}


}
