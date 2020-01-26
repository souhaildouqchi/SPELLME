package com.game.src.main;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class GradePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7605638897273140022L;

	public GradePanel() {
		setBackground(Color.yellow);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		removeAll();
		int width = getWidth(), length = getHeight();
		StringBuffer sb = new StringBuffer(GamePanel.score + "");
		JLabel l = new JLabel(new String(sb), SwingConstants.CENTER);
		l.setBounds(0, 0, width, length);
		l.setFont(new Font("Jokerman", Font.BOLD, 30));
		l.setForeground(new Color(17, 33, 49));
		add(l);
	}

}
