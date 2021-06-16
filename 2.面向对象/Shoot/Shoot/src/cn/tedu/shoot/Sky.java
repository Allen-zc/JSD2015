package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** 天空 */
public class Sky extends FlyingObject {
	private int speed;
	private int y1;
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}

	/** 重写step()移动 */
	public void step() {
		y+=speed;
		y1+=speed;
		if(y>=World.HEIGHT) {
			y = -World.HEIGHT;
		}
		if(y1>=World.HEIGHT) {
			y1 = -World.HEIGHT;
		}
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		return Images.sky;
	}
	
	/** 获取y1 */
	public int getY1() {
		return y1;
	}
	
}



















