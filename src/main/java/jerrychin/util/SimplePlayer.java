package jerrychin.util;

import java.io.InputStream;

import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import jerrychin.logging.LoggingException;

public class SimplePlayer {
	private Player playMP3;
    public SimplePlayer(InputStream is){
        try{
        	if(DEBUG.debug)
        		JOptionPane.showMessageDialog(null, is);
             playMP3 = new Player(is);
        }  catch(Exception e){
			 LoggingException.Logging(e);
        }

    } 
    
    public void play() {
    	try {
			playMP3.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}