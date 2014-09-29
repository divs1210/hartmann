package hartmann;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Tree extends Sprite {

	int type;

	static final ImageIcon img1 = MediaLoader.getImageIcon("media/hartmann/tree1.png"),
			                 img2 = MediaLoader.getImageIcon("media/hartmann/tree2.png"),
					         img3 = MediaLoader.getImageIcon("media/hartmann/tree3.png");
	
	public Tree(int type) {
		super("tree");
		this.type = type;
		
		ImageIcon img=null;
		switch(type){
			case 0: img=img1; break;
			case 1: img=img2; break;
			case 2: img=img3;
		}
		this.addImage(img);
	}

}
