package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 英雄机 */
public class Hero extends FlyingObject {
	private int life; //命
	private int fire; //火力值

	public Hero(){
		super(97,139,140,400);
		life = 3;
		fire = 0;
	}

	/** 重写step()移动 */
	public void step() {
	}
	
	int index = 0;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		return Images.heros[index++%Images.heros.length];
	}
	
	/** 发射子弹 */
	public Bullet[] shoot() {
		int xStep = this.width/4;
		int yStep = 20;
		if(fire>0) {
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x+1*xStep, this.y-yStep);
			bs[1] = new Bullet(this.x+3*xStep, this.y-yStep);
			fire -= 2;
			return bs;
		}else {
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep, this.y-yStep);
			return bs;
		}
	}
	
	/** 随着鼠标移动*/
	public void moveTo(int x,int y) {
		this.x = x-this.width/2;
		this.y = y-this.height/2;
	}

	public void addLife() {
		life++;
	}

	public int getLife() {
		return life;
	}

	public void subtractLife() {
		life--;
	}

	public void addFire() {
		fire+=40;
	}

	public void clearFire() {
		fire=0;
	}
	
}





















