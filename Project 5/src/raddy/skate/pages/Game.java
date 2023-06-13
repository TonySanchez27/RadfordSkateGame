package raddy.skate.pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import raddy.skate.Project5;
import raddy.skate.entities.Obstacle;
import raddy.skate.entities.Skater;


public class Game extends Page{
private static final int OBSTACLE_SPACING = 700;
private static final int OBSTACLE_COUNT = 4;
public static int tries;

private Skater skater;
private Texture level1;
private Texture level2;
private Texture level3;
private Texture level4;
private Texture level5;
private Texture level6;
private Texture level7;
private BitmapFont font;

private Array<Obstacle> obstacles;

	public Game(PageManager pagemanager) {
		super(pagemanager);
		skater = new Skater(50, 500);
		// TODO Auto-generated constructor stub
		
		cam.setToOrtho(false, Project5.WIDTH / 2, Project5.HEIGHT / 2);
		level1 = new Texture("kyle.png");
		level2 = new Texture("clocks.png");
		level3 = new Texture("quad.png");
		level4 = new Texture("young.png");
		level5 = new Texture("fountain.png");
		level6 = new Texture("lib.png");
		level7 = new Texture("muse.png");
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(4,4);
		
		
		obstacles = new Array<Obstacle>();
		for(int i = 0; i <= OBSTACLE_COUNT; i++) {
			obstacles.add(new Obstacle(i * OBSTACLE_SPACING));
		}
	}

	@Override
	protected void input() {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.justTouched()) {
			skater.jump();
		}
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		input();
		skater.update(dt);
		cam.position.x = skater.getPosition().x + 200;
		
		
		for(Obstacle obstacle: obstacles) {
			if(cam.position.x - (cam.viewportWidth / 2) > obstacle.getObstaclePos().x + obstacle.getObstacle().getWidth()){
				obstacle.reposition(obstacle.getObstaclePos().x + ((150 + OBSTACLE_SPACING) * OBSTACLE_COUNT));
			}
			if(obstacle.collisionDetection(skater.getBounds())) {
				
				//cam.setToOrtho(false, Project5.WIDTH, Project5.HEIGHT);
				//cam.viewportHeight = Project5.HEIGHT;
				//cam.viewportWidth = Project5.WIDTH;
				//cam.position.x = Project5.WIDTH / 2;
				//cam.position.y = Project5.HEIGHT / 2;
				pagemanager.set(new Game(pagemanager));				
			}
			//if(obstacle.getObstacleBounds(Gdx.input.justTouched())) {
				//obstacle.reposition(obstacle.getObstaclePos().x + ((150 + OBSTACLE_SPACING) * OBSTACLE_COUNT));
			//}
			
		}
		
		
		cam.update();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(level1, 0, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(level2, 3000, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(level3, 6000, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(level4, 9000, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(level5, 12000, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(level6, 15000, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(level7, 18000, 0, cam.viewportWidth, cam.viewportHeight);
		sb.draw(skater.getTexture(), skater.getPosition().x, skater.getPosition().y);
		font.draw(sb,"Tries: " + tries, cam.viewportWidth - 200, cam.viewportHeight - 100);
		for(Obstacle obstacle: obstacles) {
		sb.draw(obstacle.getObstacle(), obstacle.getObstaclePos().x, obstacle.getObstaclePos().y);
		}
		sb.end();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
