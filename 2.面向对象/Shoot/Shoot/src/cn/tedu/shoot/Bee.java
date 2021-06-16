package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
/** 小蜜蜂 */
public class Bee extends FlyingObject implements EnemyAward {
	private int xSpeed; //x移动速度
	private int ySpeed; //y移动速度
	private int awardType; //奖励类型
	/** 构造方法 */
	public Bee(){
		super(60,51);
		xSpeed = 1;
		ySpeed = 2;
		Random rand = new Random();
		awardType = rand.nextInt(2);
	}
	
	/** 重写step()移动 */
	public void step() {
		x+=xSpeed;
		y+=ySpeed;
		if(x<=0 || x>=World.WIDTH-width) {
			xSpeed*=-1;
		} 
	}
	
	int index = 1;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		if(isLive()) {
			return Images.bees[0];
		}else if(isDead()) {
			BufferedImage img = Images.bees[index++];
			if(index==Images.bees.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	/** 重写getAwardType() */
	public int getAwardType() {
		return awardType;
	}
}





















