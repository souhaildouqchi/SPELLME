package com.game.src.main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Score extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7173614860719984578L;

	button nv_j, quiter;

	ArrayList<JLabel> text;
	JPanel score_per;

	Image img = Toolkit.getDefaultToolkit().createImage("background4.jpg");
	static ArrayList<String> score;
	JLabel titleNameLabel;

	private String ch;

	public Score(ArrayList<String> score) throws IOException {
		super();
		Font titleFont = new Font("Manoyri", Font.PLAIN, 50);
		titleNameLabel = new JLabel("Score bord :");
		titleNameLabel.setForeground(Color.orange);
		titleNameLabel.setFont(titleFont);
		titleNameLabel.setBounds(300, 40, 600, 600);
		add(titleNameLabel);
		setBounds(0, 0, 900, 935);
		nv_j = new button("New Game");
		nv_j.setBounds(200, 730, 200, 50);
		quiter = new button("Quit");
		quiter.setBounds(470, 730, 200, 50);
		setPreferredSize(new Dimension(900, 935));
		setPreferredSize(new Dimension(900, 935));
		add(nv_j);
		add(quiter);
		setLayout(null);

		score_per = new JPanel();
		text = new ArrayList<JLabel>();
		Score.score = score = new ArrayList<String>();
		String nomfich;
		String ligne;

		nomfich = "Score.txt";
		BufferedReader entree = new BufferedReader(new FileReader(nomfich));
		do {
			ligne = entree.readLine();
			if (ligne != null) {

				Score.score.add(ligne);
			}
		} while (ligne != null);
		entree.close();

		score_per.setPreferredSize(new Dimension(300, 400));
		score_per.setBackground(new Color(17, 33, 49));
		for (int i = 0; i < score.size(); i++) {

			text.add(new JLabel(score.get(i)));
			text.get(i).setPreferredSize(new Dimension(300, 40));
			DecorationText(text.get(i), Color.red, 20);
			score_per.add(text.get(i));
		}
		score_per.setBounds(140, 380, 600, 600);
		add(score_per);
		nv_j.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Frame.afficher(6);
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

	static void DecorationText(JLabel j, Color color, int size) {

		j.setForeground(color);
		Font police = new Font("Jokerman", Font.BOLD, 30);
		j.setFont(police);
		j.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				j.setForeground(Color.orange);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				j.setForeground(color);
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}
}
