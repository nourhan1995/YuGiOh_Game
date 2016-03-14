package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.xml.stream.FactoryConfigurationError;

import eg.edu.guc.yugioh.listeners.ActivateSpellActionListener;
import eg.edu.guc.yugioh.listeners.EndPhaseActionListener;
import eg.edu.guc.yugioh.listeners.EndTurnActionListener;
import eg.edu.guc.yugioh.listeners.HandCardsActionListener;
import eg.edu.guc.yugioh.listeners.MonsterAreaActionListener;
import eg.edu.guc.yugioh.listeners.SetMonsterListener;
import eg.edu.guc.yugioh.listeners.SetSpellActionListener;
import eg.edu.guc.yugioh.listeners.SummonActionListener;

public class GUI extends JFrame{
	
	private PlayerPanel p1;
	private PlayerPanel p2;
	private InstructionPanel instructionPanel;
	private CardDisplayLabel cardDisplay;
	public CardDisplayLabel getCardDisplay() {
		return cardDisplay;
	}

	public void setCardDisplay(CardDisplayLabel cardDisplay) {
		this.cardDisplay = cardDisplay;
	}

	private static String [] spellPaths;
	private static String [] spellNames;
	private static String [] monsterPaths;
	private static String[] monsterNames;
	
	public GUI() throws IOException{
		super();
//		setSize(2000,1000);
		this.pack();
		this.setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		spellPaths = new String [10];
		spellNames = new String [10];
		monsterNames = new String [30];
		monsterPaths = new String [30];
		createArrayOfMonsters();
		createArrayOfSpells();
		p1 = new PlayerPanel();
		p2 = new PlayerPanel();
		instructionPanel = new InstructionPanel();
		cardDisplay = new CardDisplayLabel();
		instructionPanel.getEndTurn().addActionListener(new EndTurnActionListener(this));
		instructionPanel.getEndPhase().addActionListener(new EndPhaseActionListener(this));
		instructionPanel.getSummonMonster().addActionListener(new SummonActionListener(this));
		instructionPanel.getSetMonster().addActionListener(new SetMonsterListener(this));
		instructionPanel.getActivateSpell().addActionListener(new ActivateSpellActionListener(this));
		for (int i = 0; i < monsterNames.length; i++) {
			System.out.println(monsterNames[i] +" " + monsterPaths[i]);
		}
		for (int i = 0; i < p1.getCardPanel().getM().getMonsterAreaButtons().size(); i++) {
			p1.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new SummonActionListener(this));
			p1.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new MonsterAreaActionListener(this));
			p1.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new ActivateSpellActionListener(this));
		}
		for (int i = 0; i < p2.getCardPanel().getM().getMonsterAreaButtons().size(); i++) {
			p2.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new SummonActionListener(this));
			p2.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new MonsterAreaActionListener(this));
			p2.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new ActivateSpellActionListener(this));
		}
		for (int i = 0; i < p1.getCardPanel().getHand().getHandButtonsPanel().getHand().size(); i++) {
			p1.getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).addActionListener(new SummonActionListener(this));
			p1.getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).addActionListener(new HandCardsActionListener(this));
			p1.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new ActivateSpellActionListener(this));
			p1.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new SetSpellActionListener(this));
		}
		for (int i = 0; i < p2.getCardPanel().getHand().getHandButtonsPanel().getHand().size(); i++) {
			p2.getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).addActionListener(new SummonActionListener(this));
			p2.getCardPanel().getHand().getHandButtonsPanel().getHand().get(i).addActionListener(new HandCardsActionListener(this));
			p2.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new ActivateSpellActionListener(this));
			p2.getCardPanel().getM().getMonsterAreaButtons().get(i).addActionListener(new SetSpellActionListener(this));
		}
		Icon icon = new ImageIcon("Card Back.png");
		Image img = ((ImageIcon) icon).getImage();
		Image newImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		Icon newIcon = new ImageIcon(newImage);
		cardDisplay.setIcon(newIcon);
		this.add(p1);
		this.add(p2);
		this.add(instructionPanel);
		this.add(cardDisplay);
		p1.setBounds(450, 20, 900, 350);
		p2.setBounds(450, 370, 900, 350);
		instructionPanel.setBounds(30, 20, 400, 300);
		cardDisplay.setBounds(10, 350, 200, 300);
		this.validate();
		this.repaint();
	}
	
	public static void main(String[] args) throws IOException {
		GUI g = new GUI();
	}
	
	public static void createArrayOfSpells() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("Database-Spells.csv"));
		for (int i = 0; i < spellNames.length; i++) {
			String [] cur = (br.readLine()).split(",");
			spellNames[i] = cur[1];
			switch(i){
			case 0:	spellPaths [i] = "Spells/Card Destruction.png";break;
			case 1:	spellPaths [i] = "Spells/Change Of Heart.png";break;
			case 2:	spellPaths [i] = "Spells/Dark Hole.png";break;
			case 3:	spellPaths [i] = "Spells/Graceful Dice.png";break;
			case 4:	spellPaths [i] = "Spells/Harpie's Feather Duster.png";break;
			case 5:	spellPaths [i] = "Spells/Heavy Storm.png";break;
			case 6:	spellPaths [i] = "Spells/Mage Power.png";break;
			case 7:	spellPaths [i] = "Spells/Monster Reborn.png";break;
			case 8:	spellPaths [i] = "Spells/Pot of Greed.png";break;
			case 9:	spellPaths [i] = "Spells/Raigeki.png";break;
			
			}
		}
	}
	public static void createArrayOfMonsters() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("Database-Monsters.csv"));
		for (int i = 0; i < monsterNames.length; i++) {
			String [] cur = (br.readLine()).split(",");
			monsterNames[i] = cur[1];
			switch(i){
			case 0:	monsterPaths [i] = "Monsters/Alexandrite Dragon.png";break;
			case 1:	monsterPaths [i] = "Monsters/Alligator Sword.png";break;
			case 2:	monsterPaths [i] = "Monsters/Alpha The Magnet Warrior.png";break;
			case 3:	monsterPaths [i] = "Monsters/Baby Dragon.png";break;
			case 4:	monsterPaths [i] = "Monsters/Beta The Magnet Warrior.png";break;
			case 5:	monsterPaths [i] = "Monsters/Big Shield Gardna.png";break;
			case 6:	monsterPaths [i] = "Monsters/Blue-Eyes White Dragon.png";break;
			case 7:	monsterPaths [i] = "Monsters/Celtic Guardian.png";break;
			case 8:	monsterPaths [i] = "Monsters/Clown Zombie.png";break;
			case 9:	monsterPaths [i] = "Monsters/Cosmo Queen.png";break;
			case 10:monsterPaths [i] = "Monsters/Curse Of Dragon.png";break;
			case 11:monsterPaths [i] = "Monsters/Cyber Jar.png";break;
			case 12:monsterPaths [i] = "Monsters/Dark Magician Girl.png";break;
			case 13:monsterPaths [i] = "Monsters/Dark Magician.png";break;
			case 14:monsterPaths [i] = "Monsters/Fence Guard.png";break;
			case 15:monsterPaths [i] = "Monsters/Fence Guard Apprentice.png";break;
			case 16:monsterPaths [i] = "Monsters/Fence Guard Dragon.png";break;
			case 17:monsterPaths [i] = "Monsters/Fence Guard Magician.png";break;
			case 18:monsterPaths [i] = "Monsters/Gaia The Fierce Knight.png";break;
			case 19:monsterPaths [i] = "Monsters/Gamma The Magnet Warrior.png";break;
			case 20:monsterPaths [i] = "Monsters/Gemini Elf.png";break;
			case 21:monsterPaths [i] = "Monsters/Harpie Lady.png";break;
			case 22:monsterPaths [i] = "Monsters/Kuriboh.png";break;
			case 23:monsterPaths [i] = "Monsters/Man-Eater Bug.png";break;
			case 24:monsterPaths [i] = "Monsters/Mokey Mokey.png";break;
			case 25:monsterPaths [i] = "Monsters/Red-Eyes Black Dragon.png";break;
			case 26:monsterPaths [i] = "Monsters/Summoned Skull.png";break;
			case 27:monsterPaths [i] = "Monsters/Time Wizard.png";break;
			case 28:monsterPaths [i] = "Monsters/Vorse Raider.png";break;
			case 29:monsterPaths [i] = "Monsters/Witty Phantom.png";break;
			
			}
		}
	}

	public PlayerPanel getP1() {
		return p1;
	}

	public void setP1(PlayerPanel p1) {
		this.p1 = p1;
	}

	public PlayerPanel getP2() {
		return p2;
	}

	public void setP2(PlayerPanel p2) {
		this.p2 = p2;
	}

	public InstructionPanel getInstructionPanel() {
		return instructionPanel;
	}

	public void setInstructionPanel(InstructionPanel instructionPanel) {
		this.instructionPanel = instructionPanel;
	}

	public static String[] getSpellPaths() {
		return spellPaths;
	}

	public static void setSpellPaths(String[] spellPaths) {
		GUI.spellPaths = spellPaths;
	}

	public static String[] getSpellNames() {
		return spellNames;
	}

	public static void setSpellNames(String[] spellNames) {
		GUI.spellNames = spellNames;
	}

	public static String[] getMonsterPaths() {
		return monsterPaths;
	}

	public static void setMonsterPaths(String[] monsterPaths) {
		GUI.monsterPaths = monsterPaths;
	}

	public static String[] getMonsterNames() {
		return monsterNames;
	}

	public static void setMonsterNames(String[] monsterNames) {
		GUI.monsterNames = monsterNames;
	}
}
