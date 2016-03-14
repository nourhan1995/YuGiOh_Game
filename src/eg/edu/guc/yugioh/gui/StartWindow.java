package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.listeners.StartController;

public class StartWindow extends JFrame{
	
	private JTextField field1;
	private JTextField field2;
	private JLabel label1;
	private JLabel label2;
	private JButton start;
	
	public StartWindow(){
		super();
		setSize(400, 500);
		this.setLayout(null);
		start = new JButton("Start");
		field1 = new JTextField();
		field2 = new JTextField();
		label1 = new JLabel("Player1");
		label2 = new JLabel("Player2");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(label1);
		this.add(field1);
		this.add(label2);
		this.add(field2);
		this.add(start);
		label1.setBounds(180, 40, 200, 20);
		field1.setBounds(100, 100, 200, 20);
		label2.setBounds(180, 160, 200, 20);
		field2.setBounds(100, 220, 200, 20);
		start.setBounds(100, 280, 200, 20);
		start.addActionListener(new StartController(this));
		this.validate();
	}
	
	public JTextField getField1() {
		return field1;
	}

	public void setField1(JTextField field1) {
		this.field1 = field1;
	}

	public JTextField getField2() {
		return field2;
	}

	public void setField2(JTextField field2) {
		this.field2 = field2;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public static void main(String[] args) {
		StartWindow s = new StartWindow();
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

}
