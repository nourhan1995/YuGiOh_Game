package eg.edu.guc.yugioh.board.player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

public class Deck {

	private static ArrayList<Card> monsters = new ArrayList<Card>();;
	private static ArrayList<Card> spells = new ArrayList<Card>();
	private ArrayList<Card> deck;
	private BufferedReader br;
	private static String monstersPath = "Database-Monsters.csv";
	private static String spellsPath = "Database-Spells.csv";
	private boolean flagSpells = false;
	private boolean flagMonsters = false;

	public boolean isFlagSpells() {
		return flagSpells;
	}

	public void setFlagSpells(boolean flagSpells) {
		this.flagSpells = flagSpells;
	}

	public boolean isFlagMonsters() {
		return flagMonsters;
	}

	public void setFlagMonsters(boolean flagMonsters) {
		this.flagMonsters = flagMonsters;
	}

	public Deck() throws IOException, UnexpectedFormatException{
		deck = new ArrayList<Card>();
		spellsPath = getSpellsPath();
		monstersPath = getMonstersPath();
		Scanner sc = new Scanner(System.in);
		if(!flagSpells){
			try{
				Deck.spells = loadCardsFromFile(getSpellsPath());
				flagSpells = true;
			}catch(Exception e){
				System.out.println("Please enter a correct path: ");
				try{
					setSpellsPath(sc.nextLine());
					Deck.spells = loadCardsFromFile(getSpellsPath());
					flagSpells = true;
				}catch(Exception e1){
					System.out.println("The file was not found.");
					System.out.println("Please enter a correct path: ");
					try{
						setSpellsPath(sc.nextLine());
						Deck.spells = loadCardsFromFile(getSpellsPath());
						flagSpells = true;
					}catch(Exception e2){
						System.out.println("The file was not found.");
						System.out.println("Please enter a correct path: ");
						setSpellsPath(sc.nextLine());
//						try{
							Deck.spells = loadCardsFromFile(getSpellsPath());
							flagSpells = true;
//						}catch(Exception e3){
//							e3.printStackTrace();
//							throw e3;
//						}
					}
				}
			}
		}
		if (!flagMonsters){
			try{
				Deck.monsters = loadCardsFromFile(getMonstersPath());
				flagMonsters = true;
			}catch(Exception e){
				System.out.println("Please enter a correct path: ");
				try{
					setMonstersPath(sc.nextLine());
					Deck.monsters = loadCardsFromFile(getMonstersPath());
					flagMonsters = true;
				}catch(Exception e1){
					System.out.println("The file was not found.");
					System.out.println("Please enter a correct path: ");
					try{
						setMonstersPath(sc.nextLine());
						Deck.monsters = loadCardsFromFile(getMonstersPath());
						flagMonsters = true;
					}catch(Exception e2){
						System.out.println("The file was not found.");
						System.out.println("Please enter a correct path: ");
						setMonstersPath(sc.nextLine());
//						try{
							Deck.monsters = loadCardsFromFile(getMonstersPath());
							flagMonsters = true;
//						}catch(Exception e3){
//							e3.printStackTrace();
//							throw e3;
//						}
					}
				}
			}
		}
		buildDeck(Deck.monsters, Deck.spells);
		shuffleDeck();
	}

	public ArrayList<Card> loadCardsFromFile(String path) throws IOException, FileNotFoundException,MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException {

		ArrayList<Card> a = new ArrayList<Card>();
		String curLine = "";
		FileReader fileReader = new FileReader(path);
		br = new BufferedReader(fileReader);
		int line = 0;
		//		try{
		while ((curLine = br.readLine()) != null) {
			line++;
			// Parsing the currentLine String
			String[] s = curLine.split(",");
			// System.out.println(Arrays.toString(s));
			if (s[0].equals("Spell")) {
				if(s.length != 3)
					throw new MissingFieldException(path, line);
				else{
					if(s[0].equals(" ") || s[0].equals(""))
						throw new EmptyFieldException(path, line, 1);
					else{
						if(s[1].equals(" ") || s[1].equals(""))
							throw new EmptyFieldException(path, line, 2);
						else{
							if(s[2].equals(" ") || s[2].equals(""))
								throw new EmptyFieldException(path, line, 3);
							else{
								switch (s[1]) {
								case "Card Destruction":
									a.add(new CardDestruction(s[1], s[2]));
									break;
								case "Change Of Heart":
									a.add(new ChangeOfHeart(s[1], s[2]));
									break;
								case "Dark Hole":
									a.add(new DarkHole(s[1], s[2]));
									break;
								case "Graceful Dice":
									a.add(new GracefulDice(s[1], s[2]));
									break;
								case "Harpie's Feather Duster":
									a.add(new HarpieFeatherDuster(s[1], s[2]));
									break;
								case "Heavy Storm":
									a.add(new HeavyStorm(s[1], s[2]));
									break;
								case "Mage Power":
									a.add(new MagePower(s[1], s[2]));
									break;
								case "Monster Reborn":
									a.add(new MonsterReborn(s[1], s[2]));
									break;
								case "Pot of Greed":
									a.add(new PotOfGreed(s[1], s[2]));
									break;
								case "Raigeki":
									a.add(new Raigeki(s[1], s[2]));
									break;
//								case " ":
//									throw new EmptyFieldException(path, line, 2);
								default : throw new UnknownSpellCardException(path, line, s[1]);
								}	
							}
						}
					}
				}

			} else {
				if (s[0].equals("Monster")){
					if(s.length != 6)
						throw new MissingFieldException(path, line);
					else{
						if(s[1].equals(" ")|| s[1].equals(""))
							throw new EmptyFieldException(path, line, 2);
						else{
							if(s[2].equals(" ")|| s[2].equals(""))
								throw new EmptyFieldException(path, line, 3);
							else{
								if(s[3].equals(" ")|| s[3].equals(""))
									throw new EmptyFieldException(path, line, 4);
								else{
									if(s[4].equals(" ")|| s[4].equals(""))
										throw new EmptyFieldException(path, line, 5);
									else{
										if(s[5].equals(" ")|| s[5].equals(""))
											throw new EmptyFieldException(path, line, 6);
										else
											a.add(new MonsterCard(s[1], s[2], Integer.parseInt(s[5]), Integer.parseInt(s[3]), Integer.parseInt(s[4])));

									}
								}
							}
						}
					}
				}else
					throw new UnknownCardTypeException(path, line, s[0]);
			}
		}
		//		}catch(UnknownCardTypeException u){
		//			u.getMessage();
		//		}catch (UnknownSpellCardException e) {
		//			e.getMessage();
		//			// TODO: handle exception
		//		}catch (EmptyFieldException e) {
		//			e.getMessage();
		//			// TODO: handle exception
		//		}catch (MissingFieldException e) {
		//			e.getMessage();
		//			// TODO: handle exception
		//		}

		return a;
	}

	public static ArrayList<Card> getMonsters() {
		return monsters;
	}

	public static void setMonsters(ArrayList<Card> monsters) {
		Deck.monsters = monsters;
	}

	public static ArrayList<Card> getSpells() {
		return spells;
	}

	public static void setSpells(ArrayList<Card> spells) {
		Deck.spells = spells;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public static String getMonstersPath() {
		return monstersPath;
	}

	public static void setMonstersPath(String monstersPath) {
		Deck.monstersPath = monstersPath;
	}

	public static String getSpellsPath() {
		return spellsPath;
	}

	public static void setSpellsPath(String spellsPath) {
		Deck.spellsPath = spellsPath;
	}

	private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) {
		//		System.out.println(spells.size());

		ArrayList<Card> m = new ArrayList<Card>();
		ArrayList<Card> s = new ArrayList<Card>();
		for (int i = 0; i < monsters.size(); i++) {
			MonsterCard tmp = new MonsterCard(monsters.get(i).getName(), monsters.get(i).getDescription(),  ((MonsterCard) monsters.get(i)).getLevel(), ((MonsterCard) monsters.get(i)).getAttackPoints(), ((MonsterCard) monsters.get(i)).getDefensePoints());
			m.add(tmp);
		}
		for (int i = 0; i < spells.size(); i++) {
			switch(spells.get(i).getName()){
			case "Card Destruction":
				s.add(new CardDestruction(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Change Of Heart":
				s.add(new ChangeOfHeart(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Dark Hole":
				s.add(new DarkHole(spells.get(i).getName(), spells.get(i).getDescription()));
				break;	
			case "Graceful Dice":
				s.add(new GracefulDice(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Harpie's Feather Duster":
				s.add(new HarpieFeatherDuster(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Heavy Storm":
				s.add(new HeavyStorm(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Mage Power":
				s.add(new MagePower(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Monster Reborn":
				s.add(new MonsterReborn(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Pot of Greed":
				s.add(new PotOfGreed(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			case "Raigeki":
				s.add(new Raigeki(spells.get(i).getName(), spells.get(i).getDescription()));
				break;
			}
			//			System.out.println(s.get(i).getName());
		}
		//		System.out.println(s.size());
		for (int i = 0; i < 15; i++) {
			int x = (int) (m.size() * Math.random());
			Card c = m.get(x);
			c.setLocation(Location.DECK);
			deck.add(c);
			//			System.out.println(c.getName());
		}
		//		System.out.println(s.size());
		for (int i = 0; i < 5; i++) {
			//			System.out.println(s.size());
			int x = (int) (s.size()* Math.random());
			//			System.out.println(x);
			Card c = s.get(x);
			c.setLocation(Location.DECK);
			this.deck.add(c);
			//			System.out.println(c.getLocation());
		}

	}

	//	private void buildDeck(ArrayList<Card> Monsters, ArrayList<Card> Spells) {
	//
	//		int monstersQouta = 15;
	//		int spellsQouta = 5;
	//
	//		Random r = new Random();
	//
	//		for (; monstersQouta > 0; monstersQouta--) {
	//
	//			int randomIndex = r.nextInt(monsters.size());
	//			MonsterCard monster = (MonsterCard) monsters.get(randomIndex);
	//
	//			MonsterCard clone = new MonsterCard(monster.getName(),
	//					monster.getDescription(), monster.getLevel(),
	//					monster.getAttackPoints(), monster.getDefensePoints());
	//			clone.setMode(monster.getMode());
	//			clone.setHidden(monster.isHidden());
	//			clone.setLocation(Location.DECK);
	//			deck.add(clone);
	//
	//		}
	//
	//		for (; spellsQouta > 0; spellsQouta--) {
	//
	//			int randomIndex = r.nextInt(spells.size());
	//			SpellCard spell = (SpellCard) spells.get(randomIndex);
	//
	//			SpellCard clone = new SpellCard(spell.getName(),spell.getDescription());
	//			clone.setHidden(spell.isHidden());
	//			clone.setLocation(Location.DECK);
	//			deck.add(clone);
	//		}
	//	}


	public void shuffleDeck() {

		Collections.shuffle(deck);
	}

	public ArrayList<Card> drawNCards(int n) {
		if(!deck.isEmpty() && deck.size() >= n){
			ArrayList<Card> tmp = new ArrayList<Card>();
			Card c = null;
			for (int i = 0; i < n; i++) {
				c = deck.remove(0);
				c.setLocation(Location.DECK);
				tmp.add(c);
			}
			return tmp;
		}else{
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			Card.getBoard().endGame();
			return null;
		}
	}

	public Card drawOneCard() {
		if(!deck.isEmpty()){
			Card c = deck.remove(0);
			return c;
		}else{
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			Card.getBoard().endGame();
			return null;
		}
	}

}
