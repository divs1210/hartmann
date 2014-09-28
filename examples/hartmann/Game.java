package hartmann;

import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Game extends GamePane {
	
	Hartmann h;
	Crate c;
	
	public Game() {
		super(800, 500);
		this.setFPS(55);
		
		h = new Hartmann();
		h.setLocation(11, this.getHeight()-h.getHeight());
		this.add(h);
		
		c = new Crate();
		c.setLocation(300, this.getHeight()-c.getHeight());
		this.add(c);
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
		
		
		if(c.has(h))
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