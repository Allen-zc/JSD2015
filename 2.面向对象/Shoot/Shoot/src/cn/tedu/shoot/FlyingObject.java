package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
/** 飞行物 */
public abstract class FlyingObject{
	public static final int LIVE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	protected int state = LIVE;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;

	public FlyingObject(int width,int height){       
		this.width = width;
		this.height = height;
		Random rand = new Random();
		x = rand.nextInt(World.WIDTH-width);
		y = -height;
	}

	public FlyingObject(int width,int height,int x,int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public abstract void step();

	public abstract BufferedImage getImage();

	public boolean isLive() {
		return state==LIVE;
	}

	public boolean isDead() {
		return state==DEAD;
	}

	public boolean isRemove() {
		return state==REMOVE;
	}

	public boolean isOutOfBounds() {
		return y>=World.HEIGHT;
	}

	public boolean isHit(FlyingObject other) {
		int x1 = this.x-other.width;
		int x2 = this.x+this.width;
		int y1 = this.y-other.height;
		int y2 = this.y+this.height;
		int x = other.x;
		int y = other.y;
		
		return x>=x1 && x<=x2 
			   && 
			   y>=y1 && y<=y2;
	}

	public void goDead() {
		state = DEAD;
	}
	
}

















