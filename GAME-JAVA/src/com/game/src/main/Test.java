package com.game.src.main;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Test {

	static Frame a;

	public static void main(String[] args) throws IOException {
		 try {
			    // body of main method goes here, including any other error handling
			  } catch (Throwable t) {
			    JOptionPane.showMessageDialog(
			        null, t.getClass().getSimpleName() + ": " + t.getMessage());
			    throw t; // don't suppress Throwable
			  }
		a = new Frame();
		a.setVisible(true);

		a.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(-1);

			}

		});

	}

}
