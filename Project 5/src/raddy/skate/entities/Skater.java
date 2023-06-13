package raddy.skate.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import raddy.skate.Project5;
import raddy.skate.pages.Game;

public class Skater {
	
	private static final int GRAVITY = -25;
	private static final int SPEED = 400;
private Vector3 position;
private Vector3 velocity;
private Rectangle bounds;

private Texture skater;

	public Skater(int x, int y) {
		position = new Vector3(x, y, 0);
		velocity = new Vector3(0, 0, 0);
		skater = new Texture("skater.png");
		bounds = new Rectangle(x, y, skater.getWidth(), skater.getHeight());
	}
	
	public void update(float dt) {
		if(position.y > 0) {
		velocity.add(0, GRAVITY, 0);
		}
		
		if(position.x > 18000) {
			Game.tries = 0;
		}
		
		velocity.scl(dt);
		
		position.add(SPEED * dt, velocity.y, 0);
		 if(position.x > 3000) {
			 position.add(1, velocity.y, 0);
		 }
		 if(position.x > 12000) {
			 position.add(1, velocity.y, 0);
		 }
		
		if(position.y < 0) {
			position.y = 0;
		}
		
		
		
		
		velocity.scl(1/dt);
		bounds.setPosition(position.x, position.y);
	}
	
	public Vector3 getPosition() {
		return position;
	}

	
	public Texture getTexture() {
		return skater;
	}

	public void jump(){
		if(position.y < 300) {
			if(position.x < 3000) {
				velocity.y = 500;
			}
			else if(position.x < 12000) {
				velocity.y = 400;
			}
			else {
				velocity.y = 350;
			}
		//velocity.y = 500;	
		}
	}
	public Rectangle getBounds() {
		return bounds;
	}
}
