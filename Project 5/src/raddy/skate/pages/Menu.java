package raddy.skate.pages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import raddy.skate.Project5;

public class Menu extends Page{
	

	private Texture background;
	private Texture play;
	private Texture title;
	private Texture level1title;
	private Texture level2title;
	private Texture level3title;
	private Texture level4title;
	private Texture level5title;
	private Texture level6title;
	private Texture level7title;
	
	public Menu(PageManager pagemanager) {
		super(pagemanager);
		//cam = new OrthographicCamera();
		//menuCam.setToOrtho(false, Project5.WIDTH, Project5.HEIGHT);
		background = new Texture("kyle.png");
		play = new Texture("play.png");
		title = new Texture("title.png");
		level1title = new Texture("level1title.png");
		level2title = new Texture("level2title.png");
		level3title = new Texture("level3title.png");
		level4title = new Texture("level4title.png");
		level5title = new Texture("level5title.png");
		level6title = new Texture("level6title.png");
		level7title = new Texture("level7title.png");
		
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		if(Gdx.input.justTouched()) {
			pagemanager.set(new Game(pagemanager));
			dispose();
		}
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		input();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		// TODO Auto-generated method stub
		sb.begin();
		sb.draw(background, 0, 0, Project5.WIDTH, Project5.HEIGHT);
		sb.draw(title, 0, 600, Project5.WIDTH, 100);
		sb.draw(level1title, 10, 500, 300, 80);
		sb.draw(level2title, 10, 450, 300, 80);
		sb.draw(level3title, 10, 400, 300, 80);
		sb.draw(level4title, 10, 350, 300, 80);
		sb.draw(level5title, 10, 300, 300, 80);
		sb.draw(level6title, 10, 250, 300, 80);
		sb.draw(level7title, 10, 200, 300, 80);
		sb.draw(play, (Project5.WIDTH / 2) - (play.getWidth() / 2), Project5.HEIGHT / 2);
		sb.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		background.dispose();
		play.dispose();
		
	}
}
