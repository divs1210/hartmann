package hartmann;

import static com.kilvish.util.MediaLoader.getBufferedImage;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.imgscalr.Scalr;

import com.kilvish.core.Actor;
import com.kilvish.core.Animation;
import com.kilvish.core.Sprite;
import com.kilvish.util.DragAdapter;

public class Hartmann extends Actor {
	
	int energy, goodness;
	double yvel=0;
	
	final static BufferedImage sheet = getBufferedImage("media/hartmann/boy.png");
	
	final static Animation idle, right, left, jumpright;
	
	static{
		idle = new Animation("idle");
		idle.add( new ImageIcon(Scalr.crop(sheet, 30, 0, 65, 120)) );
		
		right = new Animation("right");
		right.add( new ImageIcon(Scalr.crop(sheet,   0, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 130, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 240, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 360, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 485, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 605, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 725, 120, 100, 120)), 6 );
		right.add( new ImageIcon(Scalr.crop(sheet, 840, 120, 100, 120)), 6 );
		
		left = new Animation("left");
		left.add( new ImageIcon(Scalr.crop(sheet,  10, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 130, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 250, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 370, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 490, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 610, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 730, 240, 90, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 850, 240, 90, 120)), 6 );
		
		//615x380, 690, 480
		jumpright = new Animation("Rjump");
		jumpright.add( new ImageIcon(Scalr.crop(sheet, 615, 380, 75, 100)) );
	}
	
	public Hartmann() {
		super("hartmann");
		
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.CENTER);
		
		this.energy   = 1000;
		this.goodness = 100;
		
		this.addAnimation(idle);
		this.addAnimation(right);
		this.addAnimation(left);
		this.addAnimation(jumpright);
		
		this.setCurrentAnimation("idle");
	}
	
	public void update(){
		this.setText(""+this.energy/10);
		
		if(!this.getCurrentAnimation().equals("Rjump")){
			if(this.getY()+this.getHeight()==this.getGamePane().getHeight()){
				
			}else if(this.getY()+this.getHeight()>this.getGamePane().getHeight()){
				this.yvel = 0;
				this.setLocation(this.getX(), this.getGamePane().getHeight()-this.getHeight());
			}else{
				this.yvel+=0.05;
				this.moveBy(0, (int)yvel);
			}
		}
	}

}
