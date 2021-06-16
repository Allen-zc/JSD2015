package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 大敌机 */
public class BigAirplane extends FlyingObject implements EnemyScore {
	private int speed;
	public BigAirplane(){
		super(66,89);
		speed = 2;
	}
	
	/** 重写step() */
	public void step() {
		y+=speed;
	}
	
	int index = 1;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		if(isLive()) {
			return Images.bairs[0];
		}else if(isDead()) {
			BufferedImage img = Images.bairs[index++];
			if(index==Images.bairs.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/** 重写getScore() */
	public int getScore() {
		return 3;
	}
}



















