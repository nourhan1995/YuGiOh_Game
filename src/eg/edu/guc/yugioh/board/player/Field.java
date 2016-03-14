package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class Field {

	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private Deck deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;

	public Field() throws IOException, UnexpectedFormatException {
		phase = Phase.MAIN1;
		monstersArea = new ArrayList<MonsterCard>();
		spellArea = new ArrayList<SpellCard>();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		deck = new Deck();
//		Scanner sc = new Scanner(System.in);
//		try{
//			System.out.println("pls build deck");
//			deck = new Deck();
//		}catch(Exception e){
//			System.out.println("Please enter a correct path: ");
//			if(deck.getMonsters().isEmpty()){
//				deck.setMonstersPath(sc.nextLine());
//				try{
//					deck = new Deck();
//				}catch(Exception e1){
//					System.out.println("The file was not found.");
//					System.out.println("Please enter a correct path: ");
//					deck.setMonstersPath(sc.nextLine());
//					try{
//						deck = new Deck();
//					}catch(Exception e2){
//						System.out.println("The file was not found.");
//						System.out.println("Please enter a correct path: ");
//						deck.setMonstersPath(sc.nextLine());
//						try{
//							deck = new Deck();
//						}catch(Exception e3){
//							e3.printStackTrace();
//						}
//					}
//				}
//			}
//			if(deck.getSpells().isEmpty()){
//				deck.setSpellsPath(sc.nextLine());
//				try{
//					deck = new Deck();
//				}catch(Exception e1){
//					System.out.println("The file was not found.");
//					System.out.println("Please enter a correct path: ");
//					deck.setSpellsPath(sc.nextLine());
//					try{
//						deck = new Deck();
//					}catch(Exception e2){
//						System.out.println("The file was not found.");
//						System.out.println("Please enter a correct path: ");
//						deck.setSpellsPath(sc.nextLine());
//						try{
//							deck = new Deck();
//						}catch(Exception e3){
//							e3.printStackTrace();
//						}
//					}
//				}
//			}
//		}
	}
	public void addMonsterToField(MonsterCard monster, Mode mode, boolean isHidden) {
		if (monstersArea.size() < 5) {
			monster.setMode(mode);
			monster.setLocation(Location.FIELD);
			monster.setHidden(isHidden);
			monstersArea.add(monster);
		}
	}

	public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices) {
		if (monstersArea.size() < 5) {
			if (monster.getLevel() >= 1 && monster.getLevel() <= 4 && sacrifices.size() == 0) {
				monster.setMode(mode);
				monster.setLocation(Location.FIELD);
				monstersArea.add(monster);
			}
			if (monster.getLevel() >= 5 && monster.getLevel() <= 6 && sacrifices.size() == 1) {
				monster.setMode(mode);
				monster.setLocation(Location.FIELD);
				Card c = monstersArea.remove(0);
				c.setLocation(Location.GRAVEYARD);
				graveyard.add(c);
				monstersArea.add(monster);
			}
			if (monster.getLevel() >= 7 && monster.getLevel() <= 8 && sacrifices.size() == 2) {
				monster.setMode(mode);
				monster.setLocation(Location.FIELD);
				Card c1 = monstersArea.remove(0);
				Card c2 = monstersArea.remove(0);
				c1.setLocation(Location.GRAVEYARD);
				c2.setLocation(Location.GRAVEYARD);
				graveyard.add(c1);
				graveyard.add(c2);
				monstersArea.add(monster);
			}
		}
	}

	public void removeMonsterToGraveyard(MonsterCard mons) {
		if(mons.getLocation() == Location.FIELD){
			mons.setLocation(Location.GRAVEYARD);
			graveyard.add(mons);
			monstersArea.remove(mons);
		}
	}

	public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters) {
		while (!monsters.isEmpty()) {
			removeMonsterToGraveyard(monsters.remove(0));
		}
	}

	public void addSpellToField(SpellCard action, MonsterCard monster,	boolean hidden) {
		if(action.getLocation() == Location.HAND){
			if (spellArea.size() < 5) {
				action.setLocation(Location.FIELD);
				spellArea.add(action);
				hand.remove(action);
				action.setHidden(hidden);
				//				if (!action.isHidden()) {
				//					action.action(monster);
				//					action.setLocation(Location.GRAVEYARD);
				//					removeSpellToGraveyard(action);
				//				}
			}else
				throw new NoSpellSpaceException("There isn't enough space in the field to add a spell");
		}
	}

	public void activateSetSpell(SpellCard action, MonsterCard monster) {
		if (action.getLocation() == Location.FIELD) {
			action.setHidden(false);
			action.action(monster);
			removeSpellToGraveyard(action);
		}

	}

	public void removeSpellToGraveyard(SpellCard Spell) {
		if(Spell.getLocation() == Location.FIELD){
			Spell.setLocation(Location.GRAVEYARD);
			graveyard.add(Spell);
			spellArea.remove(Spell);
		}
	}

	public void removeSpellToGraveyard(ArrayList<SpellCard> spell) {
		int i = 0;
		while (!spell.isEmpty()) {
			removeSpellToGraveyard(spell.remove(i));
		}
	}

	public void removeHandToGraveyard(ArrayList<Card> hand) {
		while (!hand.isEmpty()) {
			Card c = hand.remove(0);
			c.setLocation(Location.GRAVEYARD);
			graveyard.add(c);
		}
	}

	public void addCardToHand() {
		Card x = deck.drawOneCard();
		x.setLocation(Location.HAND);
		hand.add(x);

	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}

	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}

	public Deck getDeck() {
		return deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public void addNCardsToHand(int n) {
		ArrayList<Card> x = deck.drawNCards(n);
		if(x != null){
			while (!x.isEmpty()) {
				Card c = x.remove(0);
				c.setLocation(Location.HAND);
				hand.add(c);
			}
		}else{
			Card.getBoard().endGame();
		}
	}

}
