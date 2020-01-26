import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;

public class textsc extends Button {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9160295329857947800L;

	public textsc(Color color, String text, int size) {
		super(text);
		setForeground(color);
		Font police = new Font("Arial", Font.BOLD, size);
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
