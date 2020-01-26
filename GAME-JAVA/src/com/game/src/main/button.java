package com.game.src.main;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.*;

public class button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4350515154102459963L;

	public button(String nom) {
		super(nom);
		this.setBorder(BorderFactory.createLineBorder(Color.white));
		this.setFont(new Font("Manoyri", Font.PLAIN, 40));
		this.setBackground(new Color(255, 255, 255));
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setBackground(new Color(92, 92, 92));
				setForeground(Color.yellow);
				AudioPlayer.getSound("menu_sound").play();
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setBackground(new Color(255, 255, 255));
				setForeground(Color.black);
			}
		});

	}

}
