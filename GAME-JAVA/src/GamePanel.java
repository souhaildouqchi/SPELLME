import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 6456376535791098786L;
	private JButton menuButton;
	public ArrayList<Target> targets = new ArrayList<Target>();
	public ArrayList<String> words = new ArrayList<String>();
	public String current_word = "";
	public String current_char = "", correct_char = "";
	public boolean word_change = false, isFirst = true, empty = true, fire = false, correct = false, wrong = false,
			wrong_empty = false;
	public int target_get = 0, target_loss = 0, counter = 0, wrong_time = 0, counter1 = 0;
	public static long score = 0;
	public double correctness;
	private Trie trie;
	private String nextWords;
	private Timer timer;
	private Map<String, String> pressedKeys = new HashMap<String, String>();

	public void createTarget() {
		int w = getWidth();
		int ww = GameFrame.player.width;
		int www = w - ww - 15;
		if (isFirst || word_change)
			nextWords = trie.possibleNext();
		int select = 0;
		RepaintThread.target_counter++;
		int TargetNum;
		HashSet<Integer> tg = new HashSet<Integer>();
		if (RepaintThread.target_counter >= 60) {
			if ((int) (Math.random() * 7) == 1)
				TargetNum = 2;
			else
				TargetNum = 1;
			int x = ((int) (Math.random() * w)) % www + ww / 2;
			boolean flag1 = false;
			while (TargetNum > 0) {
				flag1 = false;
				x = ((int) (Math.random() * w)) % www + ww / 2;
				if (!tg.contains(new Integer(x))) {
					for (Integer x1 : tg) {
						if (((int) Math.abs(x1.intValue() - x)) < 40) {
							flag1 = true;
							break;
						}
					}
					if (!flag1) {
						TargetNum--;
						tg.add(new Integer(x));
					}
				}
			}
			for (Integer x1 : tg) {
				if (((int) (Math.random() * 10)) <= 4) {
					if (nextWords.length() == 1)
						select = 0;
					else
						select = (int) (Math.random() * nextWords.length());
					targets.add(new Target(x1, -60, nextWords.charAt(select)));
				} else
					targets.add(new Target(x1, -60, (char) (((int) (Math.random() * 26)) + 97)));
			}
			RepaintThread.target_counter = 0;
			tg.clear();
		}
	}
	
	public void targetDrop(Graphics g) {
		Target t2;
		String s;
		for (Target t : targets) {
			s = String.format("/image/%s.png", t.ch);
			Image image = new ImageIcon(GamePanel.class.getResource(s)).getImage();
			g.drawImage(image, t.x, t.y, 55, 55, this);
		
			t.y += 3;
		}
		for (int i = 0; i < targets.size(); i++) {
			t2 = targets.get(i);
			if (t2.y >= getHeight()) {
				t2.alive = false;
				targets.remove(t2);
				i = 0;
			}
		}
	}
	
	 
	
	public void paintComponent(Graphics g) {
		Target t2;
		Player p;
		int pp;
		if (correct || wrong) {
			if (counter1 > 50) {
				word_change = true;
				correct = false;
				wrong = false;
				wrong_empty = false;
				counter1 = 0;
				correct_char = "";
				if (wrong_time > 0)
					wrong_time = 0;
			} else {
				counter1++;
				word_change = false;
			}
		} else
			word_change = false;
		super.paintComponent(g);
		if (counter < 1)
			counter++;
		else
			isFirst = false;

		p = GameFrame.player;
		if (targets.size() > 0) {
			for (int i = 0; i < targets.size(); i++) {
				t2 = targets.get(i);
				if (p.eat(t2)) {
					String s = String.valueOf(t2.ch);
					pp = trie.searching(s);
					if (pp == 1) {
						score += current_word.length() * 5;
						correct_char = String.valueOf(t2.ch);
						current_word = "";
						current_char = "";
						word_change = true;
						correct = true;
						wrong = false;
						empty = true;
					} else if (pp == 0) {
						score += 5;
						current_word += t2.ch;
						current_char = String.valueOf(t2.ch);
						word_change = true;
						empty = false;
						correct = false;
						wrong = false;
					} else {
						if (score > 5 * current_word.length())
							score -= 5 * current_word.length();
						else
							score = 0;
						if (current_word.equals(""))
							wrong_empty = true;
						current_word = "";
						current_char = "";
						word_change = true;
						empty = true;
						correct = false;
						wrong = true;
						wrong_time++;
					}
					t2.alive = false;
					targets.remove(t2);
					break;
				}
			}
		}

		createTarget();
		targetDrop(g);
		
		// draw player
		Image image = new ImageIcon(GamePanel.class.getResource("/image/basket.png")).getImage();
		g.drawImage(image, p.x, p.y, 150, 120, this);

	}

	private class AnimationAction extends AbstractAction implements ActionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1492176969883181346L;
		private String key_code;
		private boolean pressed;

		public AnimationAction(String kc, boolean p) {
			key_code = kc;
			pressed = p;
		}

		public void actionPerformed(ActionEvent e) {
			handleKeyEvent(key_code, pressed);
		}
	}

	private void handleKeyEvent(String key_code, boolean pressed) {
		if (pressed)
			pressedKeys.put(key_code, key_code);
		else {
			if (key_code.equals("SPACE"))
				fire = false;
			pressedKeys.remove(key_code);
		}
		if (pressedKeys.size() == 1) {
			timer.start();
		}
		if (pressedKeys.size() == 0) {
			timer.stop();
		}
	}

	public void removekeys() {
		if (pressedKeys.size() > 0)
			pressedKeys.clear();
	}

	public void actionPerformed(ActionEvent e) {
		for (String s : pressedKeys.values()) {

			if (s.equals("LEFT")) {
				if (GameFrame.player.x >= GameFrame.player.speed)
					GameFrame.player.x -= GameFrame.player.speed;
			} else if (s.equals("RIGHT")) {
				if (GameFrame.player.x + GameFrame.player.width <= getWidth() - GameFrame.player.speed)
					GameFrame.player.x += GameFrame.player.speed;
			}

		}
		//removekeys();
	}

	public GamePanel() {
		trie = new Trie();
		words.add("smi");
		words.add("souhail");
		words.add("douqchi");
		words.add("taza");
		words.add("informatique");
		words.add("java");
		words.add("interface");
		words.add("graphique");
		words.add("bonjour");
		words.add("salut");
		words.add("semestre");
		words.add("valider");
		for (String w : words)
			trie.insert(w.toLowerCase());
		setBackground(new Color(17,33,49));
		setFocusable(true);
		timer = new Timer(10, this);
		timer.setInitialDelay(0);
		InputMap im = this.getInputMap();
		ActionMap am = this.getActionMap();
		Action PressedLeftAction = new AnimationAction("LEFT", true);
		Action ReleasedLeftAction = new AnimationAction("LEFT", false);
		Action PressedRightAction = new AnimationAction("RIGHT", true);
		Action ReleasedRightAction = new AnimationAction("RIGHT", false);
		im.put(KeyStroke.getKeyStroke("pressed LEFT"), "LEFT");
		im.put(KeyStroke.getKeyStroke("pressed RIGHT"), "RIGHT");
		im.put(KeyStroke.getKeyStroke("released LEFT"), "released LEFT");
		im.put(KeyStroke.getKeyStroke("released RIGHT"), "released RIGHT");
		am.put("LEFT", PressedLeftAction);
		am.put("RIGHT", PressedRightAction);
		am.put("released LEFT", ReleasedLeftAction);
		am.put("released RIGHT", ReleasedRightAction);

	}

	public void setMainMenuButtonListener(ActionListener listener) {
		menuButton.addActionListener(listener);
	}
}
