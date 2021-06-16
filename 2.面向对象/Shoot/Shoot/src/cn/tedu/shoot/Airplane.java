package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 小敌机 */
public class Airplane extends FlyingObject implements EnemyScore {
	private int speed; //移动速度
	/** 构造方法 */
	public Airplane(){
		super(48,50);
		speed = 2;
	}

	/** 重写step()移动 */
	public void step() {
		y+=speed;
	}
	
	int index = 1;
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		if(isLive()) {
			return Images.airs[0]; //ֱ返回第1张图片
		}else if(isDead()) {
			BufferedImage img = Images.airs[index++];
			if(index==Images.airs.length) {
				state = REMOVE;
			}
			return img; //返回爆破图
		}
		return null;
	}
	
	/** 重写getScore()得分 */
	public int getScore() {
		return 1;
	}
	
}






















