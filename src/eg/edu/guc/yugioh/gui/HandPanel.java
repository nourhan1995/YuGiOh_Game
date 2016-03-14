package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class HandPanel extends JPanel{
	
	public JScrollBar getScrollBar() {
		return scrollBar;
	}

	public void setScrollBar(JScrollBar scrollBar) {
		this.scrollBar = scrollBar;
	}

	public HandButtonsPanel getHandButtonsPanel() {
		return handButtonsPanel;
	}

	public void setHandButtonsPanel(HandButtonsPanel handButtonsPanel) {
		this.handButtonsPanel = handButtonsPanel;
	}

	private JScrollBar scrollBar;
	private HandButtonsPanel handButtonsPanel;
	
	public HandPanel(){
		super();
//		this.setSize(250, 150);
//		this.setLayout(new GridLayout(2, 1));
		this.setLayout(new FlowLayout());
		scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
//		scrollBar.setMaximum(150);
//		scrollBar.setMinimum(20);
		handButtonsPanel = new HandButtonsPanel();
		this.add(handButtonsPanel);
//		this.add(scrollBar);
	}
	
}
