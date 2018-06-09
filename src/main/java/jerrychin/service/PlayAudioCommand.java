package jerrychin.service;

import java.io.BufferedInputStream;
import java.io.InputStream;

import jerrychin.resource.ResourceFactoryProducer;
import jerrychin.util.SimplePlayer;

public class PlayAudioCommand implements Command{
	private SimplePlayer simplePlayer;
	
	public PlayAudioCommand(String name) {
		InputStream is = getClass().getResourceAsStream((String) ResourceFactoryProducer.getResourceFactory("audio").getResource().getElement(name));
		simplePlayer = new SimplePlayer(is);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		simplePlayer.play();
	}

}
