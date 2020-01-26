import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WordGen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 757011752055909872L;
	int LblTextlength = 0;
	static JNumberTextField jt;
	static int seconds= 15;
	Timer tm;
	Timer timer;
	int counter = 0;
	JLabel titleNameLabel;
	public String[] randomwords = { "smi", "souhail", "douqchi", "taza", "informatique", "java", "interface",
			"graphique", "bonjour", "salut", "semestre", "valider" };
	String random = (randomwords[new Random().nextInt(randomwords.length)]);
	Image img = Toolkit.getDefaultToolkit().createImage("background3.jpg");

	public WordGen() {

		super();

		
		// setLayout(null);

		Font titleFont = new Font("Manoyri", Font.PLAIN, 50);
		titleNameLabel = new JLabel("Your random generated word is : ");

		titleNameLabel.setForeground(Color.orange);
		JLabel lblMsg = new JLabel("- " + random);
		JLabel count = new JLabel();
		count.setForeground(Color.red);
		count.setFont(new Font("Manoyri", Font.BOLD, 80));
		count.setBounds(210, 460, 600, 600);
		add(count);
		lblMsg.setForeground(Color.BLUE);
		lblMsg.setFont(new Font("Manoyri", Font.BOLD, 120));
		lblMsg.setBounds(50, 300, 600, 600);
		add(lblMsg);
		titleNameLabel.setFont(titleFont);
		titleNameLabel.setBounds(20, 100, 700, 700);
		add(titleNameLabel);
		setBounds(0, 0, 900, 935);
		setPreferredSize(new Dimension(900, 935));
		setPreferredSize(new Dimension(900, 935));
		setLayout(null);
		// add(pan_btn);
		String txt = lblMsg.getText();
		LblTextlength = txt.length();
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds--;
				long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);
				count.setText(second + " Seconds left");
				if (seconds == 0) {
					Frame.nv_jeu.setVisible(false);
					try {
						Frame.afficher(3);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		tm = new Timer(150, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				counter++;
				if (counter > LblTextlength) {
					lblMsg.setText("");
					counter = 0;
				} else {
					lblMsg.setText(txt.substring(0, counter));

					if (lblMsg.getForeground() == Color.blue) {
						lblMsg.setForeground(Color.red);
					} else if (lblMsg.getForeground() == Color.red) {
						lblMsg.setForeground(Color.green);
					} else if (lblMsg.getForeground() == Color.green) {
						lblMsg.setForeground(Color.orange);
					}

				}

			}
		});
		timer.start();
		tm.start();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
