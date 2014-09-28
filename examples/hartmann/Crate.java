package hartmann;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Crate extends Sprite {

	final static ImageIcon img = MediaLoader.getImageIcon("media/hartmann/crate.jpg");
	
	public Crate() {
		super("crate");
		this.addImage(img);
	}

}