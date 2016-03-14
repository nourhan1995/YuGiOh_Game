package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import eg.edu.guc.yugioh.listeners.SummonActionListener;

public class MonstersAndSpellsPanel extends JPanel{
	
	private ArrayList<MonsterCardButton> monsterAreaButtons;
	private ArrayList<SpellCardButton> spellAreaButtons;
//	private ArrayList<CardButton> handButtons;
	
	public MonstersAndSpellsPanel(){
		super();
		monsterAreaButtons = new ArrayList<MonsterCardButton>();
		spellAreaButtons = new ArrayList<SpellCardButton>();
//		handButtons = new ArrayList<CardButton>();
		this.setPreferredSize(new Dimension(600, 150));
		this.setVisible(true);
		this.setLayout(new GridLayout(2,5));
		for (int i = 0; i < 5; i++) {
			MonsterCardButton m = new MonsterCardButton();
			monsterAreaButtons.add(m);
			this.add(m);
		}
		for (int i = 0; i < 5; i++) {
			SpellCardButton s = new SpellCardButton();
			spellAreaButtons.add(s);
			this.add(s);
		}
		
	}

	public ArrayList<MonsterCardButton> getMonsterAreaButtons() {
		return monsterAreaButtons;
	}

	public ArrayList<SpellCardButton> getSpellAreaButtons() {
		return spellAreaButtons;
	}

	public void setMonsterAreaButtons(ArrayList<MonsterCardButton> monsterAreaButtons) {
		this.monsterAreaButtons = monsterAreaButtons;
	}

	public void setSpellAreaButtons(ArrayList<SpellCardButton> spellAreaButtons) {
		this.spellAreaButtons = spellAreaButtons;
	}
	
}
