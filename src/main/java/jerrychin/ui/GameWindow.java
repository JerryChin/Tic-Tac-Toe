package jerrychin.ui;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jerrychin.model.TicTacToeBoard;
import jerrychin.resource.ResourceFactoryProducer;

//import static com.mycompany.app.util.SwingConsole.*;
/**
 * Hello world!
 *
 */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	List<SquareLabel> labelList = new ArrayList<SquareLabel>();
	MouseListener mouseListener;

	/**
	 * @return the mouseListener
	 */
	public MouseListener getMouseListener() {
		return mouseListener;
	}

	/**
	 * @param mouseListener the mouseListener to set
	 */
	public void setMouseListener(MouseListener mouseListener) {
		System.out.println("in Game Window before: " + this.mouseListener);
		this.mouseListener = mouseListener;
		System.out.println("in Game Window after: " + this.mouseListener);
	}

	public GameWindow(MouseListener mouseListener) {
		setLayout(new BorderLayout());
		
		JLabel bgLabel = new JLabel((ImageIcon)ResourceFactoryProducer.
				getResourceFactory("image").getResource().getElement("chessboard"));
		//JLabel statLabel = new JLabel((ImageIcon)ResourceFactoryProducer.
			//	getResourceFactory("image").getResource().getElement("stat"));
		bgLabel.setLayout(null);
		SquareLabel label;
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(3, 3));
		panel.setBounds(24, 20, 400, 402);
		
		for(int i = 0; i < TicTacToeBoard.TOTAL_SQUARE; i++) {
			label = SquareLabelFactory.getSquareLabel(i);
			label.addMouseListener(mouseListener);
			labelList.add(label);
			panel.add(label, i);
		}
		
		bgLabel.add(panel);
	    add(bgLabel, BorderLayout.CENTER);
	  //  add(statLabel, BorderLayout.WEST);
		this.mouseListener = mouseListener;
		
		// not resizable
		setResizable(false);


	}
	
	public synchronized void addMouseListenerToLabel(MouseListener listner, int index) {
		labelList.get(index).addMouseListener(listner);
	}
	
	public synchronized void removeMouseListenerFromLabel(MouseListener listner, int index) {
		labelList.get(index).removeMouseListener(listner);
	}
	
	public synchronized void addIconToLabel(ImageIcon imageIcon, int index) {
		labelList.get(index).setIcon(imageIcon);
	}
	
	public synchronized void removeIconFromLabel(int index) {
		labelList.get(index).setIcon(null);
	}
	
	public synchronized void dispatchEvent(int index, AWTEvent e) {
		e.setSource(labelList.get(index));
		labelList.get(index).dispatchEvent(e);
	}
	
	public synchronized void cleanWidnow() {
		for(int i = 0; i < TicTacToeBoard.TOTAL_SQUARE; i++) {
			removeIconFromLabel(i);
			addMouseListenerToLabel(getMouseListener(), i);
			labelList.get(i).setPlayer(null);
		}
	}
}