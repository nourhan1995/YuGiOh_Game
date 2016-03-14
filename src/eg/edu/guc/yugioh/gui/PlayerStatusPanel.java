package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerStatusPanel extends JPanel{
	
	private JLabel nameTitle;
	private JLabel nameOfPlayer;
	private JLabel statusTitle;
	private JLabel status;
	private JLabel lifePointsTitle;
	private JLabel lifePoints;
	private JLabel phaseTitle;
	private JLabel phase;
	
	public PlayerStatusPanel(){
		super();
		this.setSize(new Dimension(200, 300));
		nameTitle = new JLabel("To be  added");
		nameOfPlayer = new JLabel("To be added");
		statusTitle = new JLabel("Status: ");
		status = new JLabel("To be added");
		lifePointsTitle = new JLabel("Life Points: ");
		lifePoints = new JLabel("To be added");
		phaseTitle = new JLabel("Current Phase: ");
		phase = new JLabel("To be added");
		this.setLayout(new GridLayout(8, 1));
		this.add(nameTitle);
		this.add(nameOfPlayer);
		this.add(statusTitle);
		this.add(status);
		this.add(lifePointsTitle);
		this.add(lifePoints);
		this.add(phaseTitle);
		this.add(phase);
	}

	public JLabel getNameTitle() {
		return nameTitle;
	}

	public void setNameTitle(JLabel nameTitle) {
		this.nameTitle = nameTitle;
	}

	public JLabel getNameOfPlayer() {
		return nameOfPlayer;
	}

	public void setNameOfPlayer(JLabel nameOfPlayer) {
		this.nameOfPlayer = nameOfPlayer;
	}

	public JLabel getStatusTitle() {
		return statusTitle;
	}

	public void setStatusTitle(JLabel statusTitle) {
		this.statusTitle = statusTitle;
	}

	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}

	public JLabel getLifePointsTitle() {
		return lifePointsTitle;
	}

	public void setLifePointsTitle(JLabel lifePointsTitle) {
		this.lifePointsTitle = lifePointsTitle;
	}

	public JLabel getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(JLabel lifePoints) {
		this.lifePoints = lifePoints;
	}

	public JLabel getPhaseTitle() {
		return phaseTitle;
	}

	public void setPhaseTitle(JLabel phaseTitle) {
		this.phaseTitle = phaseTitle;
	}

	public JLabel getPhase() {
		return phase;
	}

	public void setPhase(JLabel phase) {
		this.phase = phase;
	}
	
}
