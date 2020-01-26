import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;

public class WordPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8329712166424618577L;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();

	public WordPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		JLabel label, label1;
		Image image, image1;
		ImageIcon icon, icon1;
		int wrong_time = GameFrame.gp.wrong_time;
		boolean empty = GameFrame.gp.empty, isFirst = GameFrame.gp.isFirst, change = GameFrame.gp.word_change,
				correct = GameFrame.gp.correct, wrong = GameFrame.gp.wrong;
		String s;
		if ((!change) && (!isFirst))
			return;
		removeAll();
		if (correct) {
			char ch = GameFrame.gp.correct_char.charAt(0);
			s = String.format("/word/%s.jpg", ch);
			image1 = new ImageIcon(WordPanel.class.getResource(s)).getImage();
			label1 = new JLabel();
			icon1 = new ImageIcon(image1);
			icon1.setImage(image1.getScaledInstance(45, 45, Image.SCALE_FAST));
			label1.setIcon(icon1);
			label1.setText(null);
			label1.setSize(45, 45);
			labels.add(label1);
			image = new ImageIcon(WordPanel.class.getResource("/word/correct.png")).getImage();
			label = new JLabel();
			icon = new ImageIcon(image);
			icon.setImage(image.getScaledInstance(45, 45, Image.SCALE_FAST));
			label.setIcon(icon);
			label.setText(null);
			label.setSize(45, 45);
			labels.add(label);
		} else if ((wrong) && (wrong_time == 1)) {
			if (GameFrame.gp.wrong_empty)
				labels.remove(0);
			image = new ImageIcon(WordPanel.class.getResource("/word/wrong.png")).getImage();
			label = new JLabel();
			icon = new ImageIcon(image);
			icon.setImage(image.getScaledInstance(45, 45, Image.SCALE_FAST));
			label.setIcon(icon);
			label.setText(null);
			label.setSize(45, 45);
			labels.add(label);
		} else if (empty || (isFirst)) {
			labels.clear();
			image = new ImageIcon(WordPanel.class.getResource("/word/ques.jpg")).getImage();
			label = new JLabel();
			icon = new ImageIcon(image);
			icon.setImage(image.getScaledInstance(45, 45, Image.SCALE_FAST));
			label.setIcon(icon);
			label.setText(null);
			label.setSize(45, 45);
			label.setLocation(0, 0);
			labels.add(label);
		} else {
			if (GameFrame.gp.current_word.length() == 1) {
				if (labels.size() == 1)
					labels.remove(0);
				else
					labels.clear();
			}
			char ch = GameFrame.gp.current_char.charAt(0);
			s = String.format("/word/%s.jpg", ch);
			image = new ImageIcon(WordPanel.class.getResource(s)).getImage();
			label = new JLabel();
			icon = new ImageIcon(image);
			icon.setImage(image.getScaledInstance(45, 45, Image.SCALE_FAST));
			label.setIcon(icon);
			label.setText(null);
			label.setSize(45, 45);
			labels.add(label);
		}
		for (int i = 0; i < labels.size(); i++) {
			label = labels.get(i);
			label.setLocation(i * 45, 0);
			add(label);
		}
	}
}