package jerrychin.resource;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import jerrychin.exception.ResourceNotFoundException;
import jerrychin.logging.LoggingException;

public class ResourceFactoryProducer {
	public static ResourceFactory getResourceFactory(String name) {
		if(name.equalsIgnoreCase("image")){
			return new ImageResourceFactory();
	    }else if(name.equalsIgnoreCase("audio")){
	        return new AudioResourceFactory();
	    }
		
		return null;
	}
}

class ImageResource implements Resource {
	private static final Map<String, ImageIcon> imageResource = new HashMap<String, ImageIcon>();
	
	ImageResource() {
		if(getClass().getResource("/images/nought.png") == null)
			LoggingException.Logging(new ResourceNotFoundException("/images/nought.png missing"));
		imageResource.put("nought", new ImageIcon(getClass().getResource("/images/nought.png")));
		imageResource.put("cross", new ImageIcon(getClass().getResource("/images/cross.png")));
		imageResource.put("chessboard", new ImageIcon(getClass().getResource("/images/chessboard.png")));
		imageResource.put("stat", new ImageIcon(getClass().getResource("/images/stat.png")));
	}
	
	@Override
	public Object getElement(String name) {
		// TODO Auto-generated method stub
		return imageResource.get(name);
	}
}

class ImageResourceFactory implements ResourceFactory {
	private static final ImageResource imageResource = new ImageResource();
	
	@Override
	public Resource getResource() {
		// TODO Auto-generated method stub
		return imageResource;
	}
}

class AudioResource implements Resource {
	private static final Map<String, String> audioResource = new HashMap<String, String>();

	AudioResource() {
		audioResource.put("click", "/audio/click.mp3");
		audioResource.put("draw", "/audio/draw.mp3");
		audioResource.put("success", "/audio/success.mp3");
		audioResource.put("failure", "/audio/failure.mp3");
	}
	
	@Override
	public Object getElement(String name) {
		// TODO Auto-generated method stub
		return audioResource.get(name);
	}
}

class AudioResourceFactory implements ResourceFactory {
	private static final AudioResource audioResource = new AudioResource();
	
	@Override
	public Resource getResource() {
		// TODO Auto-generated method stub
		return audioResource;
	}
}