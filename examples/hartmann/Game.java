package hartmann;

import java.awt.event.KeyEvent;

import com.kilvish.core.Sprite;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Game extends GamePane {
	
	Hartmann h;
	
	public Game() {
		super(800, 500);
		this.setFPS(55);
		
		h = new Hartmann();
		h.setLocation(11, this.getHeight()-h.getHeight());
		this.add(h);
		
		Crate c = new Crate();
		c.setLocation(this.getWidth()-c.getWidth(), 
				      this.getHeight()-c.getHeight());
		this.add(c);
		
		SmallCrate cs = new SmallCrate();
		cs.setLocation(c.getX()-cs.getWidth()-100, 
				       this.getHeight()-cs.getHeight());
		this.add(cs);
	}

	public void update(){
		if(isKeyDown(KeyEvent.VK_RIGHT)){
			h.setCurrentAnimation("right");
			h.moveBy(2, 0);
		}else if(isKeyDown(KeyEvent.VK_LEFT)){
			h.setCurrentAnimation("left");
			h.moveBy(-2, 0);
		} else
			h.setCurrentAnimation("idle");
		
		Sprite c;
		if((c=h.collidingWithSome("crate")) != null)
			h.placeLeftOf(c, 0);
		
		if(h.getX()<10)
			this.shiftScreenBy(this.getWidth()-120, 0);
		else if(h.getX()+h.getWidth()>this.getWidth()-10)
			this.shiftScreenBy(-(this.getWidth()-120), 0);
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		new GameWindow(g).setTitle("Hartmann");;
		g.play();
	}

}