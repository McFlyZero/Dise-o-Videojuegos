package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private TextureRegion region;
	private Sprite miSprite;
	private float posX = 50;
	private boolean cambio = false, holdD = false, holdA = false;
	private int width, height, velocidad = 100, velocidadActual = 0;

	@Override
	public void create() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		img = new Texture("mario1.png");
		region = new TextureRegion(img, 0, 0, 32, 20);
		miSprite = new Sprite(img, 0, 0, 42, 40);
		miSprite.setPosition(50, 350);
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(img, 10, 50, 100, 75);
		batch.draw(region, 10, 170, 50, 50);
		miSprite.draw(batch);

		batch.end();

		boolean derecha = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean izquierda = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		float tiempo = Gdx.graphics.getDeltaTime();

		if (derecha) {
			posX += velocidad * tiempo;
			if (velocidadActual < 30) {
				velocidadActual += 1;
				velocidad += velocidadActual;
			}
			holdD = true;
	
			if (holdA) {
				holdA = false;
				velocidadActual = 0; 
				velocidad = 100; 
			}
		} else if (holdD) {
			if (velocidadActual > 0) {
				System.out.println("Frenando derecha");
				posX += velocidad * tiempo;
				velocidadActual -= 1; 
				velocidad -= velocidadActual;
			} else {
				System.out.println("Frenado");
				velocidad = 100;
				velocidadActual = 0;
				holdD = false;
			}
		}
	
		if (izquierda) {
			posX -= velocidad * tiempo;
			if (velocidadActual < 30) {
				velocidadActual += 1;
				velocidad += velocidadActual;
			}
			holdA = true;
	
			if (holdD) {
				holdD = false;
				velocidadActual = 0;
				velocidad = 100;
			}
		} else if (holdA) {
			if (velocidadActual > 0) {
				System.out.println("Frenando izquierda");
				posX -= velocidad * tiempo;
				velocidadActual -= 1; 
				velocidad -= velocidadActual;
			} else {
				System.out.println("Frenado");
				velocidad = 100;
				velocidadActual = 0;
				holdA = false;
			}
		}
	
		miSprite.setPosition(posX, 350);
	

		// Que la velocidad, que cuado esté presinando derecha, que a partir de cierto
		// punto, que se mueva más rápido
		// Como la caminata de mario 64 caminando sobre hielo, corro hacia la derecha,
		// en cierto punto corre más rapido y luego yo
		// cambio suelto la tecla va desacelerando hasta que se detiene

	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
