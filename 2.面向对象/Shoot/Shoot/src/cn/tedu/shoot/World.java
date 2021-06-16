package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** 整个游戏窗口 */
public class World extends JPanel {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 700;
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;

	private Sky sky = new Sky();
	private Hero hero = new Hero();
	private FlyingObject[] enemies = {};
	private Bullet[] bullets = {};

	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if(type<5) {
			return new Bee();
		}else if(type<13) {
			return new Airplane();
		}else {
			return new BigAirplane();
		}
	}
	
	private int enterIndex = 0;
	public void enterAction() {
		enterIndex++;
		if(enterIndex%40==0) {
			FlyingObject obj = nextOne();
			enemies = Arrays.copyOf(enemies,enemies.length+1);
			enemies[enemies.length-1] = obj;
		}
	}

	private int shootIndex = 0;
	public void shootAction() {
		shootIndex++;
		if(shootIndex%30==0) {
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}

	public void stepAction() {
		sky.step();
		for(int i=0;i<enemies.length;i++) {
			enemies[i].step();
		}
		for(int i=0;i<bullets.length;i++) {
			bullets[i].step();
		}
	}

	public void outOfBoundsAction() {
		for(int i=0;i<enemies.length;i++) {
			if(enemies[i].isOutOfBounds() || enemies[i].isRemove()) {
				enemies[i] = enemies[enemies.length-1];
				enemies = Arrays.copyOf(enemies,enemies.length-1);
 			}
		}
		
		for(int i=0;i<bullets.length;i++) {
			if(bullets[i].isOutOfBounds() || bullets[i].isRemove()) {
				bullets[i] = bullets[bullets.length-1];
				bullets = Arrays.copyOf(bullets,bullets.length-1);
			}
		}
	}
	
	private int score = 0;
	public void bulletBangAction() {
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			for(int j=0;j<enemies.length;j++) {
				FlyingObject f = enemies[j];
				if(b.isLive() && f.isLive() && f.isHit(b)) {
					f.goDead();
					b.goDead();

					if(f instanceof EnemyScore) {
						EnemyScore es = (EnemyScore)f;
						score += es.getScore();
					}
					if(f instanceof EnemyAward) {
						EnemyAward ea = (EnemyAward)f;
						int type = ea.getAwardType();
						switch(type) {
						case EnemyAward.FIRE:
							hero.addFire();
							break;
						case EnemyAward.LIFE:
							hero.addLife();
							break;
						}
					}
				}
				
			}
		}
	}
	

	public void heroBangAction() {
		for(int i=0;i<enemies.length;i++) {
			FlyingObject f = enemies[i];
			if(f.isLive() && hero.isLive() && f.isHit(hero)) {
				f.goDead();
				hero.subtractLife();
				hero.clearFire();
			}
		}
	}
	

	public void checkGameOverAction() {
		if(hero.getLife()<=0) {
			state = GAME_OVER;
		}
	}
	

	public void action() {

		MouseAdapter m = new MouseAdapter()  {
			public void mouseMoved(MouseEvent e) {
				if(state==RUNNING) {
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);
				}
			}
			public void mouseClicked(MouseEvent e) {
				switch(state) {
				case START:
					state = RUNNING;
					break;
				case GAME_OVER:
					score = 0;
					sky = new Sky();
					hero = new Hero();
					enemies = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			public void mouseExited(MouseEvent e) {
				if(state==RUNNING) {
					state = PAUSE;
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(state==PAUSE) {
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(m);
		this.addMouseMotionListener(m);
		
		Timer timer = new Timer();
		int interval = 10;
		timer.schedule(new TimerTask() {
			public void run() {
				if(state==RUNNING) {
					enterAction();
					shootAction();
					stepAction();
					outOfBoundsAction();
					bulletBangAction();
					heroBangAction();
					checkGameOverAction();
				}
				repaint();
			}
		},interval,interval);
	}

	public void paint(Graphics g) {
		g.drawImage(sky.getImage(),sky.x,sky.y,null);
		g.drawImage(sky.getImage(),sky.x,sky.getY1(),null);
		g.drawImage(hero.getImage(),hero.x,hero.y,null);
		for(int i=0;i<enemies.length;i++) {
			FlyingObject f = enemies[i];
			g.drawImage(f.getImage(),f.x,f.y,null);
		}
		for(int i=0;i<bullets.length;i++) {
			Bullet b = bullets[i];
			g.drawImage(b.getImage(),b.x,b.y,null);
		}
		
		g.drawString("SCORE: "+score,10,25);
		g.drawString("LIFE: "+hero.getLife(),10,45);
		
		switch(state) {
		case START:
			g.drawImage(Images.start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(Images.pause,0,0,null);
			break;
		case GAME_OVER:
			g.drawImage(Images.gameover,0,0,null);
			break;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		world.action();
	}

}


















