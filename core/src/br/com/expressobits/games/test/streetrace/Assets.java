package br.com.expressobits.games.test.streetrace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

/**
 * Classe que gerencia os ativos do jogo.
 * Bom exemplo de gerenciamento de ativos separados da lógica
 * do jogo.com um simples método dispose
 * @author Rafael
 *
 */
public class Assets{
	public static TextureAtlas atlas;
	public static TextureRegion car;
	public static TextureRegion road;
	
	public static void load() {
		atlas = new TextureAtlas(Gdx.files.internal("images.atlas"));
		car = atlas.findRegion("car");
		road = atlas.findRegion("road");
	}
	
	public static void dispose(){
		atlas.dispose();
	}
}
