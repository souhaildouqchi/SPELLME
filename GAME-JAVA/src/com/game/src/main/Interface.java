package com.game.src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	button score, nv_j, jeu, quiter;
	JLabel titleNameLabel;

	Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");

	public Interface() {
		super();

		// setLayout(null);
		Font titleFont = new Font("Manoyri", Font.PLAIN, 50);
		titleNameLabel = new JLabel("LETTERS GAME-Douqchi Souhail");
		titleNameLabel.setForeground(Color.orange);
		titleNameLabel.setFont(titleFont);
		titleNameLabel.setBounds(150, 150, 600, 600);
		add(titleNameLabel);
		setBounds(0, 0, 900, 935);
		score = new button("Score");
		score.setBounds(350, 610, 200, 50);
		nv_j = new button("New Game");
		nv_j.setBounds(350, 550, 200, 50);
		jeu = new button("Play");
		jeu.setBounds(350, 670, 200, 50);
		quiter = new button("Quit");
		quiter.setBounds(350, 730, 200, 50);
		setPreferredSize(new Dimension(900, 935));
		setPreferredSize(new Dimension(900, 935));
		add(score);
		add(nv_j);
		add(jeu);
		add(quiter);
		setLayout(null);
		// add(pan_btn);

		score.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Frame.afficher(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		nv_j.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Frame.afficher(2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		jeu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (Frame.login != null)
					try {
						Frame.afficher(3);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		quiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Frame.afficher(4);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
