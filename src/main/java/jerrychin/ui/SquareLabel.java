package jerrychin.ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jerrychin.model.Player;

@SuppressWarnings("serial")
public class SquareLabel extends JLabel {
	private Player player;
	//private static final Border border = BorderFactory.createDashedBorder(Color.gray, 3, 3);
	private final int id;
	
	SquareLabel(int id) {
		this.id = id;
		//setBorder(border);
	}

	public void setImageIcon(ImageIcon imageIcon) {
		setIcon(imageIcon);
	}

	public int getId() {
		return id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}


