package raddy.skate.entities;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Obstacle {

	private Texture obstacle;
	private Vector2 obstaclePos;
	private Random rand;
	private Rectangle obstacleBounds;
	private static final int RANGE = 200;
	
	public Obstacle(float x) {
		obstacle = new Texture("obstacle.png");
		rand = new Random();
		
		obstaclePos = new Vector2(x,rand.nextInt(RANGE));
		obstacleBounds = new Rectangle(obstaclePos.x, obstaclePos.y, obstacle.getWidth(), obstacle.getHeight());
	}

	public Rectangle getObstacleBounds() {
		return obstacleBounds;
	}

	public Texture getObstacle() {
		return obstacle;
	}

	public Vector2 getObstaclePos() {
		return obstaclePos;
	}
	
	public void reposition(float x){
		obstaclePos.set(x,rand.nextInt(RANGE));
		obstacleBounds.setPosition(obstaclePos.x, obstaclePos.y);
	}
	public boolean collisionDetection(Rectangle player) {
		return player.overlaps(obstacleBounds);
	}
	
}
