package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InstructionPanel extends JPanel{
	
	private ActionButtons endTurn;
	private ActionButtons endPhase;
	private ActionButtons summonMonster;
	private ActionButtons setMonster;
	private ActionButtons setSpell;
	private ActionButtons activateSpell;
	private ActionButtons switchMonster;
	private ActionButtons declareAttackWith;
	private ActionButtons declareAttackWithout;
	
	public InstructionPanel(){
		super();
		endTurn = new ActionButtons("End Turn");
		endPhase = new ActionButtons("End Phase");
		summonMonster = new ActionButtons("Summon");
		setMonster = new ActionButtons("Set Monster");
		setSpell = new ActionButtons("Set Spell");
		activateSpell = new ActionButtons("Activte Spell");
		switchMonster = new ActionButtons("Switch Monster");
		declareAttackWith = new ActionButtons("Attack Monsters");
		declareAttackWithout = new ActionButtons("Attack LifePoints");
		this.setSize(400, 1000);
		this.setLayout(new GridLayout(3, 3));
		this.add(endTurn);
		this.add(endPhase);
		this.add(summonMonster);
		this.add(setMonster);
		this.add(setSpell);
		this.add(activateSpell);
		this.add(switchMonster);
		this.add(declareAttackWith);
		this.add(declareAttackWithout);
	}

	public JButton getEndTurn() {
		return endTurn;
	}

	public void setEndTurn(ActionButtons endTurn) {
		this.endTurn = endTurn;
	}

	public JButton getEndPhase() {
		return endPhase;
	}

	public void setEndPhase(ActionButtons endPhase) {
		this.endPhase = endPhase;
	}

	public JButton getSummonMonster() {
		return summonMonster;
	}

	public void setSummonMonster(ActionButtons summonMonster) {
		this.summonMonster = summonMonster;
	}

	public JButton getSetMonster() {
		return setMonster;
	}

	public void setSetMonster(ActionButtons setMonster) {
		this.setMonster = setMonster;
	}

	public JButton getSetSpell() {
		return setSpell;
	}

	public void setSetSpell(ActionButtons setSpell) {
		this.setSpell = setSpell;
	}

	public JButton getActivateSpell() {
		return activateSpell;
	}

	public void setActivateSpell(ActionButtons activateSpell) {
		this.activateSpell = activateSpell;
	}

	public JButton getSwitchMonster() {
		return switchMonster;
	}

	public void setSwitchMonster(ActionButtons switchMonster) {
		this.switchMonster = switchMonster;
	}

	public JButton getDeclareAttackWith() {
		return declareAttackWith;
	}

	public void setDeclareAttackWith(ActionButtons declareAttackWith) {
		this.declareAttackWith = declareAttackWith;
	}

	public JButton getDeclareAttackWithout() {
		return declareAttackWithout;
	}

	public void setDeclareAttackWithout(ActionButtons declareAttackWithout) {
		this.declareAttackWithout = declareAttackWithout;
	}

}
