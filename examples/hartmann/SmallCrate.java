package hartmann;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.media.ImageControl;
import com.kilvish.util.MediaLoader;

public class SmallCrate extends Sprite {

	final static ImageIcon img;
	
	static{
		BufferedImage _img = MediaLoader.getBufferedImage("media/hartmann/crate.jpg");
		img = new ImageIcon(ImageControl.scaleToFit(_img, 110, 110));
	}
	
	public SmallCrate() {
		super("Scrate");
		this.addImage(img);
	}

}