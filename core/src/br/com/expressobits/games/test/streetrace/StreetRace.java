package br.com.expressobits.games.test.streetrace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Rafael
 *
 */
public class StreetRace extends Game {

	//Resolução do jogo
	public final static int WIDTH = 800;
	public final static int HEIGHT = 480;
	//Tela do jogo
	private GameScreen gameScreen;
	
	@Override
	public void create() {
		//Carrega os ativos do jogo
		Assets.load();
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose() {
		Assets.dispose();
		gameScreen.dispose();
	}
	
}
