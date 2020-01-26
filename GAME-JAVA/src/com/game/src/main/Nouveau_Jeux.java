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
import javax.swing.JTextField;

public class Nouveau_Jeux extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7068224109538927606L;
	public static JNumberTextField age;
	JTextField input;
	JLabel titleNameLabel;
	JLabel myage;
	JLabel myname;
	button nv_jeu, quiter, valider, jeux;
	Image img = Toolkit.getDefaultToolkit().createImage("background2.jpg");

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

	public Nouveau_Jeux() {
		super();
		setLayout(null);
		input = new JTextField();
		age = new JNumberTextField();
		input.setBounds(200, 350, 500, 30);
		age.setBounds(200, 400, 500, 30);
		nv_jeu = new button("New Game");
		nv_jeu.setBounds(30, 720, 200, 50);
		valider = new button("Random");
		valider.setBounds(240, 720, 200, 50);
		quiter = new button("Quit");
		quiter.setBounds(450, 720, 200, 50);
		jeux = new button("Play");
		jeux.setBounds(660, 720, 200, 50);
		setPreferredSize(new Dimension(900, 935));
		setPreferredSize(new Dimension(900, 935));
		add(nv_jeu);
		add(jeux);
		add(valider);
		add(quiter);
		add(input);
		add(age);
		Font titleFont = new Font("Manoyri", Font.PLAIN, 50);
		new Font("Manoyri", Font.PLAIN, 15);
		titleNameLabel = new JLabel("Enter Name and Age bellow :");
		myage = new JLabel("Age :");
		myname = new JLabel("Name :");
		myage.setFont(titleFont);
		myname.setFont(titleFont);
		myname.setForeground(Color.YELLOW);
		myage.setForeground(Color.YELLOW);
		myname.setBounds(50, 60, 600, 600);
		myage.setBounds(50, 115, 600, 600);
		add(myage);
		add(myname);
		titleNameLabel.setForeground(Color.yellow);
		titleNameLabel.setFont(titleFont);
		titleNameLabel.setBounds(150, 0, 600, 600);
		add(titleNameLabel);
		// add(button_mod);

		// *******************************//

		Frame.jeure[Frame.nb_j] = new Joueur(Frame.nb_j);
		valider.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (input.getText().toString().compareTo("") != 0)
					Frame.jeure[Frame.nb_j].setNom(input.getText().toString());
				Frame.login = Frame.jeure[Frame.nb_j];
				Frame.nb_j++;
				Frame.nv_jeu.setVisible(false);
				try {
					Frame.afficher(1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jeux.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				Frame.nv_jeu.setVisible(false);
				Frame.i = 0;
				try {
					Frame.afficher(6);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		nv_jeu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Frame.nv_jeu.setVisible(false);
				try {
					Frame.afficher(2);
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

}
