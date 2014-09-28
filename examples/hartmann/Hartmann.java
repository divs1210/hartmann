package hartmann;

import static com.kilvish.util.MediaLoader.getBufferedImage;

import java.awt.image.BufferedImage;

import com.kilvish.core.Actor;

public class Hartmann extends Actor {
	
	int energy, goodness;
	
	final static BufferedImage sheet = getBufferedImage("media/hartmann/boy.png");
	
	static{
		
	}
	
	public Hartmann() {
		super("hartmann");
		
		this.energy   = 100;
		this.goodness = 100;
	}

}
