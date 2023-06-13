package raddy.skate;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import raddy.skate.pages.Menu;
import raddy.skate.pages.PageManager;

public class Project5 extends ApplicationAdapter {
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 800;
	
	public static final String TITLE = "RADFORD SKATE";
	private PageManager pagemanager;
	
	private SpriteBatch batch;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		pagemanager = new PageManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		pagemanager.push(new Menu(pagemanager));
	}

	@Override
	public void render () {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		pagemanager.update(Gdx.graphics.getDeltaTime());
		pagemanager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	//	img.dispose();
	}
}
