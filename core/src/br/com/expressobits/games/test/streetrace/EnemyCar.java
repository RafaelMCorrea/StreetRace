package br.com.expressobits.games.test.streetrace;


//import static com.badlogic.gdx.scenes.scene2d.actions.Action.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class EnemyCar extends Actor{
	private Rectangle bounds = new Rectangle();
	
	public EnemyCar(float x,float y){
		setWidth(160);
		setHeight(85);
		setPosition(x,y-getHeight()/2);
		
		int rnd = MathUtils.random(0,3);
		if(rnd ==0 ) setColor(Color.RED);
		if(rnd ==1 ) setColor(Color.GREEN);
		if(rnd ==2 ) setColor(Color.WHITE);
		if(rnd ==3 ) setColor(Color.BLUE);
		
		addAction(Actions.moveTo(-getWidth(),getY(),MathUtils.random(4.0f,6.0f)));
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		updateBounds();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.setColor(getColor().r,getColor().g, getColor().b, getColor().a);
		batch.draw(Assets.car,getX(),getY(),getWidth()/2,getHeight()/2,getWidth(),getHeight(),1,1,getRotation());
	}
	
	public void updateBounds(){
		bounds.set(getX(),getY(),getWidth(),getHeight());
	}
	
	public void crash(boolean front, boolean above) {
		clearActions();
		addAction(Actions.fadeOut(1f));
		if (front && above){
			addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(-360f,1.5f), Actions.moveBy(200, 200, 1.5f)), Actions.removeActor()));
		}
		if (front && !above) addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(360f, 1.5f), Actions.moveBy(200, -200, 1.5f)), Actions.removeActor()));
		if (!front && above) addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(360f, 1.5f), Actions.moveBy(-200, 200, 1.5f)), Actions.removeActor()));
		if (!front && !above) addAction(Actions.sequence(Actions.parallel(Actions.rotateBy(-360f, 1.5f), Actions.moveBy(-200, -200, 1.5f)), Actions.removeActor()));
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
