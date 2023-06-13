package raddy.skate.pages;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PageManager {

	private Stack<Page> pages;
	
	public PageManager() {
		pages = new Stack<Page>();
	}
	
	public void pop() {
		pages.pop();
	}
	
	public void push(Page page){
		pages.push(page);
	}
	
	
	
	
	public void set(Page page) {
		pages.pop();
		pages.push(page);
		Game.tries += 1;
	}
	public void update(float dt) {
		pages.peek().update(dt);
	}
	public void render(SpriteBatch sb) {
		pages.peek().render(sb);
	}
}
