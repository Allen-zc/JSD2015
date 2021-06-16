package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 子弹 */
public class Bullet extends FlyingObject {
	private int speed;
	public Bullet(int x,int y){
		super(8,20,x,y);
		speed = 3;
	}

	/** 重写step()移动 */
	public void step() {
		y-=speed;
	}

	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		if(isLive()) {
			return Images.bullet;
		}else if(isDead()) {
			state = REMOVE;
		}
		return null;
	}
	
	/** 检测越界 */
	public boolean isOutOfBounds() {
		return y<=-height;
	}
}



















