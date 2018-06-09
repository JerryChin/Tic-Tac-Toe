package jerrychin.service;

import java.awt.Component;

import javax.swing.JOptionPane;

public class DeclareResultCommand implements Command{
	Component component;
	String message;
	public DeclareResultCommand(Component parentComponent, String message) {
		this.component = parentComponent;
		this.message = message;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(component, message);
	}

}
