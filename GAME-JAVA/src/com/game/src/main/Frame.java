package com.game.src.main;

import java.awt.Container;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	// *********************************************************************//
	public static Interface interface1;
	public static GameFrame gf;
	public static Score score;
	JFrame frame;
	public static WordGen wordg;
	public static Nouveau_Jeux nv_jeu;
	public static Joueur[] jeure = new Joueur[10];
	public static Joueur login;
	public static int nb_j;
	public static int i = 0;
	public static Container countn;
	static DataOutputStream sortie;
	DataInputStream entree;
	private Scanner sc;

	// ******************************************************************//

	public Frame() throws IOException {

		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();

		this.setTitle("LETTERS GAME");
		this.setSize(900, 935);
		this.setResizable(false);
		nb_j = 0;
		countn = getContentPane();
		interface1 = new Interface();
		countn.add(interface1);
		// ***************************************************************************//

		try {
			entree = new DataInputStream(new FileInputStream("score.txt"));
			sc = new Scanner(entree);
			int tmp = 0;
			if (sc.hasNextInt())
				tmp = sc.nextInt();

			while (tmp > 0) {
				String s = sc.next();
				Frame.jeure[nb_j] = new Joueur(s);
				int n = 0;
				n = sc.nextInt();
				jeure[nb_j].setMax_score(n);
				nb_j++;
				tmp--;
			}
			if (jeure != null)
				login = jeure[0];
			try {

				entree.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sortie = new DataOutputStream(new FileOutputStream("score.txt", true));
		} catch (FileNotFoundException e) {
			sortie = new DataOutputStream(new FileOutputStream("score.txt", true));
		}
	}

	public static void log(String a) {
		for (int i = 0; i < nb_j; i++)
			if (jeure[i].getNom().compareTo(a) == 0)
				login = jeure[i];

	}

	public void af() {
		System.out.println(1);
	}

	// **************************************************************************************************//
	public static void afficher(int x) throws IOException {
		if (x == 4) {
			int p = JOptionPane.showConfirmDialog(Test.a, "Want to leave :( ?");
			try {
				sortie.flush();
				sortie.writeBytes(nb_j + " ");
				for (int i = 0; i < nb_j; i++) {
					sortie.writeBytes(jeure[i].getNom() + " " + jeure[i].getMax_score() + " ");
				}
				sortie.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
			if (p == 0)
				System.exit(0);

		} else {
			interface1.setVisible(false);
			switch (x) {
			case 5:
				interface1.setVisible(true);
				break;
			case 2:
				nv_jeu = new Nouveau_Jeux();
				Test.a.add(nv_jeu);
				nv_jeu.setVisible(true);
				break;
			case 1:
				interface1.setVisible(false);
				score = new Score(null);
				Test.a.add(score);
				break;
			case 3:
				Test.a.setVisible(false);
				AudioPlayer.getSound("count").stop();
				AudioPlayer.getMusic("music").stop();
				AudioPlayer.getMusic("musicplay").loop();
				gf = new GameFrame();
				gf.setVisible(true);
				break;
			case 6 : 
				AudioPlayer.getMusic("music").stop();
	        	AudioPlayer.getSound("count").loop();
				wordg = new WordGen();
				Test.a.add(wordg);
				wordg.setVisible(true);
			}
		}
	}
	// ***********************************************************************************************************//

}
