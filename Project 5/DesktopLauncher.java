package skater.hop.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import raddy.skate.Project5;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Project5.WIDTH;
		config.height = Project5.HEIGHT;
		config.title = Project5.TITLE;
		new LwjglApplication(new Project5(), config);
	}
}
