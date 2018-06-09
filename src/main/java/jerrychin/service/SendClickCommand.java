package jerrychin.service;

import java.awt.event.MouseEvent;
import jerrychin.ui.GameWindow;

public class SendClickCommand implements Command{
	private int id;
	private GameWindow window;
	public SendClickCommand(GameWindow window, int id) {
		this.window = window;
		this.id = id;
	}
	
	@Override
	public void run() {
		// computer place piece
		window.dispatchEvent(id, new MouseEvent(window, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis() + 1000,
				MouseEvent.BUTTON1,
				1, 1,
				0,
				false));
	}
	
	

}
