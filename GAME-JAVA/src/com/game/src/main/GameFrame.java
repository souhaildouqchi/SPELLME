package com.game.src.main;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 7936880446670322049L;
	public static GameFrame gf;
	public JFrame frame;
	public static GamePanel gp;
	public RepaintThread repaint;
	public static Player player;
	public static GradePanel grade;
	public WordPanel wp;
	public static TimePanel tp;
	public static JPanel big, top;
	public static boolean pause = false;
	public static Timer timer;

	public GameFrame() {
		pause = false;
		frame = new JFrame();
		setTitle("LETTERS GAME-DOUQCHI SOUHAIL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		setResizable(false);
		setSize(900, 935);
		container.setSize(900, 900);
		gp = new GamePanel();
		grade = new GradePanel();
		wp = new WordPanel();
		tp = new TimePanel();
		big = new JPanel();
		top = new JPanel();
		big.setBounds(0, 0, 900, 900);
		big.setBackground(Color.YELLOW);
		big.setLayout(null);
	    top.setBackground(Color.YELLOW);
	    setBackground(new Color(17,33,49));
		top.setLayout(null);
		wp.setSize(630, 45);
		grade.setSize(135, 45);
		gp.setSize(900, 855);
		gp.setBackground(new Color(17,33,49));
		top.setSize(900, 45);
		top.setBounds(0, 0, 900, 45);
		top.add(wp);
		top.add(tp.panel);
		top.add(grade);
		wp.setLocation(0, 0);
		tp.panel.setLocation(630, 0);
		grade.setLocation(765, 0);
		gp.setFocusable(true);
		gp.setLocation(0, 45);
		top.setLocation(0, 0);
		big.add(gp);
		big.add(top);
		container.add(big);
		timer = new Timer();
		timer.schedule(tp, 0, 1000);
		player = new Player(container.getWidth() / 2 - 150 / 2, container.getHeight() - 180);
		repaint = new RepaintThread();
		repaint.start();
	}
}