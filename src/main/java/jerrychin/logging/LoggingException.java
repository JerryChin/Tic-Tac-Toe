package jerrychin.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class LoggingException extends Exception {
	private static Logger logger =  Logger.getLogger("jerrychin.tictactoe");
	private static FileHandler fileHandler;
	static{
		try {
			fileHandler = new FileHandler("%h/test_%u_%g.log", 10240000, 100, true);
			fileHandler.setFormatter( new SimpleFormatter());
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			JOptionPane.showMessageDialog(null, trace.toString());
		} 
		logger.addHandler(fileHandler); 
		logger.setUseParentHandlers(true); 
	}
	
	public static void Logging(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
