
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.*;

public class text extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2466542187592054238L;

	public text(Color color, String text, int size) {
		super(text);
		setForeground(color);
		Font police = new Font("Jokerman", Font.BOLD, size);
		this.setFont(police);
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setForeground(Color.white);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setForeground(color);
			}
		});
	}

	public text(Color color, String text, int x, int y, int size) {
		super(text);
		setForeground(color);
		this.setPreferredSize(new Dimension(x, y));
		Font police = new Font("Manoyri", Font.BOLD, size);
		this.setFont(police);
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setForeground(Color.white);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				setForeground(color);
			}
		});
	}

}
