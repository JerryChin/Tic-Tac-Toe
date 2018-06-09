package jerrychin.service;

import javax.swing.ImageIcon;
import jerrychin.resource.ResourceFactoryProducer;
import jerrychin.ui.GameWindow;

public class UpdateSquareLabelIconCommand implements Command {
	private String piece;
	private int id;
	private GameWindow window;
	
	public UpdateSquareLabelIconCommand(GameWindow window, int id, String piece) {
		this.piece = piece;
		this.window = window;
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		window.addIconToLabel((ImageIcon)ResourceFactoryProducer.
				getResourceFactory("image").getResource().getElement(piece), id);
	}

}
