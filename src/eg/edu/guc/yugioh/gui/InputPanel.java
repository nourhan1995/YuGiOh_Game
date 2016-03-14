package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel{
	
	private JTextField textField1;
	private JTextField textField2;
//	private JButton start;
	
	public InputPanel(){
		super();
		setVisible(true);
		setLayout(new GridLayout(2, 2));
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.start = new JButton("Start");
		this.textField1 = new JTextField(15);
		this.textField2 = new JTextField(15);
		add(new JLabel("Player1"));
		add(new JLabel("Player2"));
		add(textField1);
		add(textField2);
//		add(start);
//		this.validate();
	}
	
	public void setJT1(JTextField jT1) {
		textField1 = jT1;
	}

	public void setJT2(JTextField jT2) {
		textField2 = jT2;
	}

	public JTextField getJT1() {
		return textField1;
	}

	public JTextField getJT2() {
		return textField2;
	}

//	public static void main(String[] args) {
//		StartWindow s = new StartWindow();
//	}

}
