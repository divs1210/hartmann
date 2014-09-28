package hartmann;

import static com.kilvish.util.MediaLoader.getBufferedImage;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.imgscalr.Scalr;

import com.kilvish.core.Actor;
import com.kilvish.core.Animation;

public class Hartmann extends Actor {
	
	int energy, goodness;
	
	final static BufferedImage sheet = getBufferedImage("media/hartmann/boy.png");
	
	final static Animation idle, right, left;
	
	static{
		idle = new Animation("idle");
		idle.add( new ImageIcon(Scalr.crop(sheet, 0, 0, 100, 120)) );
		
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
		left.add( new ImageIcon(Scalr.crop(sheet,   0, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 120, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 240, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 360, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 480, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 600, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 720, 240, 100, 120)), 6 );
		left.add( new ImageIcon(Scalr.crop(sheet, 840, 240, 100, 120)), 6 );
	}
	
	public Hartmann() {
		super("hartmann");
		
		this.energy   = 100;
		this.goodness = 100;
		
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.CENTER);
		
		this.addAnimation(idle);
		this.addAnimation(right);
		this.addAnimation(left);
		
		this.setCurrentAnimation("idle");
	}
	
	public void update(){/*
		if(this.energy>60)
			this.setForeground(Color.GREEN);
		else if(this.energy>30)
			this.setForeground(Color.YELLOW);
		else
			this.setForeground(Color.RED);
		
		this.setText(""+this.energy);
		*/
	}

}
