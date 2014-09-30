package hartmann;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.kilvish.core.Sprite;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Game extends GamePane {
	
	Hartmann h;
	
	public Game() {
		super(800, 500);
		this.setFPS(80);
		this.setBackground(new Color(230, 230, 255));
		
		h = new Hartmann();
		h.setLocation(11, this.getHeight()-h.getHeight());
		this.add(h);
		
		Tree t = new Tree(2);
		t.setLocation(this.getWidth()-60, this.getHeight()-t.getHeight()+5);
		this.add(t);
		
		Crate c = new Crate();
		c.setLocation(this.getWidth()-c.getWidth()-200, 
				      this.getHeight()-c.getHeight());
		this.add(c);
		
		SmallCrate cs = new SmallCrate();
		cs.setLocation(c.getX()-cs.getWidth()-100, 
				       this.getHeight()-cs.getHeight());
		this.add(cs);
	}

	public void update(){
		//Controls
		//i. movement
		if(isKeyDown(KeyEvent.VK_RIGHT)){
			h.setCurrentAnimation("right");
			h.moveBy(2, 0);
		}else if(isKeyDown(KeyEvent.VK_LEFT)){
			h.setCurrentAnimation("left");
			h.moveBy(-2, 0);
		}else
			h.setCurrentAnimation("idle");
		//ii. powers
		if(isKeyDown(KeyEvent.VK_S) && h.energy >= 1){
			this.add(new Push(h));
			h.energy-=2;
		}else if(isKeyDown(KeyEvent.VK_A) && h.energy >= 1){
			this.add(new Pull(h));
			h.energy-=1;
		}else if(isKeyDown(KeyEvent.VK_SPACE) && h.energy >= 1){
			h.setCurrentAnimation("Rjump");
			h.moveBy(0, -2);
			h.energy-=3;
	    }
		
		//collisions
		//i. with Hartmann
		Sprite c;
		if((c=h.collidingWithSome("crate")) != null){
			if(h.isLeftTo(c,60))
				h.placeLeftOf(c, 1);
			else if(h.isRightTo(c))
				h.placeRightOf(c, 1);
			else if(h.isAbove(c)){
				h.yvel=0;
				h.placeAbove(c, 0);
			}
		}
		if((c=h.collidingWithSome("Scrate")) != null){
			if(h.isLeftTo(c))
				h.placeLeftOf(c, 1);
			else if(h.isRightTo(c))
				h.placeRightOf(c, 1);
			else if(h.isAbove(c)){
				h.yvel=0;
				h.placeAbove(c, 0);
			}
		}//b/w other stuff
		for(Sprite sc: this.getSpritesCalled("Scrate")){
			Sprite other = sc.collidingWithSome("crate");
			if(other!=null){
				if(sc.isLeftTo(other))
					sc.placeLeftOf(other, 0);
				else if(sc.isRightTo(other))
					sc.placeRightOf(other, 1);
			}
		}
		
		//pan camera
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