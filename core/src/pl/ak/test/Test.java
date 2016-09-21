package pl.ak.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Test extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture ocean;
	GameObject gracz;
	float w;
	float h;

	@Override
	public void create () {
		batch = new SpriteBatch();
		ocean = new Texture("ocean.png");
		img = new Texture("Ryb3.png");
		gracz = new GameObject(img);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

	}

	@Override
	public void render () {
		update();

		Gdx.gl.glClearColor(1, 1, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(ocean,0,0);
		gracz.getSprajt().draw(batch);


		batch.draw(gracz.getTekstura(),gracz.getPolozenie().x,gracz.getPolozenie().y);


		batch.end();
	}

	private void update() {

		ogarnijKlawisze();
		gracz.ogranijRybke();
	}

	private void ogarnijKlawisze() {
		if(Gdx.input.isKeyPressed(Keys.W)){
			gracz.ZmienPredkosc(0.0f,1.0f);

		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			gracz.ZmienPredkosc(0.0f,-1.0f);

		}
		if(Gdx.input.isKeyPressed(Keys.A)){
			gracz.ZmienPredkosc(-1.0f,0.0f);

		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			gracz.ZmienPredkosc(1.0f,0.0f);

		}
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			gracz.ZmienKierunek();
			if(Gdx.input.isKeyPressed(Keys.W)){
				gracz.ZmienPolozenie(0, 1);
				if (!gracz.czyWSrodku(h, w)){
					gracz.ZmienPolozenie(0, -1);
				}
			}
			if(Gdx.input.isKeyPressed(Keys.S)){
				gracz.ZmienPolozenie(0, -1);
				if (!gracz.czyWSrodku(h, w)){
					gracz.ZmienPolozenie(0, 1);
				}
			}
			if(Gdx.input.isKeyPressed(Keys.A)){
				gracz.ZmienPolozenie(-1, 0);
				if (!gracz.czyWSrodku(h, w)){
					gracz.ZmienPolozenie(1, 0);
				}
			}
			if(Gdx.input.isKeyPressed(Keys.D)){
				gracz.ZmienPolozenie(1, 0);
				if (!gracz.czyWSrodku(h, w)){
					gracz.ZmienPolozenie(-1, 0);
				}
			}
		}
	}
		@Override
		public void dispose () {
			batch.dispose();
			img.dispose();
		}
	}
