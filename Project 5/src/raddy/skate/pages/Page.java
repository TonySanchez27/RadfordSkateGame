package raddy.skate.pages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Page {
protected OrthographicCamera cam;
//protected OrthographicCamera menuCam;
protected Vector3 mouse;
protected PageManager pagemanager;

protected Page(PageManager pagemanager) {
	this.pagemanager = pagemanager;
	cam = new OrthographicCamera();
	mouse = new Vector3();
	//menuCam = new OrthographicCamera();
	
}
protected abstract void input();
public abstract void update(float dt);
public abstract void render(SpriteBatch sb);
public abstract void dispose();
}
