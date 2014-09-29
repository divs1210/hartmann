package hartmann;

import javax.swing.ImageIcon;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;

public class Pull extends Sprite implements Spell {

	Hartmann h;
	
	static final ImageIcon img = MediaLoader.getImageIcon("media/hartmann/push.png");
	
	public Pull(Hartmann h) {
		super("push");
		this.h = h;
		
		this.setLocation(h.getX()+h.getWidth(), 
				          h.getY()+50);
		
		this.addImage(img);
	}
	
	public void update(){
		this.moveBy(5, 0);
		h.energy -= 1;
		
		Sprite s = null;
		for(String type: this.affects()){
			s = this.collidingWithSome(type);
			if(s!=null){
				s.moveBy(-1500/(s.getWidth()+s.getHeight()), 0);
				
				h.energy += this.dEnergy();
				this.kill();
				
				break;
			}
		}
	}

	@Override
	public int dEnergy() {
		return -5;
	}

	@Override
	public int dGoodness() {
		return 0;
	}

	@Override
	public String[] affects() {
		String[] ret = {"crate", "Scrate"};
		return ret;
	}

}
